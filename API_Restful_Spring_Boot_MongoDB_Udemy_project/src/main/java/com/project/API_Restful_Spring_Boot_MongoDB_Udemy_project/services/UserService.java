package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.User;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
