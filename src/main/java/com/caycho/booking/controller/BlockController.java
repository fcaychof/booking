package com.caycho.booking.controller;


import com.caycho.booking.controller.request.BlockRequest;
import com.caycho.booking.controller.request.BookingRequest;
import com.caycho.booking.controller.response.BlockResponse;
import com.caycho.booking.converter.mapper.BlockMapper;
import com.caycho.booking.model.Schedule;
import com.caycho.booking.model.StateScheduleEnum;
import com.caycho.booking.model.TypeScheduleEnum;
import com.caycho.booking.service.BlockService;
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
@RequestMapping("/block")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService service;
    private final BlockMapper mapper;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody BlockRequest request) {
        Schedule schedule = mapper.payloadToEntity(request);
        BlockResponse bookingResponse = mapper.entityToPayload(service.create(schedule, TypeScheduleEnum.BLOCK));
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody BookingRequest request) {
        UUID idBooking = UUID.fromString(id);
        Schedule schedule = mapper.payloadToEntity(request);
        schedule.setId(idBooking);
        BlockResponse bookingResponse = mapper.entityToPayload(service.update(schedule, TypeScheduleEnum.BLOCK));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        UUID idBooking = UUID.fromString(id);
        BlockResponse bookingResponse = mapper.entityToPayload(service.changeState(idBooking, StateScheduleEnum.DELETE, TypeScheduleEnum.BLOCK));
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }
}
