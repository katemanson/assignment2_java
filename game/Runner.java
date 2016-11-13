import java.util.*;
import game.*;

public class Runner {

  public static void main(String[] args) {

    PontoonGame game = new PontoonGame();
    game.setUpNewDeck();
    game.deal(2);
    Deck deck = game.getDeck();

    System.out.println("Deck:");
    for (Card card : deck.getSet()) {
      System.out.println(card.getRank() + " of " + card.getSuit());
    }
    System.out.println();

    System.out.println("App hand:");
    for (Card card : game.getAppPlayer().getHand().getSet()) {
        System.out.println(card.getRank() + " of " + card.getSuit());
    }
    System.out.println();
    
    System.out.println("User hand:");
    for (Card card : game.getUserPlayer().getHand().getSet()) {
        System.out.println(card.getRank() + " of " + card.getSuit());
    }

    
    
    // deck.cut();
    // System.out.println("Cut deck:");
    // for (Card card : deck.getSet()) {
    //   System.out.println(card.getRank() + " of " + card.getSuit());
    // }
    // System.out.println();

    // deck.shuffle();
    // System.out.println("Shuffled deck:");
    // for (Card card : deck.getSet()) {
    //   System.out.println(card.getRank() + " of " + card.getSuit());
    // }
    




  }

}