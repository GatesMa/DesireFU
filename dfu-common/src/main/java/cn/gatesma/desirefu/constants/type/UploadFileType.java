package cn.gatesma.desirefu.constants.type;

/**
 * User: gatesma
 * Date: 2021/1/13 4:20 下午
 * Desc:
 */
public enum UploadFileType {

    PDF,
    IMG,
    PPT;

    public static UploadFileType parse(String fileType) {
        for (UploadFileType type : UploadFileType.values()) {
            if (type.name().equalsIgnoreCase(fileType)) {
                return type;
            }
        }
        return null;
    }

}
