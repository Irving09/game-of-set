package com.company;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Card test1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card test2 = new Card(Color.GREEN, Shape.DIAMOND, Shading.SOLID, Number.ONE);
        Card test3 = new Card(Color.PURPLE, Shape.OVAL, Shading.SOLID, Number.THREE);

        Card test4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
        Card test5 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
        Card test6 = new Card(Color.PURPLE, Shape.OVAL, Shading.SOLID, Number.THREE);
        GameOfSet game = new GameOfSet();
        boolean result1 = game.isSet(test1, test2, test3);
        boolean result2 = game.isSet(test4, test5, test6);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);

        game.start();

        Card[] result = game.findSet();
        System.out.println(Arrays.toString(result));
    }
}
