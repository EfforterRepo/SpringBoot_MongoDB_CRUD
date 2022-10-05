package com.crud.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.crud.project.entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity, String> {
}

