import java.util.*;
import java.io.*;
public class USACO
{
  public int bronze(String filename) throws FileNotFoundException
  {
    File input = new File(filename);
    Scanner inputScan = new Scanner(input);
    String lineOne = inputScan.nextLine();
    Scanner scanThisLine = new Scanner(lineOne);
    int rows = scanThisLine.nextInt();
    int cols = scanThisLine.nextInt();
    int elevation = scanThisLine.nextInt();
    int[][] pasture = new int[rows][cols];
    
    int iter = 0;
    int colFill = 0;
    while (iter < rows)
    {
      colFill = 0;
      String nextLine = inputScan.nextLine();
      scanThisLine = new Scanner(nextLine);
      while (scanThisLine.hasNextInt())
      {
        pasture[iter][colFill] = scanThisLine.nextInt();
        colFill++;
      }
      iter++;
    }
    
    while (inputScan.hasNextLine())
    {
      String instruction = inputScan.nextLine();
      
    }     
  }
}