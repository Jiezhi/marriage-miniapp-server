package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.MainInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-29 12:00
 * Function:
 */
public interface MainInfoRepository extends CrudRepository<MainInfo, Integer> {
    MainInfo findMainInfoByUid(int uid);
}
