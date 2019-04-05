package io.github.jiezhi.wx.miniapp.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-28 17:21
 * Function:
 */
@Data
@Builder
public class AllData implements Serializable {
    private MainInfo mainInfo;
    private Bless zanLog;
    private int zanNum;
    private List<Photo> album;
    private String music_url;
    private List<Comment> chatList;
    private int chatNum;
    private Location location;
}
