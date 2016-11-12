package game;
import java.util.*;

public class Player {

  private String name;
  private Hand hand;
  private boolean dealerStatus;

  public Player(String name, boolean dealerStatus) {
    this.name = name;
    this.hand = new Hand();
    this.dealerStatus = dealerStatus;
  }

  public String getName() {
    return this.name;
  } 

  public Hand getHand() {
    return this.hand;
  }

  public boolean getDealerStatus() {
    return this.dealerStatus;
  }

  public void setDealerStatus(boolean dealerStatus) {
    this.dealerStatus = dealerStatus;
  }

}