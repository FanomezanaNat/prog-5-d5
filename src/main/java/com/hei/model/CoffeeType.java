package com.hei.model;

public enum CoffeeType {
    ESPRESSO, LATTE, CAPPUCCINO;


    public static boolean isExists(String name) {
        for (CoffeeType coffeeType : values()) {
            if (coffeeType.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
