package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constant.EsConst;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * User: gatesma
 * Date: 2021/3/30 6:06 下午
 * Desc:
 */
@Service
public class EsService {

    private Logger LOOGER = LoggerFactory.getLogger(EsService.class);

    private static final String KEEP_ALIVE = "600s";

    private final static TimeValue TIME_OUT_VALUE = new TimeValue(5, TimeUnit.SECONDS);

    private static Client client = null;

    private static final int DEFAULT_TIMEOUT = 5000;

    private static final int DEFAULT_RETRY_TIME = 3;

    @Resource
    private Client esClient;

    public DeleteResponse deleteEsDoc(String index, String type, String docId) {
        LOOGER.info("deleteEsDoc index = {}, type = {}, docId = {}", index, type, docId);
        for (int time = 0; time < DEFAULT_RETRY_TIME; time++) {
            long startTime = System.currentTimeMillis();

            try {
                return esClient
                        .prepareDelete(index, type, docId)
                        .setTimeout(TimeValue.timeValueMillis(DEFAULT_TIMEOUT))
                        .get();
            } catch (Exception e) {
                LOOGER.error("deleteEsDoc index = {}, type = {}, docId = {} ", index, type, docId, e);
            } finally {
                LOOGER.info("deleteEsDoc index = {}, type = {}, docId = {}, cost time = {}", index, type, docId, System.currentTimeMillis() - startTime);
            }
        }
        return null;
    }

    public UpdateResponse upsertNormalAccount(long accountId, Map<String, Object> dataMap) {
        return upsertDoc(EsConst.DESIREFU_SERVICE_INDEX, EsConst.INDEX_TYPE_NORMAL_ACCOUNT, String.valueOf(accountId), dataMap);
    }

    public UpdateResponse upsertOrganize(long organizeId, Map<String, Object> dataMap) {
        return upsertDoc(EsConst.DESIREFU_SERVICE_INDEX, EsConst.INDEX_TYPE_ORGANIZE, String.valueOf(organizeId), dataMap);
    }

    private UpdateResponse upsertDoc(String index, String type, String docId, Map<String, Object> dataMap) {
        LOOGER.info("upsertDoc index = {}, type = {}, docId = {}, dataMap = {}", index, type, docId, dataMap);

        for (int time = 0; time < DEFAULT_RETRY_TIME; time++) {
            long startTime = System.currentTimeMillis();

            try {
                return esClient
                        .prepareUpdate(index, type, docId)
                        .setDocAsUpsert(true)
                        .setDoc(dataMap)
                        .setTimeout(TimeValue.timeValueMillis(DEFAULT_TIMEOUT))
                        .setRetryOnConflict(
                                1) // fix并行更新索引时的VersionConflictEngineException,这个fix仅适用于partialUpdate的场景
                        .execute()
                        .actionGet();
            } catch (Exception e) {
                LOOGER.error("upsertDoc fail: index = {}, type = {}, docId = {}, dataMap = {}", index, type, docId, dataMap, e);
            } finally {
                LOOGER.info("upsertDoc index = {}, type = {}, docId = {}, cost time = {}", index, type, docId, System.currentTimeMillis() - startTime);
            }
        }
        return null;
    }

    /**
     * 查询ES接口
     */
    public SearchResponse queryFromES(String index, String type, QueryBuilder queryBuilder,
                                                             String[] includes, String[] excludes, int offset, int limit) {
        long startTime = System.currentTimeMillis();
        SearchResponse response = null;
        try {
            SearchRequestBuilder requestBuilder = esClient.prepareSearch(index)
                    .setTypes(new String[]{type})
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setFrom(offset)
                    .setSize(limit)
                    .setExplain(false)
                    .setTimeout(TIME_OUT_VALUE);

            if (null != queryBuilder) {
                requestBuilder.setQuery(queryBuilder);
            }

            if (null != includes || null != excludes) {
                requestBuilder.setFetchSource(includes, excludes);
            }

            response = requestBuilder.execute().actionGet();

        } catch (Exception e) {
            LOOGER.error("查询ES type {} builder {} includes {} excludes {} offset {} limit {} 异常 ",
                    type, queryBuilder, includes, excludes, offset, limit, e);
        } finally {
            LOOGER.info("queryFromES type {} builder {} includes {} excludes {} offset {} limit {} cost time = {}",
                    type, queryBuilder, includes, excludes, offset, limit, System.currentTimeMillis() - startTime);
        }

        return response;
    }

}
