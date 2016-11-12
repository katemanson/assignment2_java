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

  @Before
  public void before() {
    game = new Game(new StandardDeck(), new PontoonValues());
    twoOfHearts = new Card(Suit.HEARTS, Rank.TWO);
    kingOfClubs = new Card(Suit.CLUBS, Rank.KING);
    aceOfDiamonds = new Card(Suit.DIAMONDS, Rank.ACE);
    sevenOfSpades = new Card(Suit.SPADES, Rank.SEVEN);
    sixOfSpades = new Card(Suit.SPADES, Rank.SIX);
    sixOfClubs = new Card(Suit.CLUBS, Rank.SIX);
  }

  @Test
  public void canAddPlayer() {
    game.addPlayer("Player");
    ArrayList<Player> players = game.getPlayers();
    assertEquals(1, players.size());
  }

  @Test
  public void canGetPlayer() {
    game.addPlayer("Dealer0");
    game.addPlayer("Player1");
    assertEquals("Dealer0", game.getPlayer(0).getName());
  }

  @Test
  public void canDeal() {
    game.addPlayer("Dealer0");
    game.addPlayer("Player1");
    game.addPlayer("Player2");
    game.deal(2);
    assertEquals(46, game.getGameDeck().countCards());
    assertEquals(2, game.getPlayer(0).getHand().countCards());
    assertEquals(2, game.getPlayer(1).getHand().countCards());
    assertEquals(2, game.getPlayer(2).getHand().countCards());
  }

  @Test
  public void canGetHandValueForPlayer() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(twoOfHearts);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    assertEquals(12, game.getHandValueForPlayer(0));
  }

  // @Test
  // public void canGetWinner() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(twoOfHearts);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(aceOfDiamonds);
  //   game.getPlayer(1).getHand().addCard(sevenOfSpades);
  //   assertEquals("Dealer0", game.getWinner().getName());
  // }

  // @Test
  // public void canGetDraw() {
  //   game.addPlayer("Dealer0");
  //   game.getPlayer(0).getHand().addCard(twoOfHearts);
  //   game.getPlayer(0).getHand().addCard(kingOfClubs);
  //   game.addPlayer("Player1");
  //   game.getPlayer(1).getHand().addCard(sixOfSpades);
  //   game.getPlayer(1).getHand().addCard(sixOfClubs);
  //   assertEquals(null, game.getWinner());
  // }

  @Test
  public void canStickOrTwist() {
    game.addPlayer("Dealer0");
    game.addPlayer("Player1");
    game.deal(2);
    assertEquals(48, game.getGameDeck().countCards());
    assertEquals(2, game.getPlayer(0).getHand().countCards());
    assertEquals(2, game.getPlayer(1).getHand().countCards());
    game.stickOrTwist(1, "t");
    game.stickOrTwist(0, "s");
    assertEquals(2, game.getPlayer(0).getHand().countCards());
    assertEquals(3, game.getPlayer(1).getHand().countCards());
  }

  @Test
  public void canCheckForBust() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(sevenOfSpades);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    assertEquals(false, game.checkForBust(0));
    game.getPlayer(0).getHand().addCard(sixOfClubs);
    assertEquals(true, game.checkForBust(0));
  }

  @Test
  public void canCheckForWinner__bothBust() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.addPlayer("Player1");
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    assertEquals(null, game.checkForWinner());
  }

  @Test
  public void canCheckForWinner__oneBust() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.addPlayer("Player1");
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    assertEquals("Player1", game.checkForWinner().getName());
  }

  @Test
  public void canCheckForWinner__neitherBustWin() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.addPlayer("Player1");
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    game.getPlayer(1).getHand().addCard(sixOfClubs);
    assertEquals("Dealer0", game.checkForWinner().getName());
  }

  @Test
  public void canCheckForWinner__neitherBustDraw() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    game.addPlayer("Player1");
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    game.getPlayer(1).getHand().addCard(kingOfClubs);
    assertEquals(null, game.checkForWinner());
  }

  @Test
  public void canCheckForPontoon_Pontoon() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(aceOfDiamonds);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    assertEquals(true, game.checkForPontoon(0));
  }

  @Test
  public void canCheckForPontoon_NoPontoon() {
    game.addPlayer("Dealer0");
    game.getPlayer(0).getHand().addCard(sixOfClubs);
    game.getPlayer(0).getHand().addCard(kingOfClubs);
    assertEquals(false, game.checkForPontoon(0));
  }

}