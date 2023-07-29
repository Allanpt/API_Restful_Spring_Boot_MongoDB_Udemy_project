package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.resources;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.User;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.dto.UserDTO;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = service.findAll();
        List<UserDTO> dtoList = userList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }
}
