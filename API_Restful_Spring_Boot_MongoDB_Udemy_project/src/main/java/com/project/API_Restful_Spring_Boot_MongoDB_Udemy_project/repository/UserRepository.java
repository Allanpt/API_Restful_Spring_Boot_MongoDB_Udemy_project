package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.repository;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
