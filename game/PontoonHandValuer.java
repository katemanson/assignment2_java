package game;
import java.util.*;

public class PontoonHandValuer implements HandValuer {

  public int getHandValue(Hand hand) {
    int handValue = 0;
    int cardValue = 0;
    for (Card card : hand.getSet()) {
      switch (card.getRank()) {
        case TWO: cardValue = 2;
                  break;
        case THREE: cardValue = 3;
                  break;
        case FOUR: cardValue = 4;
                  break;
        case FIVE: cardValue = 5;
                  break;
        case SIX: cardValue = 6;
                  break;
        case SEVEN: cardValue = 7;
                  break;
        case EIGHT: cardValue = 8;
                  break;
        case NINE: cardValue = 9;
                  break;
        case TEN: case JACK: case QUEEN: case KING:
                  cardValue = 10;
                  break;
        case ACE: cardValue = 11;
                  break;
      } 
      handValue += cardValue;
    }
    return handValue;
  }

  public boolean checkIfBust(Hand hand) {
    int handValue = getHandValue(hand);
    if (handValue > 21) { 
      return true; 
    }
    return false;
  }

  public boolean checkForPontoon(Hand hand) {
    int handSize = hand.countCards();
    int handValue = getHandValue(hand);
    if (handSize == 2 && handValue == 21) {
      return true;
    }
    return false;
  }

  public boolean checkForFiveCardTrick(Hand hand) {
    int handSize = hand.countCards();
    int handValue = getHandValue(hand);
    if (handSize == 5 && handValue <= 21) {
      return true;
    }
    return false;
  }








}