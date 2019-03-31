package io.github.jiezhi.wx.miniapp;

import io.github.jiezhi.wx.miniapp.model.*;
import io.github.jiezhi.wx.miniapp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@SpringBootApplication
public class WxMaDemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(WxMaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WxMaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MainInfoRepository repository) {
        return (args) -> {
            MainInfo info = new MainInfo();
            info.setAppid("test appid");
            info.setApp_name("love app");
            info.setHe("Jiezhi");
            info.setShe("Jiaojiao");
            info.setHe_tel("1314520");
            info.setShe_tel("1314521");
            info.setDate("2019-05-18");
            info.setCover("http://localhost:9999/DQ3A8961_%E5%8F%8C%E8%89%B2%E7%9B%B8%E6%A1%86%E7%B1%B3%E8%89%B27_7.JPG");
            repository.save(info);

            logger.info("Info found with findAll():");
            for (MainInfo mainInfo : repository.findAll()) {
                logger.info(mainInfo.toString());
            }

            logger.info(repository.findMainInfoByUserid(1)
                .toString());
        };
    }

    @Bean
    public CommandLineRunner album(AlbumRepository repository) {
        return (args) -> {
            Photo photo = new Photo();
            photo.setUid(1);
            photo.setImage("http://localhost:9999/DQ3A8961_%E5%8F%8C%E8%89%B2%E7%9B%B8%E6%A1%86%E7%B1%B3%E8%89%B27_7.JPG");
            photo.setAddtime("2018-03-30");
            repository.save(photo);
            photo = new Photo();
            photo.setUid(1);
            photo.setImage("http://localhost:9999/DQ3A8949_love%E6%91%86%E5%8F%B0.JPG");
            photo.setAddtime("2018-03-30");
            repository.save(photo);
        };
    }

    @Bean
    public CommandLineRunner map(LocationRepository repository) {
        return (args) -> {
            Location location = new Location();
            location.setUid(1);
            location.setLat(31.886589F);
            location.setLon(118.521594F);
            repository.save(location);
        };
    }

    @Bean
    public CommandLineRunner comment(CommentRepository repository) {
        return (args) -> {
            Comment comment = new Comment();
            comment.setUid(1);
            comment.setFace("https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqdJ7sGuE7xvUc3f4hKy31CUZGGr1cpNgjicFWyfkLbx3zHpvGTQnRkloYVPaOYK5TIX8kDgdpkROQ/132");
            comment.setNickname("耿介之");
            comment.setWords("Happy every day!");
            repository.save(comment);
        };
    }

    @Bean
    public CommandLineRunner bless(BlessRepository repository) {
        return (args) -> {
            Bless bless = new Bless();
            bless.setUid(1);
            bless.setFace("https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqdJ7sGuE7xvUc3f4hKy31CUZGGr1cpNgjicFWyfkLbx3zHpvGTQnRkloYVPaOYK5TIX8kDgdpkROQ/132");
            bless.setNickname("Olivia");
            bless.setTime("1553760041");
            repository.save(bless);
        };
    }
}
