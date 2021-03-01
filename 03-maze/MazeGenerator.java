import java.util.*;
public class MazeGenerator
{
  public static void generate(char[][] maze, int rows, int cols, int startRow, int startCol)
  {
    
  }
  public static int countAdjacency(char[][] maze, int currentRow, int currentCol)
  {
    int count = 0;
    if (maze[currentRow][currentCol+1] == ' ')
    {
      count++;
    }
    if (maze[currentRow][currentCol-1] == ' ')
    {
      count++;
    }
    if (maze[currentRow+1][currentCol] == ' ')
    {
      count++;
    }
    if (maze[currentRow-1][currentCol] == ' ')
    {
      count++;
    }
    return count;
  }
  public static boolean isSafeToCarve(char[][] maze, int currentRow, int currentCol)
  {
    if (currentRow == 0 || currentCol == 0 || currentRow == maze.length-1 || currentCol == maze[0].length-1)
    {
      return false;
    }
    if (countAdjacency(maze, currentRow, currentCol) >= 2)
    {
      return false;
    }
    return true;
  }
  public static String toString(char[][] maze)
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
}