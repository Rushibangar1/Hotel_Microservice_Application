package com.app.user.service.userService.external_service;


import com.app.user.service.userService.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "HOTELSERIVE")
public interface HotelService {


    @GetMapping("/getHotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);


}
