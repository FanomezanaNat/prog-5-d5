package com.hei.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeMachine {
    private Integer id;
    private double waterBalance;
    private Map<CoffeeCapsuleType, Double> coffeeCapsule;


    public void fillWaterQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        waterBalance += quantity;
    }

    public void addCoffeeCapsule(CoffeeCapsuleType type, int quantity) {
        if (type == null) {
            throw new IllegalArgumentException("Coffee capsule type is null");
        }
        coffeeCapsule.put(type, coffeeCapsule.get(type) + quantity);
    }

    public void getCoffee(CoffeeCapsuleType type, double quantity) {
        if (quantity > waterBalance) {
            throw new RuntimeException("Coffee capsule is ");
        }
        var requiredCapsuleQuantity = coffeeCapsule.get(type);
        if (quantity > requiredCapsuleQuantity) {
            throw new RuntimeException("Coffee capsule is enough");
        }
        waterBalance -= quantity;
        coffeeCapsule.put(type, requiredCapsuleQuantity - quantity);
        System.out.println("Served " + quantity + "L of " + type + ".");

    }

    public void listCoffeeTypes() {
        System.out.println("Available coffee types:");
        for (Map.Entry<CoffeeCapsuleType, Double> entry : coffeeCapsule.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " capsules left");
            }
        }
    }
}
