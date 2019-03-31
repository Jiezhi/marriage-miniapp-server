package io.github.jiezhi.wx.miniapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-31 14:41
 * Function:
 */
@Data
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int uid;
    private String appid;
    private String nickname;
    private String face;
    private String name;
    private String tel;
    private String plan;
    private String extra;
}
