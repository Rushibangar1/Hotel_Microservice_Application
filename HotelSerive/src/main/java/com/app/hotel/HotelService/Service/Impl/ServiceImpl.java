package com.app.hotel.HotelService.Service.Impl;

import com.app.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.app.hotel.HotelService.Model.Hotel;
import com.app.hotel.HotelService.Repository.HotelRepository;
import com.app.hotel.HotelService.Service.HotelService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImpl implements HotelService {


    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);
    public final HotelRepository hotelRepository;

    public ServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public Hotel create(Hotel hotel) {
      log.info("The payload is {}",hotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
       log.info("Hotel Data Requested");
       return hotelRepository.findAll();
    }

    @Override
    public Hotel get(Long id) {
       log.info("Data requested for id {}",id);
       return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !!"));
    }
}
