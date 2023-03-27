package com.boot.Curdproject.curdProject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Builder
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
