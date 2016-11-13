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

    boolean appPontoon = checkForAppPontoon();
    boolean userPontoon = checkForUserPontoon();
    int appValue = getAppHandValue();
    int userValue = getUserHandValue();
    
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




}