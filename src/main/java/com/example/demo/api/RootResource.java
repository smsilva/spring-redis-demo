package com.example.demo.api;

import com.example.demo.config.RedisConfigSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RootResource {

    @Autowired
    private RedisConfigSample config;

    @GetMapping
    public RedisConfigSample get() {
        return config;
    }

}
