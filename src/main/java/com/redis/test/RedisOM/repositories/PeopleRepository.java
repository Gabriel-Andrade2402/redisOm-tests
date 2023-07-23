package com.redis.test.RedisOM.repositories;

import org.springframework.stereotype.Repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import com.redis.test.RedisOM.models.Person;

@Repository
public interface PeopleRepository extends RedisDocumentRepository<Person,String>{

}
