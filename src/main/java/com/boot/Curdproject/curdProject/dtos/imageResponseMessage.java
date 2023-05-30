package com.boot.Curdproject.curdProject.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class imageResponseMessage {

    private String imageName;
    private String message;
    private boolean success;
    private HttpStatus status;
}
