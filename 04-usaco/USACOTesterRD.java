import java.io.*;
public class USACOTesterRD
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println(USACO.bronze("bronzeSample.txt") + " should be 342144");
      System.out.println(USACO.silver("silverSample.txt") + " should be 1");
    }
    catch(FileNotFoundException e)
    {
      System.out.println("file not found");
    }
  }
}