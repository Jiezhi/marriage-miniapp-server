package io.github.jiezhi.wx.miniapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-28 17:19
 * Function:
 */
@Data
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int uid;
    private String nickname;
    private String face;
    private String words;
    private String time;
}
