//

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Card.Color;
import game.Card.Value;
//import static game.Deck.cards;
import static game.Hand.hand;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kubra Bas Arshdeep Dhalla Christopher Mansingh
 */
public class Play extends Game {

    public static ArrayList<Deck> cards;
    public static ArrayList<Card> playerHand;
    public static ArrayList<Card> compHand;
    public static boolean playerturn;
    public static boolean compturn;
    public static int size;
    public static Card topCard;
    public static Value currentValue;
    public static Color currentColor;
    public static boolean playAgain;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        size = 7;

        Player player = new Player();
        Player comp = new Player();

        playAgain = true;

        while (playAgain) {

            System.out.println("Welcome to" + getName());
            System.out.print("Enter your Name: ");
            player.setName(input.next());
            System.out.println("Hi!" + player.getName());

            Hand playerH = new Hand(player);
            Hand compH = new Hand(comp);

            playerHand = playerH.generateHand(size);
            compHand = compH.generateHand(size);

            playerturn = true;

            while (playerturn) {

                System.out.println("\nHere is your hand");
                for (int m = 1; m <= playerHand.size(); m++) {
                    System.out.println(m + " " + playerHand.get(m - 1));
                }
                System.out.println(String.valueOf(playerHand.size() + 1) + " Draw a Card");
                System.out.println(String.valueOf(playerHand.size() + 2) + " Quit");

                topCard = Pile.topCard();

                currentValue = topCard.getValue();
                currentColor = topCard.getColor();

                System.out.println("\nHere is the Top Card: " + topCard);
                System.out.println("Pick a card to play(Enter the number of "
                        + "the card) : ");

                int handIndex = input.nextInt() - 1;
                System.out.println("\nYour choice:" + playerHand.get(handIndex));

                if ((playerHand.get(handIndex).getColor()).equals(currentColor)
                        || (playerHand.get(handIndex).getValue()).equals(currentValue)) {

                    Pile.addToPile(playerHand.get(handIndex));

                    if (currentValue.equals(Value.SKIP)) {
                        System.out.println("Computer's turn skipped, your turn again");
                        playerturn = true;

                    }
                    if (currentValue.equals(Value.DRAWTWO)) {
                        System.out.println("I'm Drawing 2 cards for myself");
                        for (int i = 0; i < 2; i++) {
                            compHand.add(Pile.draw(2));
                        }
                    }
                    if (currentValue.equals(Value.REVERSE)) {
                        System.out.println("REVERSE! Your turn again");
                        playerturn = true;

                    }

                    playerturn = false;
                    compturn = true;
                    playerHand.remove(handIndex);

                } else if ((playerHand.get(handIndex).getValue()).equals(Value.WILD_FOUR)
                        || (playerHand.get(handIndex).getValue()).equals(Value.WILD)) {
                    if ((playerHand.get(handIndex).getValue()).equals(Value.WILD_FOUR)) {

                        System.out.println("\nI'm Drawing 4 cards for myself");
                        for (int i = 0; i < 4; i++) {
                            compHand.add(Pile.draw(4));
                        }
                    }
                    System.out.println("\nChoose a color");

                    System.out.println("\n1:RED, 2:BLUE, 3:GREEN, FOUR:Yellow");
                    int color = input.nextInt();
                    if (color == 1) {
                        currentColor = Card.Color.RED;
                    } else if (color == 2) {
                        currentColor = Card.Color.BLUE;
                    } else if (color == 2) {
                        currentColor = Card.Color.GREEN;
                    } else {
                        currentColor = Card.Color.YELLOW;
                    }
                
                     playerHand.remove(handIndex);

                } else {
                    System.out.println("\nYou can't play this Card! my turn!");
                    playerturn = false;
                    compturn = true;
                }

                if (handIndex == playerHand.size() + 2) { // terminate the game if user wants to quit
                    playAgain = false;
                    break;

                } else if (handIndex == playerHand.size() + 1) {//Draw a card
                    playerHand.add(Pile.draw(1));
                }

                while (compturn) {

                    System.out.println("\nI have " + compHand.size()
                            + " cards in my hand!" + ((compHand.size() == 1) ? "...Uno!" : ""));

                    System.out.println("Top Card is: " + Pile.topCard());

                    for (int i = 0; i < compHand.size(); i++) {
                        if ((compHand.get(i).getColor()).equals(currentColor)
                                || (compHand.get(i).getValue()).equals(currentValue)) {
                            
                            Card playableCard = compHand.get(i);
                            Pile.addToPile(playableCard);
                            
                            if (currentValue.equals(Value.SKIP)) {
                                System.out.println("your turn skipped, my turn again");
                                compturn = true;

                            }
                            if (currentValue.equals(Value.DRAWTWO)) {
                                System.out.println("\nI'm Drawing 2 cards for you!");
                                for (int j = 0; j < 2; j++) {
                                    playerHand.add(Pile.draw(2));
                                }
                            }
                            if (currentValue.equals(Value.REVERSE)) {
                                System.out.println("REVERSE! my turn again");
                                compturn = true;

                            }
                            
                            if(playableCard != null){
                            System.out.println("My choice:" + compHand.get(i));
                            compHand.remove(i);
                            compturn = false;
                            playerturn = true;
                            break;
                            }
                            
                        } else if ((compHand.get(i).getValue()).equals(Value.WILD_FOUR)
                                || (compHand.get(i).getValue()).equals(Value.WILD)) {
                            if ((compHand.get(i).getValue()).equals(Value.WILD_FOUR)) {

                                System.out.println("\nI'm Drawing 4 cards for you!");
                                for (int k = 0; k < 4; k++) {
                                    playerHand.add(Pile.draw(4));
                                    compturn = false;
                                    playerturn = true;
                                    break;
                                }
                            }
                        }
                    }



                }
            }
        }
    }
}
