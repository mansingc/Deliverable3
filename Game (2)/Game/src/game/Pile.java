/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Kubra Bas Arshdeep Dhalla Christopher Mansingh
 */
public class Pile {

    public static ArrayList<Card> pile = Hand.getDeck();
    ;
    public static Card topCard;
    public static Card drawnCard;

    public static Card topCard() {

        topCard = pile.get(0);
        return topCard;
    }

    public static ArrayList<Card> addToPile(Card played) {

        pile.add(0, played);
        return pile;
    }

    public static Card draw(int num) {

        drawnCard = pile.get(pile.size() - 1);
        return drawnCard;
    }
}
