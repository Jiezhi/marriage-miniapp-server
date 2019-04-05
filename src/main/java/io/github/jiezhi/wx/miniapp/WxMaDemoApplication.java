package io.github.jiezhi.wx.miniapp;

import io.github.jiezhi.wx.miniapp.config.StorageProperties;
import io.github.jiezhi.wx.miniapp.model.*;
import io.github.jiezhi.wx.miniapp.repository.*;
import io.github.jiezhi.wx.miniapp.storage.StorageService;
import io.github.jiezhi.wx.miniapp.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WxMaDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(WxMaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WxMaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
