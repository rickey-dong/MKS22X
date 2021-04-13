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
  public void add(int[] location)
  {
    frontier.add(location);
  }
  public int[] remove()
  {
    return frontier.remove();
  }
}