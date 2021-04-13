import java.util.*;
public class Frontier
{
  private Queue<int[]> frontier;
  public Frontier()
  {
    frontier = new ArrayDeque<>();
  }
  public int size()
  {
    return frontier.size();
  }
}