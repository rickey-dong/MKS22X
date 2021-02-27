import java.util.*;
import java.io.*;
public class Maze
{
  private char[][] maze;
  private boolean animate;
  private void wait(int millis)
  {
    try 
    {
      Thread.sleep(millis);
    }
    catch(InterruptedException e) 
    {
    }
  }
  public void setAnimate(boolean b)
  {
    animate = b;
  }
  public static void clearTerminal()
  {
    System.out.println("\033[2J");
  }
  public static void gotoTop()
  {
    System.out.println("\033[1;1H");
  }
  private static String colorize(String s)
  {
    s = s.replace("@", "\033[32m\033[49m@\033[0m");
    s = s.replace("#", "\033[37m\033[47m#\033[0m");
    s = s.replace("E", "\033[35m\033[49mE\033[0m");
    return s;
  }
}