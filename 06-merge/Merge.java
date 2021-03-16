import java.util.Arrays;
public class Merge
{
  public static void mergesort(int[] data)
  {
    mergesort(data, 0, data.length-1); //sort the whole array
  }
  public static void mergesort(int[] data, int lo, int hi)
  {
    if (lo < hi)
    {
      mergesort(data, lo, (lo+hi)/2); //sort the left side
      mergesort(data, ((lo+hi)/2)+1, hi); //sort the right side
      merge(data, lo, (lo+hi)/2, ((lo+hi)/2+1), hi); //combine the left and right side
    }
  }
  public static void merge(int[] data, int group0Low, int group0High, int group1Low, int group1High)
  {
    int[] thirdPile = new int[group1High-group0Low + 1]; //third pile to put all of the numbers in order
    int iter = 0;
    int a_low = group0Low;
    int a_high = group0High;
    int b_low = group1Low;
    int b_high = group1High;
    while (group0Low <= group0High && group1Low <= group1High) //transferring all numbers to 3rd pile in order
    {
      if (data[group0Low] < data[group1Low])
      {
        thirdPile[iter] = data[group0Low];
        iter++;
        group0Low++;
      }
      else
      {
        thirdPile[iter] = data[group1Low];
        iter++;
        group1Low++;
      }
    }
    while (group0Low <= group0High) //if there's any leftovers, add them
    {
      thirdPile[iter] = data[group0Low];
      iter++;
      group0Low++;
    }
    while (group1Low <= group1High) //if there's any leftovers, add them
    {
      thirdPile[iter] = data[group1Low];
      iter++;
      group1Low++;
    }
    int iter0 = 0;
    while (a_low <= a_high) //transferring from third pile to actual data array
    {
      data[a_low] = thirdPile[iter0];
      iter0++;
      a_low++;
    }
    while (b_low <= b_high) //transferring from third pile to actual data array
    {
      data[b_low] = thirdPile[iter0];
      iter0++;
      b_low++;
    }
  }
}