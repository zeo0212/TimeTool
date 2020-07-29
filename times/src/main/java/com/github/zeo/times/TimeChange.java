package com.github.zeo.times;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zeo
 */
public class TimeChange {
    private static TimeChange timeUtil = null;
    public final String TimeChange_TYPE = "yyyy-MM-dd HH:mm:ss";

    static {
        timeUtil = new TimeChange();
    }

    public static TimeChange getInstanceSafe() {
        return timeUtil;
    }


    public String getTimeStr(long mTime) {
        return getTimeStr(null, null, null, mTime);
    }

    public String getTimeStr(long mTime, String mFormat) {
        return getTimeStr(null, mFormat, null, mTime);
    }


    public String getTimeStr(String mTime) {
        return getTimeStr(mTime, null, null, 0);
    }


    /**
     * @param time    时间
     * @param mFormat 返回的时间格式  时间格式化  需要的分隔符号。
     * @return
     */
    public String getTimeStr(String time, String mFormat, String mTypeTime, long mTime) {
        int strTime = 0;
        mFormat = TextUtils.isEmpty(mFormat) ? TimeChange_TYPE : mFormat;

        if (TextUtils.isEmpty(time) && mTime == 0) {
            mTime = System.currentTimeMillis();
        }
        long currentTime;
        if (mTime == strTime) {
            currentTime = strTime;
            Date date;
            try {
                if (TextUtils.isEmpty(mTypeTime)) {
                    date = new SimpleDateFormat(TimeChange_TYPE).parse(time);
                } else {
                    date = new SimpleDateFormat(mTypeTime).parse(time);
                }
                currentTime = date.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            currentTime = mTime;
        }
        return new SimpleDateFormat(mFormat).format(currentTime);
    }


    public long getTimemIllisecond(String time) {
        return getTimemIllisecond(time, null);
    }


    /**
     * @param time 时间
     * @return
     */
    public long getTimemIllisecond(String time, String mTypeTime) {
        long strTime = System.currentTimeMillis();
        if (TextUtils.isEmpty(time)) {
            return strTime;
        }
        long currentTime = strTime;
        Date date;
        try {
            if (TextUtils.isEmpty(mTypeTime)) {
                date = new SimpleDateFormat(TimeChange_TYPE).parse(time);
            } else {
                date = new SimpleDateFormat(mTypeTime).parse(time);
            }
            currentTime = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentTime;
    }


    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public String getWeek(String pTime) {

        String Week = "周";

        SimpleDateFormat format = new SimpleDateFormat(TimeChange_TYPE);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "六";
        }

        return Week;
    }


    /**
     * 时间戳    格式   2008-08-08 08:08:08
     *
     * @param time
     * @return
     */
    public String getTimeLossStr(String time, String mTypeTime) {
        mTypeTime = TextUtils.isEmpty(mTypeTime) ? "yyyy-MM-dd HH:mm:ss" : mTypeTime;
        String str = "";
        Calendar c = Calendar.getInstance();
        long xianzaiTime = System.currentTimeMillis();
        long huidaTime = 0;
        try {
            c.setTime(new SimpleDateFormat(mTypeTime).parse(time));
            huidaTime = c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
            return str = time.substring(5, time.length() - 3);
        }
        long shijiancha = xianzaiTime - huidaTime;
        long day = shijiancha / (3600000 * 24);
        if (day < 1) {
            long mtime = shijiancha / (3600000);
            str = mtime + "小时前";
            if (mtime < 1) {
                long branch = shijiancha % 3600000 / 60000;
                str = branch + "分钟前";
                if (branch < 1) {
                    long second = shijiancha % 60000 / 1000;
                    str = "刚刚";
                }
            }
        } else {
            str = day + "天前";
        }
        return str;
    }

}
