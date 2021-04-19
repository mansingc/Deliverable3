/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Deck.cards;
import java.util.ArrayList;

/**
 *
 * @author kbas0
 */
public abstract class Game {
    
 private static String name;
 private ArrayList<Player> players;

//    public Game(ArrayList<Player> players) {
//        this.players = players;
//    }

    public static String getName() {
        return name=" Game -UNO";
    }

    public static void setName() {
        name = "Game -UNO";
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
 
 
        
}
    

