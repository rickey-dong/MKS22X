import java.util.*;
import java.io.*;
public class USACO
{
  public static int bronze(String filename) throws FileNotFoundException
  {
    /*4 6 22 2
      28 25 20 32 34 36
      27 25 20 20 30 34
      24 20 20 20 20 30
      20 20 14 14 20 20
      1 4 4
      1 1 10*/
    File input = new File(filename);                    
    Scanner inputScan = new Scanner(input);
    String lineOne = inputScan.nextLine(); // 4 6 22 2
    Scanner scanThisLine = new Scanner(lineOne);
    int rows = scanThisLine.nextInt(); //4
    int cols = scanThisLine.nextInt(); //6
    int elevation = scanThisLine.nextInt(); //22
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
      scanThisLine = new Scanner(instruction);
      int topLeftRow = scanThisLine.nextInt() - 1;
      int topLeftCol = scanThisLine.nextInt() - 1;
      int stomp = scanThisLine.nextInt();
      int highestNew = 0;
      int iterRow = topLeftRow;
      int iterCol = topLeftCol;
      while (iterRow < topLeftRow + 3)
      {
        iterCol = topLeftCol;
        while (iterCol < topLeftCol + 3)
        {
          if (highestNew < pasture[iterRow][iterCol] - stomp) //finding the highest new elevation after the stomping
          {
            highestNew = pasture[iterRow][iterCol] - stomp;
          }
          iterCol++;
        }
        iterRow++;
      }
      iterRow = topLeftRow;
      while (iterRow < topLeftRow + 3)
      {
        iterCol = topLeftCol;
        while (iterCol < topLeftCol + 3)
        {
          if (pasture[iterRow][iterCol] > highestNew) //doing the actual stomping
          {
            pasture[iterRow][iterCol] = highestNew;
          }
          iterCol++;
        }
        iterRow++;
      }
    }
    int depths = 0;
    for (int i = 0; i < pasture.length; i++)
    {
      for (int j = 0; j < pasture[i].length; j++)
      {
        if (pasture[i][j] < elevation) //calculate the depths
        {
          depths += (elevation - pasture[i][j]);
        }
      }
    }
    return depths * 72 * 72; //multiply to find cubic inches
  }
  public static long silver(String filename) throws FileNotFoundException
  {
    File input = new File(filename);
    Scanner inputScan = new Scanner(input);
    
    String line = inputScan.nextLine();
    Scanner scanThisLine = new Scanner(line);
    int rows = scanThisLine.nextInt();
    int cols = scanThisLine.nextInt();
    int time = scanThisLine.nextInt();
    
    int[][] oldPasture = new int[rows][cols];
    int iter = 0;
    int colFill = 0;
    while (iter < rows)
    {
      colFill = 0;
      line = inputScan.nextLine();
      while (colFill < line.length())
      {
        if (line.charAt(colFill) == '*') // if tree, mark as -1, otherwise default 0
        {
          oldPasture[iter][colFill] = -1;
        }
        colFill++;
      }
      iter++;
    }
    line = inputScan.nextLine();
    scanThisLine = new Scanner(line);
    int startRow = scanThisLine.nextInt() - 1;
    int startCol = scanThisLine.nextInt() - 1;
    int endRow = scanThisLine.nextInt() - 1;
    int endCol = scanThisLine.nextInt() - 1;
    return 0;
  }
}




























