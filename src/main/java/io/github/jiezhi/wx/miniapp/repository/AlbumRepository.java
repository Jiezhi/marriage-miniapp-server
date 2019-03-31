package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-30 15:32
 * Function:
 */
public interface AlbumRepository extends CrudRepository<Photo, Integer> {
    List<Photo> findAllByUid(int uid);
}
