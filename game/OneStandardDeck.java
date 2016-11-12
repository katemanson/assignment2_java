package game;
import java.util.*;

public class OneStandardDeck extends Deck {

  public void buildDeck() {
    EnumSet<Rank> standardRanks = EnumSet.range(Rank.TWO, Rank.ACE);
    for (Suit suit : Suit.values()) {
      for (Rank rank : standardRanks) {
        Card card = new Card(suit, rank);
        this.set.add(card);
      }
    }
  }

}