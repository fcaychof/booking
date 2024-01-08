package com.caycho.booking.controller.response;

import com.caycho.booking.model.StateEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record PropertyResponse(UUID id,
                               String description,
                               String owner,
                               StateEnum state,
                               String creationUser,
                               String updateUser,
                               LocalDateTime creationDate,
                               LocalDateTime updateDate) {
}
