package com.caycho.booking.controller.request;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record BookingRequest(
        @NotNull String guest,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotNull UUID propertyId) {

}
