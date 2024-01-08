package com.caycho.booking.repository;

import com.caycho.booking.model.Property;
import com.caycho.booking.model.StateEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {

    Optional<Property> findByIdAndState(UUID id, StateEnum stateEnum);
}
