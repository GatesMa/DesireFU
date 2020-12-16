package cn.gatesma.desirefu.utils;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public class TimeUtils {

    public static Date convertStringToDate(String strFmtDate, SimpleDateFormat sdf) {

        if (Strings.isNullOrEmpty(strFmtDate) || null == sdf)
            return null;

        try {
            sdf.setLenient(false);
            return sdf.parse(strFmtDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static Timestamp convertStringToTimestamp(String strFmtDate, SimpleDateFormat sdf) {
        Date date = convertStringToDate(strFmtDate, sdf);
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Timestamp convertStringToTimestamp(String strFmtDate) {
        Date date = convertStringToDate(strFmtDate);
        return date == null ? null : new Timestamp(date.getTime());
    }

    public static Date convertStringToDate(String strFmtDate) {
        if (StringUtils.isBlank(strFmtDate)) {
            return null;
        }
        try {
            return DateUtils.parseDate(strFmtDate, "yyyy-MM-dd", "yyyyMMdd", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            return null;
        }
    }

    public static String convertDateToString(Date date, SimpleDateFormat sdf) {
        return (date == null || sdf == null) ? null : sdf.format(date);
    }

    public static Long convertDateToSecondsLong(Date date) {
        if (date != null) {
            return date.getTime() / 1000L;
        } else {
            return null;
        }
    }

    public static Integer convertDateToSeconds(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime() / 1000L).intValue();
        } else {
            return null;
        }
    }

    public static Date convertSecondsToDate(Integer seconds) {
        return seconds == null || seconds == 0 ? null : new Date(seconds * 1000L);
    }

    public static String convertUnixTimeToFmtString(long unixTimestamp, SimpleDateFormat sdf) {
        return convertDateToString(new Date(unixTimestamp), sdf);
    }

    public static String convertSecondsToDateStr(Long seconds, SimpleDateFormat sdf) {
        if (null == seconds || seconds == 0L || null == sdf)
            return null;

        return sdf.format(new Date(seconds * 1000));
    }

    public static String convertSecondsToFmtString(Integer seconds, SimpleDateFormat sdf) {
        return seconds == null || seconds == 0 ? null : convertDateToString(convertSecondsToDate(seconds), sdf);
    }

    public static Long convertDateToMillSeconds(Date date) {
        return date == null ? null : date.getTime();
    }

    public static Date convertMillSecondsToDate(Long milliSeconds) {
        return milliSeconds == null || milliSeconds == 0 ? null : new Date(milliSeconds);
    }

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String convertTimestampToStr(Timestamp timestamp, SimpleDateFormat sdf) {

        if (null == timestamp || null == sdf)
            return "";

        return sdf.format(timestamp);
    }

    public static SimpleDateFormat getTimeStampFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static Integer convertStringToSeconds(String strFmtDate) {
        Date date = convertStringToDate(strFmtDate);
        return convertDateToSeconds(date);
    }
}

