package com.example.hayleyprior.fruitmachine;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by hayleyprior on 04/11/2017.
 */

public class FruitMachine {

    private String name;
    private int bank;
    private ArrayList<Symbol> allSymbols;
    private ArrayList<Symbol> line;
    private int numberOfSlots;
    private int playerFunds;
    private UI ui;
    private boolean quit;

    public FruitMachine(String name, int numberOfSlots, UI ui) {
        this.name = name;
        this.bank = 0;
        this.playerFunds = 0;
        this.numberOfSlots = numberOfSlots;
        this.allSymbols = new ArrayList<>();
        this.line = new ArrayList<>();
        this.ui = ui;
        this.quit = false;
        generateAllSymbols();
    }

    public ArrayList<Symbol> getAllSymbols() {
        return allSymbols;
    }

    public ArrayList<Symbol> getLine() {
        return line;
    }

    public void addPlayerFunds(int amount) {
        this.playerFunds += amount;
    }

    public void addMoneyToBank(int amount) {
        this.bank += amount;
    }

    public int getPlayerFunds() {
        return playerFunds;
    }

    public void generateAllSymbols() {
        for(Symbol symbol : Symbol.values()) {
            this.allSymbols.add(symbol);
        }
    }

    public int checkBank() {
        return this.bank;
    }

    public int getRandomIndex() {
        Random rand = new Random();
        int randomInt = rand.nextInt(Symbol.values().length);
        return randomInt;
    }

    public Symbol getRandomSymbol() {
        return allSymbols.get(getRandomIndex());
    }

    public void refreshLine() {
        this.line.clear();
    }

    public ArrayList<Symbol> getNewLine() {
        refreshLine();
        for(int i = 0; i<this.numberOfSlots; i++) {
            this.line.add(getRandomSymbol());
        }
        return this.line;
    }

    public boolean isIdentical(ArrayList<Symbol> line) {
        int counter = 0;
        for(Symbol symbol : line) {
            if(symbol.equals(line.get(0))) {
                counter++;
            }
        }
        if(counter == line.size()) {
            return true;
        }
        return false;
    }

    public int spin() {
        this.addPlayerFunds(-1);
        addMoneyToBank(1);
        this.line = getNewLine();
        getEmojis();
        if (isIdentical(this.line)) {
            ui.youWon("£" + this.line.get(0).getValue());
            return this.line.get(0).getValue();
        }
        return 0;
    }

    public void getEmojis(){
        for(Symbol symbol : this.line) {
            System.out.print(symbol.getEmoji());
        }
        System.out.println("\n");
    }

    public void collect() {
        System.out.println("\nCongratulations! You have collected £" + this.playerFunds);
        System.out.println("Printing ticket....");
        System.out.println("Redeem your ticket at the counter or scan barcode to play again");
        this.playerFunds = 0;

    }

    public void start() {
        while (!this.quit) {
            String answer = ui.spin();
            if (answer.equalsIgnoreCase("c")) {
                collect();
                this.quit = true;
                return;
            }
            System.out.println("Your funds: " + playerFunds + "\n");
            int winnings = spin();
            addPlayerFunds(winnings);
        }
    }

}
