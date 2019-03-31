package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.Attendance;
import org.springframework.data.repository.CrudRepository;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-31 14:43
 * Function:
 */
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
