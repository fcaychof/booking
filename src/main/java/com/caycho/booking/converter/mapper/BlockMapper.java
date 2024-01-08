package com.caycho.booking.converter.mapper;


import com.caycho.booking.controller.request.BlockRequest;
import com.caycho.booking.controller.response.BlockResponse;
import com.caycho.booking.model.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockMapper extends PayloadMapper<Schedule> {

    Schedule payloadToEntity(BlockRequest request);

    @Override
    BlockResponse entityToPayload(Schedule entity);

    @Override
    BlockResponse entityToListPayload(Schedule entity);


}
