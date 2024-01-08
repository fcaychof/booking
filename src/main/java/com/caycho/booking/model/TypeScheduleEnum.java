package com.caycho.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TypeScheduleEnum {
    BOOKING(0),

    BLOCK(1);

    private int valeu;

    public static String getName(Integer valeu) {
        TypeScheduleEnum item = find(valeu);
        if (item != null)
            return item.name();
        return null;
    }

    public static TypeScheduleEnum find(Integer valeu) {
        for (TypeScheduleEnum item : Arrays.asList(TypeScheduleEnum.values())) {
            if (item.getValeu() == valeu) {
                return item;
            }
        }
        return null;
    }
}
