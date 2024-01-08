package com.caycho.booking.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Audit {

    private String creationUser;
    private String updateUser;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
