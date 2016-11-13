package game;
import java.util.*;

public class PontoonGame {

  private Player appPlayer;
  private Player userPlayer;
  private Deck deck;
  private HandValuer handValuer;

  public PontoonGame () {
    this.appPlayer = new Player("AppPlayer", true);
    this.userPlayer = new Player("UserPlayer", false);
    this.deck = new OneStandardDeck();
    this.handValuer = new PontoonHandValuer();
  }

  public Player getAppPlayer() {
    return this.appPlayer;
  }

  public Player getUserPlayer() {
    return this.userPlayer;
  }

  public Deck getDeck() {
    return this.deck;
  }

  public HandValuer getHandValuer() {
    return this.handValuer;
  }

  public void setUpNewDeck() {
    this.deck.buildDeck();
    this.deck.shuffle();
    this.deck.shuffle();
    this.deck.cut();
  }

  public void deal(int numberOfCards) {
    List<Player> playerList = new ArrayList<Player>();
    playerList.add(this.appPlayer);
    playerList.add(this.userPlayer);
    for ( int i = 0; i < numberOfCards; i++ ) {
      for ( Player player : playerList ) {
        Card dealtCard = this.deck.removeFirstCard();
        player.getHand().addCard(dealtCard);
      }
    }
  }

  // public int getHandValueForPlayer(int playerIndex) {
  //   Player player = getPlayer(playerIndex);
  //   ArrayList<Card> hand = player.getHand().getSetOfCards();
  //   int value = this.valueType.getHandValue(hand);
  //   return value;
  // }

  // public void stickOrTwist(int playerIndex, String playerDecision) {
  //   if (playerDecision == "t") {
  //     Card dealtCard = this.gameDeck.removeFirstCard();
  //     getPlayer(playerIndex).getHand().addCard(dealtCard);
  //   }
  //   return;
  // }

  // public boolean checkForBust(int playerIndex) {
  //   return getHandValueForPlayer(playerIndex) > 21;
  // }

  // public boolean checkForPontoon(int playerIndex) {
  //   return getHandValueForPlayer(playerIndex) == 21;
  // }

  // public Player checkForPontoonOrBust() {
  //   if (checkForPontoon(0) && checkForPontoon(1)) {
  //     // "You both have Pontoon! It's a draw."
  //     System.out.println()
  //     // Show dealer cards
  //     // "Play again?" y/n
  //     // Start again or end
  //   }
  //   else if (checkforPontoon(0) || checkforPontoon(1)) {
  //     // if loop for player or dealer Pontoon
  //       // if player Pontoon:
  //       // "You have Pontoon! You win!"
  //       // else if dealer Pontoon:
  //       // "Dealer has Pontoon! Dealer wins!"
  //       // Then (for both):
  //       // Show dealer cards
  //       // "Play again?" y/n
  //       // Start again or end
  //   }
  //   else if (checkForBust(0) && checkForBust(1)) {
  //     // "You're both bust! Nobody wins."
  //     // Show dealer cards
  //     // "Play again" y/n
  //     // Start again or end
  //   }
  //   else if (checkForBust(0) || checkForBust(1)) {
  //     // if loop for player or dealer bust
  //       // if player bust:
  //         // "You're bust! Dealer wins!"
  //       // if dealer bust:
  //         // "Dealer's bust! You win!"
  //       // Then (for both):
  //         // Show dealer cards
  //         // Play again, etc.
  //   }
  //     for (Player player : this.players) {
  //       int index = this.players.indexOf(player);
  //       if (checkForBust(index) != true) {
  //         return player;
  //       }
  //     }
  //   }
  //   else {
  //     if (getHandValueForPlayer(0) > getHandValueForPlayer(1)) {
  //       return getPlayer(0);
  //     }
  //     else if (getHandValueForPlayer(0) < getHandValueForPlayer(1)) {
  //       return getPlayer(1);
  //     }
  //   }
  //   return null;
  // }



}