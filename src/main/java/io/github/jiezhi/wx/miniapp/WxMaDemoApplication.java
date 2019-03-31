package io.github.jiezhi.wx.miniapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@SpringBootApplication
public class WxMaDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(WxMaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WxMaDemoApplication.class, args);
    }

}
