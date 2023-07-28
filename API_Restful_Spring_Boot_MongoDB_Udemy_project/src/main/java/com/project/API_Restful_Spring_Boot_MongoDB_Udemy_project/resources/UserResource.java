package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.resources;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria", "mariasilva@gmail.com");
        User alex = new User("2", "alex", "alex@gmail.com");

        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(maria,alex));
        return ResponseEntity.ok().body(userList);
    }
}
