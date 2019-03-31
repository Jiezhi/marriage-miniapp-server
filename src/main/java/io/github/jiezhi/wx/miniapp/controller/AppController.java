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
        return infoRepository.findMainInfoByUserid(uid);
    }

    @GetMapping("/album")
    public @ResponseBody
    List<Photo> getAlbumList(@RequestParam int uid) {
        return albumRepository.findAllByUid(uid);
    }

    @GetMapping("/map")
    public @ResponseBody
    AllData getLocation(@RequestParam int uid) {
        MainInfo mainInfo = infoRepository.findMainInfoByUserid(uid);

        Location location = locationRepository.getLocationByUid(uid);
        AllData allData = new AllData();
        allData.setMainInfo(mainInfo);
        allData.setLocation(location);
        return allData;
    }

    @GetMapping("/bless")
    public @ResponseBody
    List<Bless> getBlesses(@RequestParam int uid) {
        return blessRepository.getAllByUid(uid);
    }

    @PostMapping("/bless")
    public @ResponseBody
    Result postBless(@RequestBody Bless bless) {
        System.out.println(bless.toString());
        logger.debug(bless.toString());
        bless.setTime(TimeUtils.dateFormat.format(new Date()));
        blessRepository.save(bless);
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("感谢您的祝福^V^");

        List<Bless> blesses = blessRepository.getAllByUid(bless.getUid());
        result.setObj(blesses);
        return result;
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
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("Ok");
        result.setObj(commentRepository.getAllByUid(comment.getUid()));
        return result;
    }

    @PostMapping("/submit")
    public @ResponseBody
    Result submit(@RequestBody Attendance attendance) {
        logger.debug(attendance.toString());
        attendanceRepository.save(attendance);
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("OK");
        return result;
    }

}
