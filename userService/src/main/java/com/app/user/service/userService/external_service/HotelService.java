package com.app.user.service.userService.external_service;


import com.app.user.service.userService.ResponseDto.Hotel_Response_Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "HOTELSERIVE")
public interface HotelService {


    @GetMapping("/getHotel/{hotelId}")
    Hotel_Response_Dto getHotel(@PathVariable("hotelId") String hotelId);


}
