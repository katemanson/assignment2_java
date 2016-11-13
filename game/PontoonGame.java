package game;
import java.util.*;

public class PontoonGame {

  private Player appPlayer;
  private Player userPlayer;
  private Deck deck;
  private PontoonHandValuer handValuer;

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

  public boolean checkForAppPontoon() {
    Hand appHand = this.appPlayer.getHand();
    boolean pontoon = this.handValuer.checkForPontoon(appHand);
    return pontoon;
  }

  public boolean checkForUserPontoon() {
    Hand userHand = this.userPlayer.getHand();
    boolean pontoon = this.handValuer.checkForPontoon(userHand);
    return pontoon;
  }

  public int getAppHandValue() {
    Hand appHand = this.appPlayer.getHand();
    int value = this.handValuer.getHandValue(appHand);
    return value;
  }

  public int getUserHandValue() {
    Hand userHand = this.userPlayer.getHand();
    int value = this.handValuer.getHandValue(userHand);
    return value;
  }

  public int getAppHandSize() {
    Hand appHand = this.appPlayer.getHand();
    int size = appHand.countCards();
    return size;
  }

  public int getUserHandSize() {
    Hand userHand = this.userPlayer.getHand();
    int size = userHand.countCards();
    return size;
  }

  public void appTwist() {
    Card twistCard = this.deck.removeFirstCard();
    Hand appHand = this.appPlayer.getHand();
    appHand.addCard(twistCard);
  }

  public void userTwist() {
    Card twistCard = this.deck.removeFirstCard();
    Hand userHand = this.userPlayer.getHand();
    userHand.addCard(twistCard);
  }

  public boolean checkIfAppBust() {
    Hand appHand = this.appPlayer.getHand();
    boolean bust = this.handValuer.checkIfBust(appHand);
    return bust;
  }

  public boolean checkIfUserBust() {
    Hand userHand = this.userPlayer.getHand();
    boolean bust = this.handValuer.checkIfBust(userHand);
    return bust;
  }

  // FCT - Five Card Trick
  public boolean checkForAppFCT() {
    Hand appHand = this.appPlayer.getHand();
    boolean fiveCardTrick = this.handValuer.checkForFiveCardTrick(appHand);
    return fiveCardTrick;
  }

  // FCT - Five Card Trick
  public boolean checkForUserFCT() {
    Hand userHand = this.userPlayer.getHand();
    boolean fiveCardTrick = this.handValuer.checkForFiveCardTrick(userHand);
    return fiveCardTrick;
  }

  public void playInitialDeal() {
    deal(2);
  }

  public String playInitialCheck() {

    int appValue = getAppHandValue();
    int userValue = getUserHandValue();
    boolean appPontoon = checkForAppPontoon();
    boolean userPontoon = checkForUserPontoon();
    
    String resultBothPontoon = "You both have Pontoon. \nDealer wins.";
    String resultAppPontoon = "You have " + userValue + ". \nDealer has Pontoon. \nDealer wins.";
    String resultUserPontoon = "You have Pontoon. \nDealer has " + appValue + ". \nYou win!";

    if ( appPontoon && userPontoon ) {
      return resultBothPontoon;
    }
    else if ( appPontoon && !userPontoon) {
      return resultAppPontoon;
    }
    else if ( !appPontoon && userPontoon) {
      return resultUserPontoon;
    }
    return null;
  }

  public String checkUserHand() {

    int handSize = getUserHandSize();
    int handValue = getUserHandValue();
    boolean userBust = checkIfUserBust();
    // FCT - Five Card Trick
    boolean userFCT = checkForUserFCT(); 

    String haveToTwist = "Since your hand is worth less than 15, you have to twist."; 
    String stickOrTwist = "Stick or twist?";
    String resultUserBust = "You're bust. \nDealer wins.";
    String outcomeUserFCT = "You have a Five Card Trick! \nDealer's turn!";

    if ( handSize < 5 && handValue < 15 ) {
      return haveToTwist;
    }
    else if ( handSize >= 5 ) {
      if ( handValue > 21 ) {
        return resultUserBust;
      }
      else if ( handValue <= 21 ) {
        return outcomeUserFCT;
      }
    }
    else if ( handValue >= 15 && handValue <= 21 ) {
      return stickOrTwist;
    }
    return resultUserBust;
  }




}