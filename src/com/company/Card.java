package com.company;

import java.util.Random;

public class Card {
    private Color color;
    private Shape shape;
    private Shading shade;
    private Number number;

    // Default constructor sets all properties to random values
    public Card() {
        final Random randomGenerator = new Random();
        this.color = Color.values()[randomGenerator.nextInt(Color.values().length)];
        this.shape = Shape.values()[randomGenerator.nextInt(Shape.values().length)];
        this.shade = Shading.values()[randomGenerator.nextInt(Shading.values().length)];
        this.number = Number.values()[randomGenerator.nextInt(Number.values().length)];
    }

    public Card(final Color color,
                final Shape shape,
                final Shading shade,
                final Number number) {
        this.color = color;
        this.shape = shape;
        this.shade = shade;
        this.number = number;
    }

    public Color getColor() { return color; }
    public Shape getShape() { return shape; }
    public Shading getShading() { return shade; }
    public Number getNumber() { return number; }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.color);
        sb.append(" : ");
        sb.append(this.shape);
        sb.append(" : ");
        sb.append(this.shade);
        sb.append(" : ");
        sb.append(this.number);
        return sb.toString();
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Card other = (Card) obj;
        return other.getNumber() == this.number &&
               other.getShading() == this.shade &&
               other.getShape() == this.shape &&
               other.getColor() == this.color;
    }
}

enum Color {
    RED, GREEN, PURPLE
}

enum Shape {
    DIAMOND, SQUIGGLE, OVAL
}

enum Shading {
    SOLID, EMPTY, STRIPED
}

enum Number {
    ONE, TWO, THREE
}