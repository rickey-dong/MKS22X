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
    return solve(ROW_OF_START, COL_OF_START, ROW_OF_START, COL_OF_START);
  }
  private int solve(int row, int col, int startRow, int colRow)
  {
    if (animate)
    {
      gotoTop();
      System.out.println(this);
      wait(300);
    }
    // if you're on the E, return the amount of @ signs without changing the E
    //else
    //count = 0
    // if you can go up, change current tile to @ and +1 to count and recurse
    // down
    // left
    // right
    // if couldnt go up/down/left/right, backtrack; put . on current spot, count--
    // going back where you came from which was marked by @ sign
    if (maze[row][col] == 'E')
    {
      maze[startRow][colRow] = '@';
      return 1;
    }
    else
    {
      int count = 0;
      if (maze[row-1][col] == ' '  || maze[row-1][col] == 'E')
      {
        if (maze[row][col] != 'S')
        {
          maze[row][col] = '@';
          count++;
        }
        return count + solve(row-1,col,startRow,colRow);
      }
      if (maze[row+1][col] == ' '  || maze[row+1][col] == 'E')
      {
        if (maze[row][col] != 'S')
        {
          maze[row][col] = '@';
          count++;
        }
        return count + solve(row+1,col,startRow,colRow);
      }
      if (maze[row][col-1] == ' '  || maze[row][col-1] == 'E')
      {
        if (maze[row][col] != 'S')
        {
          maze[row][col] = '@';
          count++;
        }
        return count + solve(row,col-1,startRow,colRow);
      }
      if (maze[row][col+1] == ' ' || maze[row][col+1] == 'E')
      {
        if (maze[row][col] != 'S')
        {
          maze[row][col] = '@';
          count++;
        }
        return count + solve(row,col+1,startRow,colRow);
      }
      maze[row][col] = '.';
      if (maze[row][col-1] == '@')
      {
        return solve(row,col-1,startRow,colRow) - 1;
      }
      else if (maze[row][col+1] == '@')
      {
        return solve(row,col+1,startRow,colRow) - 1;
      }
      else if (maze[row-1][col] == '@')
      {
        return solve(row-1,col,startRow,colRow) - 1;
      }
      else if (maze[row+1][col] == '@')
      {
        return solve(row+1,col,startRow,colRow) - 1;
      }
      return -1;
    }
  }
}


























