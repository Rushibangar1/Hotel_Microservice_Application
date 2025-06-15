package com.app.user.service.userService.Model;


import com.app.user.service.userService.ResponseDto.Rating_Response_Dto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="micro_users")
public class User {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="NAME",length = 25)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Rating_Response_Dto> rating = new ArrayList<>();

    public List<Rating_Response_Dto> getRating() {
        return rating;
    }

    public void setRating(List<Rating_Response_Dto> rating) {
        this.rating = rating;
    }
}
