package com.caycho.booking.controller.request;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record BlockRequest(
        String guest,
        LocalDateTime startDate,
        LocalDateTime endDate,
        UUID propertyId) {
}
