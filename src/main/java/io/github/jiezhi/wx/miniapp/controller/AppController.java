package io.github.jiezhi.wx.miniapp.controller;

import io.github.jiezhi.wx.miniapp.model.*;
import io.github.jiezhi.wx.miniapp.repository.*;
import io.github.jiezhi.wx.miniapp.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Project: weixin-java-miniapp-demo
 * Author: jiezhi
 * Date: 2019-03-28 16:56
 * Function:
 */
@RestController
@RequestMapping(path = "/wx")
public class AppController {

    private final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private MainInfoRepository infoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BlessRepository blessRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/")
    public String getInfo(@RequestParam String c, @RequestParam String appid) {
        File file = new File("/Users/jiezhi/Documents/gooddemo/weixin-java-miniapp-demo/data.json");
        try {
            String data = new BufferedReader(new FileReader(file)).readLine();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"hello\": \"world\"}";
    }

    @GetMapping("/info")
    public @ResponseBody
    MainInfo getInfo(@RequestParam int uid) {
        return infoRepository.findMainInfoByUid(uid);
    }

    @GetMapping("/album")
    public @ResponseBody
    List<Photo> getAlbumList(@RequestParam int uid) {
        return albumRepository.findAllByUid(uid);
    }

    @GetMapping("/map")
    public @ResponseBody
    AllData getLocation(@RequestParam int uid) {
        MainInfo mainInfo = infoRepository.findMainInfoByUid(uid);

        Location location = locationRepository.getLocationByUid(uid);
        return AllData.builder()
            .mainInfo(mainInfo)
            .location(location)
            .build();
    }

    @GetMapping("/bless")
    public @ResponseBody
    List<Bless> getBlesses(@RequestParam int uid) {
        return blessRepository.getAllByUid(uid);
    }

    @PostMapping("/bless")
    public @ResponseBody
    Result postBless(@RequestBody Bless bless) {
        logger.debug(bless.toString());

        if (blessRepository.existsByAvatarUrl(bless.getAvatarUrl())) {
            logger.debug("already blessed");
            return Result.builder()
                .msg("您已经送过祝福啦")
                .success(false)
                .build();
        }
        bless.setTime(TimeUtils.dateFormat.format(new Date()));
        blessRepository.save(bless);

        List<Bless> blesses = blessRepository.getAllByUid(bless.getUid());

        return Result
            .builder()
            .success(true)
            .msg("感谢您的祝福")
            .obj(blesses)
            .build();
    }

    @GetMapping("/comment")
    public @ResponseBody
    List<Comment> getComments(@RequestParam int uid) {
        return commentRepository.getAllByUid(uid);
    }

    @PostMapping("/comment")
    public @ResponseBody
    Result postComment(@RequestBody Comment comment) {
//        public @ResponseBody List<Comment> postComment(@RequestBody Comment comment){
        logger.debug(comment.toString());
        comment.setTime(TimeUtils.dateFormat.format(new Date()));
        commentRepository.save(comment);
        return Result.builder()
            .success(true)
            .msg("感谢您的祝福")
            .obj(commentRepository.getAllByUid(comment.getUid()))
            .build();
    }

    @PostMapping("/comment/submit")
    public @ResponseBody
    Result submit(@RequestBody Attendance attendance) {
        logger.debug(attendance.toString());
        attendanceRepository.save(attendance);
        return Result.builder()
            .success(true)
            .msg("期待您的到来")
            .build();
    }

}
