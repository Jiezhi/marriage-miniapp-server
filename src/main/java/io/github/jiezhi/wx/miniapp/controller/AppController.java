package io.github.jiezhi.wx.miniapp.controller;

import io.github.jiezhi.wx.miniapp.model.*;
import io.github.jiezhi.wx.miniapp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    Location getLocation(@RequestParam int uid) {
        return locationRepository.getLocationByUid(uid);
    }

    @GetMapping("/bless")
    public @ResponseBody
    List<Bless> getBlesses(@RequestParam int uid) {
        return blessRepository.getAllByUid(uid);
    }

    @PostMapping("/bless")
    public @ResponseBody List<Bless> postBless(@RequestBody Bless bless) {
        logger.debug(bless.toString());
        blessRepository.save(bless);
        return blessRepository.getAllByUid(bless.getUid());
    }

    @GetMapping("/comment")
    public @ResponseBody
    List<Comment> getComments(@RequestParam int uid) {
        return commentRepository.getAllByUid(uid);
    }

}
