package com.caycho.booking.converter.mapper;


import com.caycho.booking.controller.request.PropertyRequest;
import com.caycho.booking.controller.response.PropertyResponse;
import com.caycho.booking.model.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper extends PayloadMapper<Property> {

    Property payloadToEntity(PropertyRequest request);

    @Override
    PropertyResponse entityToPayload(Property entity);

    @Override
    PropertyResponse entityToListPayload(Property entity);


}
