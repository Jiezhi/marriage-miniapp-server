package io.github.jiezhi.wx.miniapp.model;

import lombok.Builder;
import lombok.Data;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-31 12:16
 * Function:
 */
@Data
@Builder
public class Result {
    private boolean success;
    private String msg;
    private Object obj;
}
