package com.caycho.booking.controller.response;


import com.caycho.booking.model.StateEnum;
import com.caycho.booking.model.StateScheduleEnum;
import com.caycho.booking.model.TypeScheduleEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BookingResponse(
        UUID id,
        UUID propertyId,
        String guest,
        StateEnum state,
        TypeScheduleEnum typeSchedule,
        StateScheduleEnum stateScheduleEnum,
        LocalDate startDate,
        LocalDate endDate,
        String creationUser,
        String updateUser,
        LocalDateTime creationDate,
        LocalDateTime updateDate) {
}
