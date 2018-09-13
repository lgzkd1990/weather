package com.zl.weather.dataeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataEurekaApplication.class, args);
    }
}
