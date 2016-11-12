import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import game.*;

public class SetOfCardsTest {

  SetOfCards set;
  Card aceOfHearts;
  Card nineOfClubs;
  Card tenOfDiamonds;
  Card queenOfSpades;
  Card threeOfClubs;

  @Before
  public void before() {
    set = new SetOfCards();
    aceOfHearts = new Card(Suit.HEARTS, Rank.ACE);
    nineOfClubs = new Card(Suit.CLUBS, Rank.NINE);
    tenOfDiamonds = new Card(Suit.DIAMONDS, Rank.TEN);
    queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);
    threeOfClubs = new Card(Suit.CLUBS, Rank.THREE);
  }

  @Test
  public void canGetSet() {
    assertEquals(0, set.getSet().size());
  }

  @Test
  public void setStartsEmpty() {
    assertEquals(0, set.countCards());
  }

  @Test
  public void canAddCard() {
    set.addCard(aceOfHearts);
    set.addCard(nineOfClubs);
    assertEquals(2, set.countCards());
  }

  @Test
  public void canAddCardsFromAnotherSet() {
    SetOfCards populatedSet = new SetOfCards();
    populatedSet.addCard(aceOfHearts);
    populatedSet.addCard(nineOfClubs);
    populatedSet.addCard(tenOfDiamonds);
    populatedSet.addCard(queenOfSpades);
    populatedSet.addCard(threeOfClubs);
    assertEquals(5, populatedSet.countCards());
    set.addCardsFromAnotherSet(populatedSet);
    assertEquals(5, set.countCards());
  }

  @Test
  public void canGetCardWithIndex() {
    SetOfCards populatedSet = new SetOfCards();
    populatedSet.addCard(aceOfHearts);
    populatedSet.addCard(nineOfClubs);
    populatedSet.addCard(tenOfDiamonds);
    populatedSet.addCard(queenOfSpades);
    populatedSet.addCard(threeOfClubs);
    Card card = populatedSet.getCardWithIndex(2);
    assertEquals(5, populatedSet.countCards());
    assertEquals(Suit.DIAMONDS, card.getSuit());
    assertEquals(Rank.TEN, card.getRank());
  }

  @Test
  public void canRemoveCardWithIndex() {
    SetOfCards populatedSet = new SetOfCards();
    populatedSet.addCard(aceOfHearts);
    populatedSet.addCard(nineOfClubs);
    populatedSet.addCard(tenOfDiamonds);
    populatedSet.addCard(queenOfSpades);
    populatedSet.addCard(threeOfClubs);
    Card card = populatedSet.removeCardWithIndex(1);
    assertEquals(4, populatedSet.countCards());
    assertEquals(Suit.CLUBS, card.getSuit());
    assertEquals(Rank.NINE, card.getRank());
  }

  @Test
  public void canGetFirstCard() {
    SetOfCards populatedSet = new SetOfCards();
    populatedSet.addCard(aceOfHearts);
    populatedSet.addCard(nineOfClubs);
    populatedSet.addCard(tenOfDiamonds);
    populatedSet.addCard(queenOfSpades);
    populatedSet.addCard(threeOfClubs);
    Card card = populatedSet.getFirstCard();
    assertEquals(5, populatedSet.countCards());
    assertEquals(Suit.HEARTS, card.getSuit());
    assertEquals(Rank.ACE, card.getRank());
  }

  @Test
  public void canRemoveFirstCard() {
    SetOfCards populatedSet = new SetOfCards();
    populatedSet.addCard(aceOfHearts);
    populatedSet.addCard(nineOfClubs);
    populatedSet.addCard(tenOfDiamonds);
    populatedSet.addCard(queenOfSpades);
    populatedSet.addCard(threeOfClubs);
    Card card = populatedSet.removeFirstCard();
    assertEquals(4, populatedSet.countCards());
    assertEquals(Suit.HEARTS, card.getSuit());
    assertEquals(Rank.ACE, card.getRank());
  }

}