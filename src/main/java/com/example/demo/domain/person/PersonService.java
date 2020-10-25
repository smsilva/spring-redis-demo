package com.example.demo.domain.person;

import com.example.demo.domain.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class PersonService {

    private final String EMPLOYEE_CACHE = "PERSON";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, String, Person> hashOperations;

    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(final Person employee) {
        hashOperations.put(EMPLOYEE_CACHE, employee.getId(), employee);
    }

    public Person findById(final String id) {
        return (Person) hashOperations.get(EMPLOYEE_CACHE, id);
    }

    public Map<String, Person> findAll() {
        return hashOperations.entries(EMPLOYEE_CACHE);
    }

    public void delete(String id) {
        hashOperations.delete(EMPLOYEE_CACHE, id);
    }

}
