package com.example.hayleyprior.fruitmachine;

/**
 * Created by hayleyprior on 04/11/2017.
 */

public enum Symbol {

    JACKPOT(1000, "💲"),
    BANANA(800, "🍌"),
    ORANGE(500, "🍊"),
    PEACH(250, "🍑"),
    MELON(100, "🍉"),
    LEMON(50, "🍋"),
    AVOCADO(10, "🥑"),
    APPLE(5, "🍎"),
    STRAWBERRY(2, "🍓"),
    CHERRY(1, "🍒");

    private int value;
    private String emoji;

    Symbol(int value, String emoji) {
        this.value = value;
        this.emoji = emoji;
    }

    public int getValue() {
        return value;
    }

    public String getEmoji() {
        return emoji;
    }
}
