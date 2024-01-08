package com.caycho.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID propertyId;
    private String guest;
    @Enumerated(EnumType.ORDINAL)
    private StateEnum state;
    @Enumerated(EnumType.ORDINAL)
    private TypeScheduleEnum typeSchedule;
    @Enumerated(EnumType.ORDINAL)
    private StateScheduleEnum stateScheduleEnum;
    private LocalDate startDate;
    private LocalDate endDate;
    private String creationUser;
    private String updateUser;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

}
