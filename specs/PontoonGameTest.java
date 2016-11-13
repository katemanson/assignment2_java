import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import game.*;

public class PontoonGameTest {

  PontoonGame game;
  Card twoOfHearts;
  Card kingOfClubs;
  Card aceOfDiamonds;
  Card sevenOfSpades;
  Card sixOfSpades;
  Card sixOfClubs;
  Hand hand;

  @Before
  public void before() {
    game = new PontoonGame();
    twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
    kingOfClubs = new Card(Suit.CLUBS, Rank.KING);
    aceOfDiamonds = new Card(Suit.DIAMONDS, Rank.ACE);
    sevenOfSpades = new Card(Suit.SPADES, Rank.SEVEN);
    sixOfSpades = new Card(Suit.SPADES, Rank.SIX);
    sixOfClubs = new Card(Suit.CLUBS, Rank.SIX);
    hand = new Hand();
  }

  @Test
  public void canGetAppPlayer() {
    assertEquals(true, game.getAppPlayer().getDealerStatus());
  }

  @Test 
  public void canGetUserPlayer() {
    assertEquals(false, game.getUserPlayer().getDealerStatus());
  }

  @Test
  public void canGetDeck() {
    assertEquals(0, game.getDeck().countCards());
  }

  @Test
  public void canGetHandValuer() {
    hand.addCard(kingOfClubs);
    hand.addCard(aceOfDiamonds);
    assertEquals(21, game.getHandValuer().getHandValue(hand));
  }

  @Test
  public void canSetUpNewDeck() {
    game.setUpNewDeck();
    assertEquals(52, game.getDeck().countCards());
  }

  @Test
  public void canDeal() {
    game.setUpNewDeck();
    game.deal(2);
    assertEquals(48, game.getDeck().countCards());
    assertEquals(2, game.getAppPlayer().getHand().countCards());
    assertEquals(2, game.getUserPlayer().getHand().countCards());
  }

  @Test
  public void canCheckForAppPontoon_Pontoon() {
    game.getAppPlayer().getHand().addCard(kingOfClubs);
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(true, game.checkForAppPontoon());
  }

  @Test
  public void canCheckForAppPontoon_NoPontoon() {
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    assertEquals(false, game.checkForAppPontoon());
  }

  @Test
  public void canCheckForUserPontoon_Pontoon() {
    game.getUserPlayer().getHand().addCard(kingOfClubs);
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(true, game.checkForUserPontoon());
  }

  @Test
  public void canCheckForUserPontoon_NoPontoon() {
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    assertEquals(false, game.checkForUserPontoon());
  }

  @Test
  public void canGetAppHandValue() {
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    assertEquals(13, game.getAppHandValue());
  }

  @Test
  public void canGetUserHandValue() {
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    assertEquals(17, game.getUserHandValue());
  }

  @Test
  public void canGetAppHandSize() {
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    assertEquals(4, game.getAppHandSize());
  }

  @Test
  public void canGetUserHandSize() {
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    assertEquals(3, game.getUserHandSize());
  }

  @Test
  public void appCanTwist() {
    game.setUpNewDeck();
    game.deal(2);
    game.appTwist();
    assertEquals(3, game.getAppHandSize());
    assertEquals(47, game.getDeck().countCards());
  }

  @Test
  public void userCanTwist() {
    game.setUpNewDeck();
    game.deal(2);
    game.userTwist();
    assertEquals(3, game.getUserHandSize());
    assertEquals(47, game.getDeck().countCards());
  }

  @Test
  public void canCheckIfAppBust_NotBust() {
    game.getAppPlayer().getHand().addCard(kingOfClubs);
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(false, game.checkIfAppBust());
  }

  @Test
  public void canCheckIfAppBust_Bust() {
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(true, game.checkIfAppBust());
  }

  @Test
  public void canCheckIfUserBust_NotBust() {
    game.getUserPlayer().getHand().addCard(kingOfClubs);
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(false, game.checkIfUserBust());
  }

  @Test
  public void canCheckIfUserBust_Bust() {
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    assertEquals(true, game.checkIfUserBust());
  }

