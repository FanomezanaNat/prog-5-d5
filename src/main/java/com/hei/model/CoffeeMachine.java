package com.hei.model;

import java.util.List;

public class CoffeeMachine {
    private boolean isBlackout;
    private boolean hasWater;
    private List<Coffee> coffees;

    public CoffeeMachine( List<Coffee> coffees) {
        this.isBlackout = false;
        this.hasWater = true;
        this.coffees = coffees;
    }
}
