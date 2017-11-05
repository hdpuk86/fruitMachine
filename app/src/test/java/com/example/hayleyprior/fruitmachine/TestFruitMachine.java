package com.example.hayleyprior.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayleyprior on 04/11/2017.
 */

public class TestFruitMachine {

    private UI ui;
    private FruitMachine fruitMachine3;
    private FruitMachine fruitMachine5;


    @Before
    public void setUp() {
        ui = new UI();
        fruitMachine3 = new FruitMachine("Top Banana", 3, ui);
        fruitMachine5 = new FruitMachine("Top Banana", 5, ui);
    }

    @Test
    public void testBankStartsEmpty() throws Exception {
        assertEquals(0, fruitMachine3.checkBank());
    }

    @Test
    public void canAddPlayerFunds() {
        fruitMachine3.addPlayerFunds(500);
        assertEquals(500, fruitMachine3.getPlayerFunds());
    }

    @Test
    public void canGenerateAllSymbols() {
        assertEquals(10, fruitMachine3.getAllSymbols().size());
    }

    @Test
    public void canGetRandomSymbol() throws Exception {
        FruitMachine spy = Mockito.spy(new FruitMachine("Top Banana", 3, ui));
        Mockito.when(spy.getRandomIndex()).thenReturn(0);
        Symbol symbol = spy.getRandomSymbol();
        assertEquals(Symbol.JACKPOT, symbol);
    }

    @Test
    public void canGetNewLine() {
        assertEquals(3, fruitMachine3.getNewLine().size());
        assertEquals(5, fruitMachine5.getNewLine().size());
    }

    @Test
    public void canClearLine() throws Exception {
        fruitMachine3.getNewLine();
        fruitMachine3.refreshLine();
        assertEquals(3, fruitMachine3.getNewLine().size());
    }

    @Test
    public void canTest3Identical() throws Exception {
        ArrayList<Symbol> testArray = new ArrayList<>();
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        assertEquals(true, fruitMachine3.isIdentical(testArray));
    }

    @Test
    public void canTest5Identical() throws Exception {
        ArrayList<Symbol> testArray = new ArrayList<>();
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        assertEquals(true, fruitMachine5.isIdentical(testArray));
    }

    @Test
    public void canTestNotIdentical() throws Exception {
        ArrayList<Symbol> testArray = new ArrayList<>();
        testArray.add(Symbol.STRAWBERRY);
        testArray.add(Symbol.APPLE);
        testArray.add(Symbol.APPLE);
        assertEquals(false, fruitMachine3.isIdentical(testArray));
    }

    @Test
    public void testSpinWin() throws Exception {
        ArrayList<Symbol> line = new ArrayList<>();
        line.add(Symbol.PEACH);
        line.add(Symbol.PEACH);
        line.add(Symbol.PEACH);
        FruitMachine spy = Mockito.spy(new FruitMachine("Top Banana", 3, ui));
        Mockito.when(spy.getNewLine()).thenReturn(line);
        assertEquals(250, spy.spin());
    }

    @Test
    public void testSpinLose() throws Exception {
        ArrayList<Symbol> line = new ArrayList<>();
        line.add(Symbol.PEACH);
        line.add(Symbol.ORANGE);
        line.add(Symbol.AVOCADO);
        FruitMachine spy = Mockito.spy(new FruitMachine("Top Banana", 3, ui));
        Mockito.when(spy.getNewLine()).thenReturn(line);
        assertEquals(0, spy.spin());
    }

}
