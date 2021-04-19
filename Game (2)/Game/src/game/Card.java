/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Kubra Bas Arshdeep Dhakla Christopher Mansingh
 */
public abstract class Card {

    private final Color color;
    private final Value value;

    enum Color {
        RED, BLUE, GREEN, YELLOW, WILD;

        private static final Color[] colors = Color.values();

    }

    enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, DRAWTWO, SKIP, REVERSE, WILD, WILD_FOUR;

        private static final Value[] values = Value.values();

    }

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor(int i) {
        return Color.colors[i];
    }

    public Color getColor() {
        return color;
    }


    public static Value getValue(int i) {
        return Value.values[i];
    }

    public Value getValue() {
        return value;
    }
    

    @Override
    public String toString() {
        return "color=" + color + ", value=" + value + '}';
    }

}
