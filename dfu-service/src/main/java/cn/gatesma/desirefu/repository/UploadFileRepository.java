package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.UPLOADFILE_;

/**
 * User: gatesma
 * Date: 2021/1/13 1:06 下午
 * Desc:
 */
@Repository
public class UploadFileRepository {

    @Resource
    private DSLContext dslContext;


    public int createUploadFile(String fileType, Long accountId, int accountType, String fileName, String fileURL) {
        Timestamp now = TimeUtils.now();
        return dslContext.insertInto(
                    UPLOADFILE_,
                    UPLOADFILE_.FILETYPE,
                    UPLOADFILE_.ACCOUNTID,
                    UPLOADFILE_.ACCOUNTTYPE,
                    UPLOADFILE_.FILENAME,
                    UPLOADFILE_.FILEURL,
                    UPLOADFILE_.DELETESTATUS,
                    UPLOADFILE_.CREATEDTIME,
                    UPLOADFILE_.LASTMODIFIEDTIME)
                .values(
                        fileType,
                        accountId,
                        accountType,
                        fileName,
                        fileURL,
                        DeleteStatus.NORMAL.code(),
                        now,
                        now)
                .execute();
    }


}
