package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.User;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.dto.UserDTO;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.repository.UserRepository;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return repo.save(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}
