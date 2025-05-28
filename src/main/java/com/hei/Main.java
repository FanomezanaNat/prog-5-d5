package com.hei;

import com.hei.model.CoffeeAppManager;
import com.hei.model.CoffeeCapsuleType;
import com.hei.model.CoffeeMachine;
import com.hei.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.hei.model.CoffeeCapsuleType.BLACK_COFFEE;
import static com.hei.model.CoffeeCapsuleType.CAPPUCINO;

public class Main {
    public static void main(String[] args) {
        var users = List.of(new User(1));
        var capsules = new HashMap<CoffeeCapsuleType, Double>();
        capsules.put(BLACK_COFFEE, 10.0);
        capsules.put(CAPPUCINO, 5.0);
        var machines = (List.of(new CoffeeMachine(101, 5, capsules)));
        var manager = new CoffeeAppManager(users, machines);
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1.Buy 2.Users 3.Coffee 4.Exit: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("UserID: ");
                    int id = scanner.nextInt();
                    System.out.print("MachineID: ");
                    int mid = scanner.nextInt();
                    System.out.println("Choose your coffee :");
                    for (CoffeeCapsuleType t : CoffeeCapsuleType.values()) {
                        System.out.println("- " + t);
                    }
                    System.out.print("Your choice : ");
                    String type = scanner.next().trim().toUpperCase();
                    System.out.print("Token to use for your drink : ");
                    int tokens = scanner.nextInt();

                    try {
                        manager.buyDrink(id, mid, CoffeeCapsuleType.valueOf(type), tokens);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> users.forEach(u -> System.out.println(u.getId() + ": " + u.getTokenCount() + " tokens"));
                case 3 -> machines.get(0).listCoffeeTypes();
                case 4 -> System.exit(0);
            }
        }
    }
}
