package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameOfSet {
    public static final int NUM_OF_CARDS_IN_DECK = 54;
    public static final int NUM_OF_CARDS_DEALT = 12;

    private List<Card> board = new ArrayList<Card>();
    private List<Card> deck = new ArrayList<Card>();
    private List<Player> players = new ArrayList<Player>();

    private Random generator = new Random();

    public boolean gameOver() {
        return this.deck.size() == 0;
    }

    public void start() {
        // Initialize players
        System.out.print("Enter the number of players: ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < scanner.nextInt(); i++) {
            players.add(new Player());
        }

        // Initialize deck of cards
        for (int i = 0; i < NUM_OF_CARDS_IN_DECK; i++) {
            this.deck.add(new Card());
        }

        // Initialize board of cards
        for (int i = 0; i < NUM_OF_CARDS_DEALT; i++) {
            Card cardDrawn = this.deck.remove(generator.nextInt(this.deck.size()));
            this.board.add(cardDrawn);
        }

        // Game logic
        while (!gameOver()) {
            // if set is found
                // give current set to current player

            // draw three from deck, and add them to the board

            // move on to next player



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
