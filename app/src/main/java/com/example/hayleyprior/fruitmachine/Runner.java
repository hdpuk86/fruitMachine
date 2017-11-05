package com.example.hayleyprior.fruitmachine;

/**
 * Created by hayleyprior on 04/11/2017.
 */

public class Runner {

    public static void main(String[] args) {
        UI ui = new UI();
        FruitMachine fruitMachine = new FruitMachine("Top Banana", 5, ui);

        ui.start();
        String name = ui.getName();
        System.out.println("Welcome " + name + ", let's start!\n");

        int funds = ui.addMoney();
        fruitMachine.addPlayerFunds(funds);

        fruitMachine.start();
    }

}
