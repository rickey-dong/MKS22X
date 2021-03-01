public class MazeGeneratorTesterRD
{
  public static void main(String[] args)
  {
    char[][] SixBySix = new char[10][25];
    for (int i = 0; i < SixBySix.length; i++)
    {
      for (int j = 0; j < SixBySix[i].length; j++)
      {
        SixBySix[i][j] = '#';
      }
    }
    MazeGenerator.generate(SixBySix, 6,6, 5, 4);
    System.out.println(toString(SixBySix));
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