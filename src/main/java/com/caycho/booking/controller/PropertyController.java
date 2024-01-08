package com.caycho.booking.controller;


import com.caycho.booking.controller.request.PropertyRequest;
import com.caycho.booking.controller.response.PropertyResponse;
import com.caycho.booking.converter.mapper.PropertyMapper;
import com.caycho.booking.model.Property;
import com.caycho.booking.service.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService service;
    private final PropertyMapper mapper;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody PropertyRequest request) {
        Property property = mapper.payloadToEntity(request);
        PropertyResponse propertyResponse = mapper.entityToPayload(service.create(property));
        return new ResponseEntity<>(propertyResponse, HttpStatus.CREATED);
    }

}
