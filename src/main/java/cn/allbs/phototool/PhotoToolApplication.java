package cn.allbs.phototool;

import cn.allbs.oss.annotation.EnableAllbsOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAllbsOss
@SpringBootApplication
public class PhotoToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoToolApplication.class, args);
    }

}
