package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException (String msg){
        super(msg);
    }
}
