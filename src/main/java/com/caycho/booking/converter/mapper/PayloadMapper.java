package com.caycho.booking.converter.mapper;

public interface PayloadMapper<T> {
    public T payloadToEntity(Record payload);

    public Record entityToPayload(T entity);

    public Record entityToListPayload(T entity);

}
