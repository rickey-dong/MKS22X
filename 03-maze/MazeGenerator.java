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
}