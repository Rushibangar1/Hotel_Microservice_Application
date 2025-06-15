package com.app.user.service.userService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String     message;
    private boolean    succes;
    private HttpStatus status;
}
