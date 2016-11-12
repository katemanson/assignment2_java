import org.junit.*;
import static org.junit.Assert.*;
import game.*;

public class CardTest {
     Card queenOfHearts;

     @Before
     public void before(){
          queenOfHearts = new Card(Suit.HEARTS, Rank.QUEEN);
     }

     @Test
     public void canGetSuit(){
          assertEquals(Suit.HEARTS, queenOfHearts.getSuit());
     }

     @Test
     public void canGetRank(){
          assertEquals(Rank.QUEEN, queenOfHearts.getRank());
     }
}