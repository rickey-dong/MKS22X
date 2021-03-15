import java.util.Random;
import java.util.Arrays;
public class QuickTesterRD
{
  public static void main(String[] args)
  {
    Random r = new Random();
    int[] ary  = new int[1000000];
    for (int i = 0; i < ary.length; i++)
    {
      ary[i] = r.nextInt(600);
    }
    int[] copy = new int[1000000];
    for (int i = 0; i < copy.length; i++)
    {
      copy[i] = ary[i];
    }
    Arrays.sort(copy);
    System.out.println(copy[500000]);
    System.out.println(Quick.quickselect(ary, 500000));
    int[] ary2 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary2, 0) + " should be 0");
    int[] ary3 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary3, 1) + " should be 2");    
    int[] ary4 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary4, 2) + " should be 5");
    int[] ary5 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary5, 3) + " should be 10");
    int[] ary6 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary6, 4) + " should be 15");
    int[] ary7 = {2, 10, 15, 23, 0,  5};
    System.out.println(Quick.quickselect(ary7, 5) + " should be 23");
  }
}