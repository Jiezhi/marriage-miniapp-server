package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-30 16:04
 * Function:
 */
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Location getLocationByUid(int uid);
}
