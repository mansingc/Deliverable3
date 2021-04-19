/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Deck.cards;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kbas0
 */
public class Hand extends Deck {

    public static ArrayList<Card> hand;
    public int index;
    public String name;
    public static int size;
    public static ArrayList<Card> leftDeck;
    static ArrayList<Card> deck = new ArrayList<Card>();

    public Hand(Player player) {
        
        generateDeck();
    }

    
    public Hand(ArrayList<Card> hand, int index, String name) {
        this.hand = hand;
        this.index = index;
        this.name = name;
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    
    static Random random = new Random();

    static Deck setDeck = new Deck();
   

    
    public static ArrayList<Card> generateDeck(){

    deck = setDeck.getCards();
    return deck;
    
    }

    public static ArrayList<Card> generateHand(int size) {

 

        hand = new ArrayList<Card>();

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(107);
            hand.add(i, deck.get(randomIndex));

        }

        leftDeck(deck);
//        System.out.println("Here is your hand");
//        for (int m = 1; m <= hand.size(); m++) {
//            System.out.println(m + " " + hand.get(m - 1));
//
//        }
        return hand;

    }

    public static ArrayList<Card> leftDeck(ArrayList<Card> deck) {
        for (int j = 0; j < hand.size(); j++) {
            deck.remove(hand.get(j));
        }
        return deck;
    }

    public static void displayDeck() {
        System.out.println("Here is the deck");
        for (int m = 1; m <= cards.size(); m++) {
            System.out.println(m + " " + cards.get(m - 1));
        }
    }
}
