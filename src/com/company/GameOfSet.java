package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GameOfSet {
    private List<Card> board = new ArrayList<Card>();

    public static void main(String[] args) {
//        Card test1 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
//        Card test2 = new Card(Color.GREEN, Shape.DIAMOND, Shading.SOLID, Number.ONE);
//        Card test3 = new Card(Color.PURPLE, Shape.OVAL, Shading.SOLID, Number.THREE);
//
//        Card test4 = new Card(Color.RED, Shape.SQUIGGLE, Shading.SOLID, Number.TWO);
//        Card test5 = new Card(Color.GREEN, Shape.SQUIGGLE, Shading.SOLID, Number.ONE);
//        Card test6 = new Card(Color.PURPLE, Shape.OVAL, Shading.SOLID, Number.THREE);
//
        GameOfSet game = new GameOfSet();
//        boolean result1 = game.isSet(test1, test2, test3);
//        boolean result2 = game.isSet(test4, test5, test6);
//
//        System.out.println("result1: " + result1);
//        System.out.println("result2: " + result2);
        game.start();

        Card[] result = game.findSet();
        System.out.println(Arrays.toString(result));
    }

    public void start() {
        for (int i = 0; i < 12; i++) {
            board.add(new Card());
        }
    }

    /*
    * A method that given a "board" of cards,
    * will either find a set, or determine if there are no sets on the table
    * */
    public Card[] findSet() {
        // i  j  k
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12

        //                               i   j   k
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12

        Card a, b, c;

        for (int i = 0; i < this.board.size() - 2; i++) {
            for (int j = i + 1; j < this.board.size() - 1; j++) {
                for (int k = j + 1; k < this.board.size(); k++) {
                    a = this.board.get(i);
                    b = this.board.get(j);
                    c = this.board.get(k);

                    if (isSet(a, b, c)) {
                        return new Card[]{ a, b, c };
                    }
                }
            }
        }
        return new Card[] {};
    }

    /**
     * A method that takes three cards,
     * and determines whether the three cards make a set
     */
    public boolean isSet(final Card a, final Card b, final Card c) {

        return (isIdenticalColors(a, b, c) || isUniqueColors(a, b, c)) &&
               (isIdenticalShapes(a, b, c) || isUniqueShapes(a, b, c)) &&
               (isIdenticalShades(a, b, c) || isUniqueShades(a, b, c)) &&
               (isIdenticalNumbers(a, b, c) || isUniqueNumbers(a, b, c));
    }

    private boolean isUniqueNumbers(final Card a, final Card b, final Card c) {
        return a.getNumber() != b.getNumber() &&
               a.getNumber() != c.getNumber() &&
               b.getNumber() != c.getNumber();
    }

    private boolean isUniqueShades(final Card a, final Card b, final Card c) {
        return a.getShading() != b.getShading() &&
               a.getShading() != c.getShading() &&
               b.getShading() != c.getShading();
    }

    private boolean isUniqueShapes(final Card a, final Card b, final Card c) {
        return a.getShape() != b.getShape() &&
                a.getShape() != c.getShape() &&
                b.getShape() != c.getShape();
    }

    private boolean isUniqueColors(final Card a, final Card b, final Card c) {
        return a.getNumber() != b.getNumber() &&
               a.getNumber() != c.getNumber() &&
               b.getNumber() != c.getNumber();
    }

    private boolean isIdenticalNumbers(final Card a, final Card b, final Card c) {
        return a.getNumber() == b.getNumber() && a.getNumber() == c.getNumber();
    }

    private boolean isIdenticalShades(final Card a, final Card b, final Card c) {
        return a.getShading() == b.getShading() && a.getShading() == c.getShading();
    }

    private boolean isIdenticalShapes(final Card a, final Card b, final Card c) {
        return a.getShape() == b.getShape() && a.getShape() == c.getShape();
    }

    private boolean isIdenticalColors(final Card a, final Card b, final Card c) {
        return a.getColor() == b.getColor() && a.getColor() == c.getColor();
    }
}
