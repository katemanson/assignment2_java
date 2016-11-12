import java.util.*;
import game.*;

public class Runner {

  public static void main(String[] args) {

    SetOfCards set = new SetOfCards();
    Card aceOfHearts = new Card(Suit.HEARTS, Rank.ACE);
    Card nineOfClubs = new Card(Suit.CLUBS, Rank.NINE);
    Card tenOfDiamonds = new Card(Suit.DIAMONDS, Rank.TEN);
    Card queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);
    Card threeOfClubs = new Card(Suit.CLUBS, Rank.THREE);
    set.addCard(aceOfHearts);
    set.addCard(nineOfClubs);
    set.addCard(tenOfDiamonds);
    set.addCard(queenOfSpades);
    set.addCard(threeOfClubs);
    Deck deck = new OneStandardDeck();

    deck.buildDeck();
    System.out.println("Deck:");
    for (Card card : deck.getSet()) {
      System.out.println(card.getRank() + " of " + card.getSuit());
    }
    System.out.println();
    
    deck.cut();
    System.out.println("Cut deck:");
    for (Card card : deck.getSet()) {
      System.out.println(card.getRank() + " of " + card.getSuit());
    }
    System.out.println();

    deck.shuffle();
    System.out.println("Shuffled deck:");
    for (Card card : deck.getSet()) {
      System.out.println(card.getRank() + " of " + card.getSuit());
    }
    




  }

}