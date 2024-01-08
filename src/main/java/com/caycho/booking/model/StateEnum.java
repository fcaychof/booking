package com.caycho.booking.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum StateEnum {
    INACTIVE(0),
    ACTIVE(1);


    private int valeu;

    public int getValeu() {
        return valeu;
    }

    public static String getName(Integer valeu) {
        StateEnum item = find(valeu);
        if (item != null)
            return item.name();
        return null;
    }

    public static StateEnum find(Integer valeu) {
        for (StateEnum item : Arrays.asList(StateEnum.values())) {
            if (item.getValeu() == valeu) {
                return item;
            }
        }
        return null;
    }
}
