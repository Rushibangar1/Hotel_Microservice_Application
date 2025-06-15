package com.app.user.service.userService.ResponseDto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating_Response_Dto {
    private  String ratingId;
    private  String userId;
    private  String hotelId;
    private  int rating;
    private  String feedback;
    private Hotel_Response_Dto hotel;
}
