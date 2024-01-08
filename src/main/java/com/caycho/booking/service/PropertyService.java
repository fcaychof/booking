package com.caycho.booking.service;

import com.caycho.booking.model.Property;
import com.caycho.booking.model.StateEnum;
import com.caycho.booking.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PropertyService {

    public static final String ADMIN = "Admin";
    private final PropertyRepository repository;

    public Property create(Property property) {
        return repository.save(Property.builder().description(property.getDescription())
                .creationUser(ADMIN).creationDate(LocalDateTime.now()).state(StateEnum.ACTIVE).build());

    }
}
