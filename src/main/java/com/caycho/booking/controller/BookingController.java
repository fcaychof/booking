package com.caycho.booking.controller;

import com.caycho.booking.controller.request.BookingRequest;
import com.caycho.booking.controller.response.BookingResponse;
import com.caycho.booking.converter.mapper.BookingMapper;
import com.caycho.booking.model.Schedule;
import com.caycho.booking.model.StateScheduleEnum;
import com.caycho.booking.model.TypeScheduleEnum;
import com.caycho.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;
    private final BookingMapper mapper;


    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody BookingRequest request) {
        Schedule schedule = mapper.payloadToEntity(request);
        BookingResponse bookingResponse = mapper.entityToPayload(service.create(schedule, TypeScheduleEnum.BOOKING));
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody BookingRequest request) {
        UUID idBooking = UUID.fromString(id);
        Schedule schedule = mapper.payloadToEntity(request);
        schedule.setId(idBooking);
        BookingResponse bookingResponse = mapper.entityToPayload(service.update(schedule));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        UUID idBooking = UUID.fromString(id);
        BookingResponse bookingResponse = mapper.entityToPayload(service.changeState(idBooking, StateScheduleEnum.DELETE));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }


    @PutMapping("/cancel/{id}")
    public ResponseEntity<Object> cancel(@PathVariable String id) {
        UUID idBooking = UUID.fromString(id);
        BookingResponse bookingResponse = mapper.entityToPayload(service.changeState(idBooking, StateScheduleEnum.CANCELED));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    @PutMapping("/rebook/{id}")
    public ResponseEntity<Object> rebook(@PathVariable String id) {
        UUID idBooking = UUID.fromString(id);
        BookingResponse bookingResponse = mapper.entityToPayload(service.changeState(idBooking, StateScheduleEnum.ACTIVE));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

}


