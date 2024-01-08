package com.caycho.booking.repository;

import com.caycho.booking.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    Optional<Schedule> findByPropertyIdAndStartDateAndEndDate(UUID idProperty, LocalDate startDate, LocalDate endDate);

}
