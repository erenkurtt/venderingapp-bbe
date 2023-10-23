package com.erenkurt.venderingapp.System;

import com.erenkurt.venderingapp.System.System;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends MongoRepository<System, Integer> {
    System findBySystemId(Integer systemId);
}
