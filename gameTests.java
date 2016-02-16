import static org.junit.Assert.*;

import org.junit.Test;
//gave comp error
//import org.mockito.Mockito;

public class gameTests {
  
//tests to see if the board will let you make only legal moves
  @Test
  public void southTest()
  {
    CoffeeMakerQuest game = new CoffeeMakerQuest();
    Node tnode=game.changeRoom(0);
    //check edge for south
    assertFalse(game.checkValid("s",tnode));
    assertFalse(game.checkValid("S",tnode));
    
    tnode=game.changeRoom(5);
    //check valid for south
    assertTrue(game.checkValid("s",tnode));
    assertTrue(game.checkValid("S",tnode));
  }
  
  @Test
  public void northTest()
  {
    CoffeeMakerQuest game = new CoffeeMakerQuest();
    Node tnode=game.changeRoom(0);
    //check for valid north
    assertTrue(game.checkValid("n",tnode));
    assertTrue(game.checkValid("N",tnode));
    
    //check edge for north
    tnode=game.changeRoom(5);
    //check for valid north
    assertFalse(game.checkValid("n",tnode));
    assertFalse(game.checkValid("N",tnode));
  }
  
  //test validity of other commands
  @Test
  public void validCommands()
  {
    CoffeeMakerQuest game= new CoffeeMakerQuest();
    Node tnode=game.changeRoom(0);
    
    assertTrue(game.checkValid("h",tnode));
    assertTrue(game.checkValid("H",tnode));
    
    assertTrue(game.checkValid("i",tnode));
    assertTrue(game.checkValid("I",tnode));
    
    assertTrue(game.checkValid("l",tnode));
    assertTrue(game.checkValid("L",tnode));
    
    assertTrue(game.checkValid("l",tnode));
    assertTrue(game.checkValid("l",tnode));
    
    assertTrue(game.checkValid("d",tnode));
    assertTrue(game.checkValid("D",tnode));
  }
  
  //test for some invalid commands
  @Test
  public void invalidCommands()
  {
    CoffeeMakerQuest game= new CoffeeMakerQuest();
    Node tnode=game.changeRoom(0);
    
    assertFalse(game.checkValid("o",tnode));
    assertFalse(game.checkValid("rrrdjsodnf",tnode));
    assertFalse(game.checkValid("1",tnode));
    assertFalse(game.checkValid("0599483579",tnode));
    assertFalse(game.checkValid("",tnode));
  }
  
  
}