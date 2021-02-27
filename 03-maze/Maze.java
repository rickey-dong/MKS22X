import java.util.*;
import java.io.*;
public class Maze
{
  private char[][] maze;
  private boolean animate;
  public Maze(String filename) throws FileNotFoundException
  {
    File mazeFile = new File(filename);
    Scanner mazeScan = new Scanner(mazeFile);
    int height = 1;
    int length = mazeScan.nextLine().length();
    while (mazeScan.hasNextLine())
    {
      height++;
      mazeScan.nextLine();
    }
    maze = new char[height][length];
    Scanner mazeToArray = new Scanner(mazeFile);
    int row = 0;
    while (mazeToArray.hasNextLine())
    {
      String line = mazeToArray.nextLine();
      for (int i = 0; i < line.length(); i++)
      {
        maze[row][i] = line.charAt(i);
      }
      row++;
    }
    animate = false;
  }
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
  public String toString()
  {
    String asciiMaze = "";
    for (int i = 0; i < maze.length; i++)
    {
      for (int j = 0; j < maze[i].length; j++)
      {
        asciiMaze += maze[i][j];
      }
      if (i != maze.length - 1)
      {
        asciiMaze += '\n';
      }
    }
    return asciiMaze;
  }
  public int solve()
  {
    if (animate)
    {
      clearTerminal();
    }
    int ROW_OF_START = 0;
    int COL_OF_START = 0;
    for (int i = 0; i < maze.length; i++)
    {
      for (int j = 0; j < maze[i].length; j++)
      {
        if (maze[i][j] == 'S')
        {
          ROW_OF_START = i;
          COL_OF_START = j;
        }
      }
    }
    return solve(ROW_OF_START, COL_OF_START);
  }
}


























