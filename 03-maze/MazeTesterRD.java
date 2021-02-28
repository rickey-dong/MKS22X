import java.io.*;
public class MazeTesterRD
{
  public static void main(String[] args)
  {
    try
    {
      Maze easyMaze = new Maze("data3.dat");
      System.out.println(easyMaze);
      easyMaze.setAnimate(true);
      System.out.println(easyMaze.solve() + " steps");
      System.out.println(easyMaze.toString());
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found");
    }
  }
}