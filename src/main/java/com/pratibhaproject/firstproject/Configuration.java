package com.pratibhaproject.firstproject;

import com.pratibhaproject.firstproject.client.EmployeeFeignClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmployeeFeignClient employeeFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(EmployeeFeignClient.class))
                .logLevel(Logger.Level.FULL)
                .target(EmployeeFeignClient.class, "https://dummy.restapiexample.com/api/v1");
    }
}
