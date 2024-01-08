package com.caycho.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StateScheduleEnum {
    CANCELED(0),
    DELETE(1),
    ACTIVE(2),
    INACTIVE(3);

    private int valeu;

    public static String getName(Integer valeu) {
        StateScheduleEnum item = find(valeu);
        if (item != null)
            return item.name();
        return null;
    }

    public static StateScheduleEnum find(Integer valeu) {
        for (StateScheduleEnum item : Arrays.asList(StateScheduleEnum.values())) {
            if (item.getValeu() == valeu) {
                return item;
            }
        }
        return null;
    }
}
