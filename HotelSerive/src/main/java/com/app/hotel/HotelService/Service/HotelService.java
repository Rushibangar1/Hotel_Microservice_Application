package com.app.hotel.HotelService.Service;

import com.app.hotel.HotelService.Model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(Long id);



}
