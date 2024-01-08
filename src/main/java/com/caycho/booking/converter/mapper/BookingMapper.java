package com.caycho.booking.converter.mapper;


import com.caycho.booking.controller.request.BookingRequest;
import com.caycho.booking.controller.response.BookingResponse;
import com.caycho.booking.model.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper extends PayloadMapper<Schedule> {

    Schedule payloadToEntity(BookingRequest request);

    @Override
    BookingResponse entityToPayload(Schedule entity);

    @Override
    BookingResponse entityToListPayload(Schedule entity);


}
