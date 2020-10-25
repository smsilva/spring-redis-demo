package com.example.demo.api;

import com.example.demo.config.RedisConfigSample;
import com.example.demo.domain.person.PersonService;
import com.example.demo.domain.person.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    @GetMapping(path = "/")
    public RedisConfigSample get() {
        return config;
    }

    @GetMapping(path = "test")
    public String findAll() {
        Map<String, Person> all = persons.findAll();
        if (all == null) {
            LOG.error("all has returned null");
            return "null";
        } else {
            LOG.info(String.format("all: %s", all));
            return "ok";
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        LOG.info("hello world, I have just started up");
//        this.findAll();
    }

}
