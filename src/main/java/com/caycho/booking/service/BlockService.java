package com.caycho.booking.service;

import com.caycho.booking.model.Schedule;
import com.caycho.booking.model.StateEnum;
import com.caycho.booking.model.StateScheduleEnum;
import com.caycho.booking.model.TypeScheduleEnum;
import com.caycho.booking.repository.PropertyRepository;
import com.caycho.booking.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.caycho.booking.service.PropertyService.ADMIN;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final ScheduleRepository repository;
    private final PropertyRepository propertyRepository;

    public Schedule create(Schedule schedule, TypeScheduleEnum stateScheduleEnum) {
        if (propertyRepository.findByIdAndState(schedule.getPropertyId(), StateEnum.ACTIVE).isPresent() &&
                repository.findByPropertyIdAndStartDateAndEndDate(schedule.getPropertyId(),
                        schedule.getStartDate(), schedule.getEndDate()).isEmpty()) {
            schedule.setCreationDate(LocalDateTime.now());
            schedule.setTypeSchedule(stateScheduleEnum);
            schedule.setStateScheduleEnum(StateScheduleEnum.ACTIVE);
            schedule.setState(StateEnum.ACTIVE);
            schedule.setCreationUser(ADMIN);
            return repository.save(schedule);
        }

        throw new ObjectNotFoundException("Unable to locate user with propertyId: ", schedule.getPropertyId());
    }

    public Schedule update(Schedule schedule, TypeScheduleEnum typeScheduleEnum) {
        Optional<Schedule> byId = repository.findById(schedule.getId());
        if (propertyRepository.findByIdAndState(byId.get().getPropertyId(), StateEnum.ACTIVE).isPresent() && byId.isPresent()) {
            Schedule scheduleUpdate = byId.get();
            scheduleUpdate.setUpdateDate(LocalDateTime.now());
            scheduleUpdate.setUpdateUser(ADMIN);
            scheduleUpdate.setStartDate(schedule.getStartDate());
            scheduleUpdate.setEndDate(schedule.getEndDate());
            scheduleUpdate.setGuest(schedule.getGuest());
            scheduleUpdate.setTypeSchedule(typeScheduleEnum);

            return repository.save(scheduleUpdate);
        }
        throw new ObjectNotFoundException("Unable to locate user with ScheduleId: ", schedule.getId());
    }

    public Schedule changeState(UUID id, StateScheduleEnum scheduleEnum, TypeScheduleEnum typeScheduleEnum) {
        Optional<Schedule> byId = repository.findById(id);
        if (byId.isPresent()) {
            Schedule scheduleUpdate = byId.get();
            scheduleUpdate.setUpdateDate(LocalDateTime.now());
            scheduleUpdate.setUpdateUser(ADMIN);
            scheduleUpdate.setStateScheduleEnum(scheduleEnum);
            scheduleUpdate.setTypeSchedule(typeScheduleEnum);

            return repository.save(scheduleUpdate);
        }
        throw new ObjectNotFoundException("Unable to locate user with ScheduleId: ", id);
    }
}
