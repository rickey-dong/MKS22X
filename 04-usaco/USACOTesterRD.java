import java.io.*;
public class USACOTesterRD
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println(USACO.bronze("bronzeSample.txt") + " should be 102441024");
      System.out.println(USACO.silver("silverSample.txt") + " should be 41409225");
    }
    catch(FileNotFoundException e)
    {
      System.out.println("file not found");
    }
  }
}