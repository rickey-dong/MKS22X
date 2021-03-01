import java.util.*;
public class MazeGenerator
{
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
      /*Collections.shuffle(moves);
      int move = moves.get(0);
      if (move == 0)
      {
        generate(maze,rows,cols,startRow,startCol+1);
      }
      moves.remove(0);
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
      }*/
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
      //System.out.println(toString(maze));
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
}