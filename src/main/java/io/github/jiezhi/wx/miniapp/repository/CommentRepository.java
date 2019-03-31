package io.github.jiezhi.wx.miniapp.repository;

import io.github.jiezhi.wx.miniapp.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-30 16:20
 * Function:
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> getAllByUid(int uid);
}
