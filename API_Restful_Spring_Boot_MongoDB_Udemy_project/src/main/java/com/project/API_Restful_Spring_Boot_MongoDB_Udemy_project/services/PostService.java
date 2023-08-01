package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.domain.Post;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.repository.PostRepository;
import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