  @Test
  public void canCheckForAppFCT_FCT() {
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(twoOfHearts);
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(twoOfHearts);
    game.getAppPlayer().getHand().addCard(twoOfHearts);
    assertEquals(true, game.checkForAppFCT());
  }

  @Test
  public void canCheckForAppFCT_NoFCT() {
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    game.getAppPlayer().getHand().addCard(aceOfDiamonds);
    game.getAppPlayer().getHand().addCard(sevenOfSpades);
    game.getAppPlayer().getHand().addCard(sixOfSpades);
    assertEquals(false, game.checkForAppFCT());
  }

  @Test
  public void canCheckForUserFCT_FCT() {
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(twoOfHearts);
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(twoOfHearts);
    game.getUserPlayer().getHand().addCard(twoOfHearts);
    assertEquals(true, game.checkForUserFCT());
  }

  @Test
  public void canCheckForUserFCT_NoFCT() {
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    game.getUserPlayer().getHand().addCard(aceOfDiamonds);
    game.getUserPlayer().getHand().addCard(sevenOfSpades);
    game.getUserPlayer().getHand().addCard(sixOfSpades);
    assertEquals(false, game.checkForUserFCT());
  }
















  // @Test
  // public void canGetHandValueForPlayer() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(twoOfHearts);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   assertEquals(12, game.getHandValueForPlayer(0));
  // }

  // // @Test
  // // public void canGetWinner() {
  // //   game.addPlayer("Dealer0");
  // //   game.getPlayer(0).getHand().addCard(twoOfHearts);
  // //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  // //   game.addPlayer("Player1");
  // //   game.getPlayer(1).getHand().addCard(aceOfDiamonds);
  // //   game.getPlayer(1).getHand().addCard(sevenOfSpades);
  // //   assertEquals("Dealer0", game.getWinner().getName());
  // // }

  // // @Test
  // // public void canGetDraw() {
  // //   game.addPlayer("Dealer0");
  // //   game.getPlayer(0).getHand().addCard(twoOfHearts);
  // //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  // //   game.addPlayer("Player1");
  // //   game.getPlayer(1).getHand().addCard(sixOfSpades);
  // //   game.getPlayer(1).getHand().addCard(sixOfClubs);
  // //   assertEquals(null, game.getWinner());
  // // }

  // @Test
  // public void canStickOrTwist() {
  //   game.addPlayer("Dealer0");
  //   game.addPlayer("Player1");
  //   game.deal(2);
  //   assertEquals(48, game.getGameDeck().countCards());
  //   assertEquals(2, game.getPlayer(0).getHand().countCards());
  //   assertEquals(2, game.getPlayer(1).getHand().countCards());
  //   game.stickOrTwist(1, "t");
  //   game.stickOrTwist(0, "s");
  //   assertEquals(2, game.getPlayer(0).getHand().countCards());
  //   assertEquals(3, game.getPlayer(1).getHand().countCards());
  // }

  // @Test
  // public void canCheckForBust() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(sevenOfSpades);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   assertEquals(false, game.checkForBust(0));
  //   game.getPlayer(0).getHand().addCard(sixOfClubs);
  //   assertEquals(true, game.checkForBust(0));
  // }

  // @Test
  // public void canCheckForWinner__bothBust() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   assertEquals(null, game.checkForWinner());
  // }

  // @Test
  // public void canCheckForWinner__oneBust() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   assertEquals("Player1", game.checkForWinner().getName());
  // }

  // @Test
  // public void canCheckForWinner__neitherBustWin() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   game.getPlayer(1).getHand().addCard(sixOfClubs);
  //   assertEquals("Dealer0", game.checkForWinner().getName());
  // }

  // @Test
  // public void canCheckForWinner__neitherBustDraw() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   game.getPlayer(1).getHand().addCard(kingOfClubs);
  //   assertEquals(null, game.checkForWinner());
  // }

  // @Test
  // public void canCheckForPontoon_Pontoon() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(aceOfDiamonds);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   assertEquals(true, game.checkForPontoon(0));
  // }

  // @Test
  // public void canCheckForPontoon_NoPontoon() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(sixOfClubs);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   assertEquals(false, game.checkForPontoon(0));
  // }

}