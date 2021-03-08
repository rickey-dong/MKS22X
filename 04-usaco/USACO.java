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
    oldPasture[startRow][startCol] = 1; // one cow that starts on start
    int[][] newPasture = new int[rows][cols];
    while (time > 0)
    {
      updateNewField(newPasture, oldPasture);
      updateOldField(newPasture, oldPasture);
      time--;
    }
    return newPasture[endRow][endCol];
  }
  public static void updateNewField(int[][] newField, int[][] oldField)
  {
    for (int i = 0; i < newField.length; i++)
    {
      for (int j = 0; j < newField[i].length; j++)
      {
        if (!isTree(i,j,oldField))
        {
          if (!onBorder(i,j,newField.length,newField[i].length))
          {
            newField[i][j] = (oldField[i][j+1] + oldField[i][j-1] + oldField[i+1][j] + oldField[i-1][j]);
            if (oldField[i][j+1] == -1)
            {
              newField[i][j] += 1;
            }
            if (oldField[i][j-1] == -1)
            {
              newField[i][j] += 1;
            }
            if (oldField[i+1][j] == -1)
            {
              newField[i][j] += 1;
            }
            if (oldField[i-1][j] == -1)
            {
              newField[i][j] += 1;
            }
          }
          else
          {
            //top left = add right and down
            if (i == 0 && j == 0)
            {
              newField[i][j] = (oldField[i][j+1] + oldField[i+1][j]);
              if (oldField[i][j+1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i+1][j] == -1)
              {
                newField[i][j] += 1;
              }
            }
            //bottom left = add right and up
            else if (i == newField.length - 1 && j == 0)
            {
              newField[i][j] = (oldField[i][j+1] + oldField[i-1][j]);
              if (oldField[i][j+1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i-1][j] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // left = add right down up
            else if (j == 0)
            {
              newField[i][j] = (oldField[i][j+1] + oldField[i+1][j] + oldField[i-1][j]);
              if (oldField[i][j+1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i+1][j] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i-1][j] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // top right = add left and down
            else if (i == 0 && j == newField[i].length - 1)
            {
              newField[i][j] = (oldField[i][j-1] + oldField[i+1][j]);
              if (oldField[i][j-1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i+1][j] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // top = add left down right
            else if (i == 0)
            {
              newField[i][j] = (oldField[i][j-1] + oldField[i+1][j] + oldField[i][j+1]);
              if (oldField[i][j-1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i+1][j] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i][j+1] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // bottom right = add up and left 
            else if (i == newField.length - 1 && j == newField[i].length - 1)
            {
              newField[i][j] = (oldField[i-1][j] + oldField[i][j-1]);
              if (oldField[i-1][j] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i][j-1] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // bottom = add up left right
            else if (i == newField.length - 1)
            {
              newField[i][j] = (oldField[i-1][j] + oldField[i][j-1] + oldField[i][j+1]);
              if (oldField[i-1][j] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i][j-1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i][j+1] == -1)
              {
                newField[i][j] += 1;
              }
            }
            // right = add left up down
            else if (j == newField[i].length - 1)
            {
              newField[i][j] = (oldField[i][j-1] + oldField[i-1][j] + oldField[i+1][j]);
              if (oldField[i][j-1] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i-1][j] == -1)
              {
                newField[i][j] += 1;
              }
              if (oldField[i+1][j] == -1)
              {
                newField[i][j] += 1;
              }
            }
          }
        }
        else
        {
          newField[i][j] = -1;
        }
      }
    }
  }
  public static boolean isTree(int row, int col, int[][] pasture)
  {
    return pasture[row][col] == -1;
  }
  public static boolean onBorder(int row, int col, int rows, int cols)
  {
    return row == 0 || row == rows - 1 || col == 0 || col == cols - 1;
  }
  public static void updateOldField(int[][] newField, int[][] oldField)
  {
    for (int i = 0; i < oldField.length; i++)
    {
      for (int j = 0; j < oldField[i].length; j++)
      {
        oldField[i][j] = newField[i][j];
      }
    }
  }
  public static String toString(int[][] pasture)
  {
    String stringRepresentation = "";
    for (int i = 0; i < pasture.length; i++)
    {
      for (int j = 0; j < pasture[i].length; j++)
      {
        stringRepresentation += pasture[i][j];
        if (j != pasture[i].length - 1)
        {
          stringRepresentation += ", ";
        }
      }
      stringRepresentation += '\n';
    }
    return stringRepresentation;
  }
}