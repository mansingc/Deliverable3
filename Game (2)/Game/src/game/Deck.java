/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kubra Bas Arshdeep Dhalla Christopher Mansingh
 */
public class Deck {

    /**
     *
     */
    public static ArrayList<Card> cards;
    public static int index;

    public Deck() {
        cards = new ArrayList<Card>();
    }

//    public Deck(int size, Color color, Value value) {
//        super(color, value);
//        this.size = size;
//    }
//    
//      public Deck(ArrayList<Card> cards, int size, Color color, Value value) {
//        super(color, value);
//        this.cards = cards;
//        this.size = size;
//    }
//
//
//    public void setCards(ArrayList<Card> cards) {
//        this.cards = cards;
//    }

    public ArrayList<Card> getCards() {
       return setTheDeck();
    }
    
    public static ArrayList<Card> setTheDeck() {

        Card.Color[] colors = Card.Color.values();
        Card.Value[] values = Card.Value.values();
        index = 0;

        //Colors' Last index is wild! don't count it 
        for (int i = 0; i < colors.length -1; i++) {

            //Color index
            Card.Color color = colors[i];

            //Create one 0 card for each color
            cards.add(index++, new GroupOfCards(color, values[0]));

            //create two cards 1-9 for each color
            for (int j = 1; j < 10; j++) {

                cards.add(index++, new GroupOfCards(color, values[j]));
                cards.add(index++, new GroupOfCards(color, values[j]));
            }

            //Put action cards into an array named actionValues
            Card.Value[] actionValues = new Card.Value[]{Card.Value.DRAWTWO,
                Card.Value.SKIP, Card.Value.REVERSE};

            //Create 2 action Cards for each color
            for (Card.Value value : actionValues) {
                cards.add(index++, new GroupOfCards(color, value));
                cards.add(index++, new GroupOfCards(color, value));
            }
        }
            //Put wild cards into an array named wildValues
            Card.Value[] wildValues = new Card.Value[]{Card.Value.WILD, Card.Value.WILD_FOUR};
            //Create four wild and wild4 card
            for (Card.Value value : wildValues) {
                //We use the 'WILD' elemet of the colors class to call the wild values 
                for (int l = 0; l < 4; l++) {
                    cards.add(index++, new GroupOfCards(Card.Color.WILD, value));
                }
            }
       shuffle();
       return cards;
        
    }
    
        public static void shuffle() {
        Collections.shuffle(cards);
    }
        public void printCards(){
              for(int m= 1; m <= cards.size() ; m++){
            System.out.println(m +" "+ cards.get(m-1));
        }
}
}

    
