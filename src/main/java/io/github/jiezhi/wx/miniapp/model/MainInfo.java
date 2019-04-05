package io.github.jiezhi.wx.miniapp.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-28 17:11
 * Function:
 */
@Data
@Builder
@Entity
public class MainInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @UniqueElements
    private int uid;
    private String appid;
    private String app_name;
    private String he;
    private String she;
    private String he_tel;
    private String she_tel;
    private String date;
    private String lunar;
    private String music;
    private String address;
    private String hotel;
    private double lat;
    private double lng;
    private String share;
    private String cover;
    private String qrimg;
    private String thumb;
    private String code;
}
