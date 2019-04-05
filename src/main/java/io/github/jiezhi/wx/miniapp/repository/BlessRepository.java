package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.Bless;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-30 16:12
 * Function:
 */
public interface BlessRepository extends CrudRepository<Bless, Integer> {
    List<Bless> getAllByUid(int uid);
    boolean existsByAvatarUrl(String url);
}
