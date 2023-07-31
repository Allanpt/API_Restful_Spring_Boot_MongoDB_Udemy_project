package com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.resources.exception;

import com.project.API_Restful_Spring_Boot_MongoDB_Udemy_project.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        String error = "Object not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError stdError = new StandardError(Instant.now(),httpStatus.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(stdError);
    }
}
