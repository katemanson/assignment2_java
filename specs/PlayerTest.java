import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import game.*;

public class PlayerTest {

  Player player; 

  @Before
  public void before() {
    player = new Player("Player", true);
  }

  @Test
  public void canGetName() {
    assertEquals("Player", player.getName());
  }

  @Test
  public void canGetHand() {
    assertEquals(0, player.getHand().countCards());
  }

  @Test
  public void canGetDealerStatus() {
    assertEquals(true, player.getDealerStatus());
  }

  @Test
  public void canSetDealerStatus() {
    player.setDealerStatus(false);
    assertEquals(false, player.getDealerStatus());
  }

}