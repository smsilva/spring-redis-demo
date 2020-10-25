package com.example.demo.domain.person.entity;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RedisHash("Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int grade;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
