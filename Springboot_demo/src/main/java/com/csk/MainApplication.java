package com.csk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author csk
 * @date 2023/11/21 17:35
 */
//@ServletComponentScan
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class,args);
    }

}
