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
public class GroupOfCards extends Card{
    

    private int size;
    private ArrayList<Card> cards;
    
//     public GroupOfCards(){
//         
//     }
    
   public GroupOfCards(Color color, Value value) {
        super(color, value);
    }
    
    public GroupOfCards(int size, ArrayList<Card> cards, Color color, Value value) {
        super(color, value);
        this.size = size;
        this.cards = cards;
    }

 

    public int getSize() {
        return this.size;
    }

    /**
     * 
     * @param cards
     */
    public void setSize(int cards) {
        this.size = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void getCards() {
        // TODO - implement GroupOfCards.getCards
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param cards
     */

    
    
    public String toString() {
        return  super.getColor() + " " + super.getValue();
    }    

}
