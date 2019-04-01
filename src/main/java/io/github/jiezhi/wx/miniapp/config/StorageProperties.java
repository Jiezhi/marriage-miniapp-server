package io.github.jiezhi.wx.miniapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-04-01 14:04
 * Function:
 */
@ConfigurationProperties("storage")
@Data
public class StorageProperties {
    private String location = "upload-dir";

}
