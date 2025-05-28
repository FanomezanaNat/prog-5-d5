package com.hei.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CoffeeAppManager {
    private List<User> users;
    private List<CoffeeMachine> coffeeMachines;

    public void buyDrink(Integer userId, Integer machineId, CoffeeCapsuleType coffeeType, int tokenQuantity) {
        if (tokenQuantity <= 0) throw new IllegalArgumentException("Token quantity must be > 0");

        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getTokenCount() < tokenQuantity)
            throw new RuntimeException("Insufficient tokens");

        CoffeeMachine machine = coffeeMachines.stream()
                .filter(m -> m.getId().equals(machineId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        double quantityInLiters = (tokenQuantity * 0.3);
        machine.getCoffee(coffeeType, quantityInLiters);

        user.setTokenCount(user.getTokenCount() - tokenQuantity);
    }

}
