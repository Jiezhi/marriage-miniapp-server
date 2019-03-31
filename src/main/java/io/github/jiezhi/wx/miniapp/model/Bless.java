package io.github.jiezhi.wx.miniapp.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-28 17:17
 * Function:
 */
@Data
@Entity
public class Bless implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int uid;
    private String openid;
    private String face;
    private String nickname;
    private String time;
}
