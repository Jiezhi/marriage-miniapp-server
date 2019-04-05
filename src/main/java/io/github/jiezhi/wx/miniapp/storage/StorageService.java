package io.github.jiezhi.wx.miniapp.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-04-01 13:42
 * Function:
 * <p>
 * Ref:https://spring.io/guides/gs/uploading-files/
 */
public interface StorageService {
    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
