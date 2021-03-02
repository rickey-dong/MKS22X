import java.util.*;
public class MazeGenerator
{
  public static void main(String[] args)
  {
    char[][] TwentyBySeventy = new char[20][70];
    for (int i = 0; i < TwentyBySeventy.length; i++)
    {
      for (int j = 0; j < TwentyBySeventy[i].length; j++)
      {
        TwentyBySeventy[i][j] = '#';
      }
    }
    generateAmazing(TwentyBySeventy, TwentyBySeventy.length, TwentyBySeventy[0].length, 10, 35);
    System.out.println(toString(TwentyBySeventy));
  }
  public static void generate(char[][] maze, int rows, int cols, int startRow, int startCol)
  {
    if (isSafeToCarve(maze, startRow, startCol))
    {
      maze[startRow][startCol] = ' ';
      ArrayList<Integer> moves = new ArrayList<Integer>(4);
      moves.add(0); //right
      moves.add(1); //left
      moves.add(2); //up
      moves.add(3); //down
      while (moves.size() != 0)
      {
        Collections.shuffle(moves);
        int move = moves.get(0);
        if (move == 0)
        {
          generate(maze,rows,cols,startRow,startCol+1);
        }
        if (move == 1)
        {
          generate(maze,rows,cols,startRow,startCol-1);
        }
        if (move == 2)
        {
          generate(maze,rows,cols,startRow-1,startCol);
        }
        if (move == 3)
        {
          generate(maze,rows,cols,startRow+1,startCol);
        }
        moves.remove(0);
      }
    }
    else
    {
    }
  }
  public static void generateAmazing(char[][] maze, int rows, int cols, int startRow, int startCol)
  {
    generateAmazing(maze,0,0, startRow,startCol, 0, -1);
  }
  public static void generateAmazing(char[][] maze, int rows, int cols, int startRow, int startCol, int countStraight, int direction)
  {
    if (isSafeToCarve(maze, startRow, startCol))
    {
      maze[startRow][startCol] = ' ';
      ArrayList<Integer> moves = new ArrayList<Integer>(4);
      moves.add(0); //right
      moves.add(1); //left
      moves.add(2); //up
      moves.add(3); //down
      while (moves.size() != 0)
      {
        Collections.shuffle(moves);
        int move = moves.get(0);
        if ((direction == -1 && move == 0) || (direction == 0) )
        {
          while (countStraight < 3)
          {
            generateAmazing(maze,rows,cols,startRow,startCol+1, countStraight+1, 0);
            countStraight++;
          }
        }
        if ((direction == -1 && move == 1) || (direction == 1) )
        {
          while (countStraight < 3)
          {
            generateAmazing(maze,rows,cols,startRow,startCol-1, countStraight+1, 1);
            countStraight++;
          }
        }
        if ((direction == -1 && move == 2) || (direction == 2) )
        {
          while (countStraight < 3)
          {
            generateAmazing(maze,rows,cols,startRow-1,startCol, countStraight+1, 2);
            countStraight++;
          }
        }
        if ((direction == -1 && move == 3) || (direction == 3) )
        {
          while (countStraight < 3)
          {
            generateAmazing(maze,rows,cols,startRow+1,startCol, countStraight+1, 3);
            countStraight++;
          }
        }
        countStraight = 0;
        direction = -1;
        moves.remove(0);
      }
    }
    else
    {
    }
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
    if (maze[currentRow][currentCol] == ' ')
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