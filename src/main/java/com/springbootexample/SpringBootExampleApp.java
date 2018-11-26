package com.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootExampleApp {
    public static void main(String args[]){
        SpringApplication.run(SpringBootExampleApp.class, args);
        log.info("In Main... Starting Spting Boot Application...");
    }

}
