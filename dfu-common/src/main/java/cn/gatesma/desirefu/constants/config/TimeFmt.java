package cn.gatesma.desirefu.constants.config;

import java.text.SimpleDateFormat;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public class TimeFmt {

    public static SimpleDateFormat getDateFmt() {
        return  new SimpleDateFormat("yyyy-MM-dd");
    }
    public static SimpleDateFormat getDateFmt8(){
        return  new SimpleDateFormat("yyyyMMdd");
    }
    public static SimpleDateFormat getHourFmt() {
        return new SimpleDateFormat("yyyy-MM-dd HH");
    }
    public static SimpleDateFormat getHourFmt10(){
        return new SimpleDateFormat("yyyyMMddHH");
    }
    public static SimpleDateFormat getTimeFmt() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public static SimpleDateFormat getTimeFmtBegin() {
        return new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    }
    public static SimpleDateFormat getTimeFmtBegin14(){
        return new SimpleDateFormat("yyyyMMdd000000");
    }
    public static SimpleDateFormat getTimeFmtEnd() {
        return new SimpleDateFormat("yyyy-MM-dd 23:59:59");
    }
    public static SimpleDateFormat getTimeFmtEnd14() {
        return new SimpleDateFormat("yyyyMMdd235959");
    }

}
