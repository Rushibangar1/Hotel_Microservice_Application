package com.app.hotel.HotelService.Controller;



import com.app.hotel.HotelService.Model.Hotel;
import com.app.hotel.HotelService.Service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @PostMapping("createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotelWithId(@PathVariable Long hotelId){
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.get(hotelId));
    }

    @GetMapping("GetAll")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.getAll());
    }







}
