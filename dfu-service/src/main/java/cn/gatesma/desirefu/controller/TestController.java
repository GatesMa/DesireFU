package cn.gatesma.desirefu.controller;

import cn.gatesma.desirefu.constant.EsConst;
import cn.gatesma.desirefu.service.EsService;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gatesma
 * @date 2020/11/1
 * @desc
 */
@Controller
public class TestController {

    @Resource
    private EsService esService;

    @RequestMapping("/test_es")
    @ResponseBody
    public void testEs() {

        SearchResponse searchResponse = esService.queryFromES(EsConst.DESIREFU_SERVICE_INDEX, EsConst.INDEX_TYPE_NORMAL_ACCOUNT, null, null, null, 0, 10);
        System.out.println(searchResponse);
    }


}
