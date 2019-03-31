package io.github.jiezhi.wx.miniapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-31 21:21
 * Function:
 */
@Data
@Entity
public class WxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int uid;
    private String nickName;
    private String avatarUrl;
    private String city;
    private String country;
    private String gender;
    private String language;
    private String province;
}
