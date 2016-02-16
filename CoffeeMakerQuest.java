//dmr73
//David Robertson
import java.util.Scanner;
import java.util.LinkedList;

public class CoffeeMakerQuest
{
  LinkedList<Node> bList;
  Boolean coffee=false;
  Boolean cream=false;
  Boolean sugar=false;
  
  int pos=0;
  //create game board
  public CoffeeMakerQuest()
  {
    bList= new LinkedList();
    
    //room1
    String ingredMsg = "There might be something here...\nYou found some creamy cream!\n";
    String ingred="cream";
    String adj= "You see a Small room.";
    String furnish= "It has a Quaint sofa.";
    String directions= "A Magenta door leads North";
    String instruct= "\nINSTRUCTIONS (N,S,L,I,D,H) >\n"; 
    Node room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
    
    //room2
    ingredMsg = "You don't see anything out of the ordinary.\n";
    ingred=null;
    adj= "You see a Funny room.";
    furnish= "It has a Sad record player.";
    directions= "A Beige door leads North.\nA Massive door leads South.";
    room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
    
    //room3
    ingredMsg = "There might be something here...\nYou found some caffeinated coffee!\n";
    ingred="coffee";
    adj= "You see a Refinanced room.";
    furnish= "It has a Tight pizza.";
    directions= "A Dead door leads North.\nA Smart door leads South.";
    room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
    
    //room4
    ingredMsg = "You don't see anything out of the ordinary.\n";
    ingred=null;
    adj= "You see a Dumb room.";
    furnish= "It has a Flat energy drink.";
    directions= "A Vivacious door leads North.\nA Slim door leads South.";
    room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
    
    //room5
    ingredMsg = "You don't see anything out of the ordinary.\n";
    ingred=null;
    adj= "You see a Bloodthirsty room.";
    furnish= "It has a Beautiful bag of money.";
    directions= "A Purple door leads North.\nA Sandy door leads South.";
    room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
    
    //room6
    ingredMsg = "There might be something here...\nYou found some sweet sugar.\n";
    ingred="sugar";
    adj= "You see a Rough room.";
    furnish= "It has a Perfect air hockey table.";
    directions= "A Minimalist door leads South.";
    room= new Node(ingredMsg,ingred,adj,furnish,directions, instruct);
    bList.add(room);
  }
  
  public static void main(String args[])
  {
    String input= "";
    Scanner in= new Scanner(System.in);
    CoffeeMakerQuest game= new CoffeeMakerQuest();
    while(input.toLowerCase() != "exit")
    {
      Node tnode=game.printRoom();
      input= in.nextLine();
      game.checkValid(input, tnode);
      
    }
  }
  
  public Node printRoom()
  {
    Node tnode=bList.get(pos);
    System.out.println(tnode.adjective);
    System.out.println(tnode.furnishing);
    System.out.println(tnode.directions);
    System.out.println(tnode.instructions);
    return tnode;
  }
  
  //check the validity of a command
  public Boolean checkValid(String input, Node tnode)
  {
    input=input.toLowerCase();
    if(input.equals("n"))
    {
      if(pos+1<bList.size())
      {
        pos++;
        return true;
      }
      else
      {
        System.out.println("Cannot go North!\n");
        return false;
      }
    }
    else if(input.equals("s"))
    {
      if(pos-1>=0)
      {
        pos--;
        return true;
      }
      else
      {
        System.out.println("Cannot go South!\n");
        return false;
      }
    }
    else if(input.equals("h"))
    {
      help();
      return true;
    }
    else if(input.equals("i"))
    {
      inventory();
      return true;
    }
    else if(input.equals("l"))
    {
      look(tnode);
      return true;
    }
    else if(input.equals("d"))
    {
      drink();
      return true;
    }
    else
      System.out.println("What?");
      return false;
  }
  
  public void help()
  {
    System.out.println("Press 'N' to go north.");
    System.out.println("Press 'S' to go south.");
    System.out.println("Press 'L' to look for an ingredient in current room.");
    System.out.println("Press 'I' for inventory.");
    System.out.println("Press 'H' for help.");
    System.out.println("Press 'D' to drink ingredients.\n");
  }
  
  public void inventory()
  {
    if (coffee==true)
      System.out.println("You have collected coffee.");
    else
      System.out.println("You have not collected coffee.");
    
    if(sugar==true)
      System.out.println("You have collected sugar.");
    else
      System.out.println("You have not collected sugar.");
    
    if(cream==true)
      System.out.println("You have collected cream.");
    else
      System.out.println("You have not collected cream.\n");
  }
  
  public void look(Node tnode)
  {
    String ingredient=tnode.ingredient;
    System.out.println(tnode.ingredientMsg);
    if(ingredient==null)
      return;
    else if(ingredient.equals("coffee"))
      coffee=true;
    else if(ingredient.equals("cream"))
      cream=true;
    else if(ingredient.equals("sugar"))
      sugar=true;
  }
  
  public void drink()
  {
    if(coffee==true && cream==true && sugar==true)
      System.out.println("You Win!");
    else
      System.out.println("You Lose!");
    System.exit(0);
  }
  
  
  public Node changeRoom(int roomNo)
  {
    pos=roomNo;
    Node tnode = bList.get(pos);
    return tnode;
  }
  
  public Boolean sugar()
  {
    return sugar;
  }
  public Boolean coffee()
  {
    return coffee;
  }
  public Boolean cream()
  {
    return cream;
  }
  
  public void setIngredient(String ingred, Boolean val)
  {
    ingred=ingred.toLowerCase();
    if(ingred.equals("coffee"))
      coffee=val;
    if(ingred.equals("sugar"))
      sugar=val;
    if(ingred.equals("cream"))
      cream=val;
  }
}