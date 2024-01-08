package com.caycho.booking.controller.response;

import com.caycho.booking.model.StateEnum;
import com.caycho.booking.model.StateScheduleEnum;
import com.caycho.booking.model.TypeScheduleEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record BlockResponse(
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
