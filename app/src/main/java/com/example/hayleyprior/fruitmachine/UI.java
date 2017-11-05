package com.example.hayleyprior.fruitmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hayleyprior on 04/11/2017.
 */

public class UI {

    Scanner scan;

    public UI() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n\n🍌🍌🍌🍌🍌\n\nTOP BANANA!\n\nFeeling lucky? Spin to win the jackpot £1000!!!\n\n£1 per spin!\n\n 🍌🍌🍌🍌🍌\n\n");
    }

    public String getName() {
        System.out.println("Enter Player Name:");
        return scan.nextLine();
    }

    public int addMoney() {
        System.out.println("How much money would you like to play with?");
        return scan.nextInt();
    }

    public String spin() {
        System.out.println("Spin? Press Enter to Spin or C to collect");
        return scan.nextLine();
    }

    public void youWon(String winnings) {
        System.out.println("Congratulations! You're a winner!!! You just won " + winnings + " Press Enter to win more or press C to collect");
        scan.nextLine();
    }

}
