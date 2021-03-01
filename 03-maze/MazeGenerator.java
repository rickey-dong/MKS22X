import java.util.*;
public class MazeGenerator
{
  private char[][] maze;
  private ArrayList<Integer> moves;
  public MazeGenerator(int rows, int cols)
  {
    maze = new char[rows][cols];
    moves.add(0);
    moves.add(1);
    moves.add(2);
    moves.add(3);
    for (int i = 0; i < maze.length; i++)
    {
      for (int j = 0; i < maze[i].length; j++)
      {
        maze[i][j] = '#';
      }
    }
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
}