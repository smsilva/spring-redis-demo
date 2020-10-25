package com.example.demo.api;

import com.example.demo.config.RedisConfigSample;
import com.example.demo.domain.person.PersonService;
import com.example.demo.domain.person.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RootResource {

    private static final Logger LOG = LoggerFactory.getLogger(RootResource.class);

    @Autowired
    private RedisConfigSample config;

    @Autowired
    private PersonService persons;

    @GetMapping
    public RedisConfigSample get() {
        Map<String, Person> all = persons.findAll();
        if (all == null) {
            LOG.error("all has returned null");
        } else {
            LOG.info(String.format("all: %s", all));
        }

        return config;
    }

}
