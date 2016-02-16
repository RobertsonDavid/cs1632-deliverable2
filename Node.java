public class Node
{
  public String ingredientMsg;
  public String ingredient;
  public String adjective;
  public String furnishing;
  public String directions;
  public String instructions;
  //level creation as node
  public Node(String ingredMsg, String ingred, String adj, String furnish, String directionsAvailable, String instruct)
  {
    ingredientMsg= ingredMsg;
    ingredient=ingred;
    adjective= adj;
    furnishing=furnish;
    directions= directionsAvailable;
    instructions= instruct;
    
  }
}