package io.github.jiezhi.wx.miniapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-31 22:35
 * Function:
 */
public class TimeUtils {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getNowString() {
        return dateFormat.format(new Date());
    }
}
