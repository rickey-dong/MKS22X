import java.util.Arrays;
public class Merge
{
  public static void mergesort(int[] data)
  {
    mergesort(data, 0, data.length-1);
  }
  public static void mergesort(int[] data, int lo, int hi)
  {
    if (lo < hi)
    {
      mergesort(data, lo, (lo+hi)/2);
      mergesort(data, ((lo+hi)/2)+1, hi);
      merge(data, lo, (lo+hi)/2, ((lo+hi)/2+1), hi);
      System.out.println(Arrays.toString(data));
    }
  }
  public static void merge(int[] data, int group0Low, int group0High, int group1Low, int group1High)
  {
    int[] thirdPile = new int[group1High+1];
    int iter = 0;
    while (group0Low <= group0High && group1Low <= group1High)
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
    while (group0Low <= group0High)
    {
      thirdPile[iter] = data[group0Low];
      iter++;
      group0Low++;
    }
    while (group1Low <= group1High)
    {
      thirdPile[iter] = data[group1Low];
      iter++;
      group1Low++;
    }
    for (int i = 0; i < iter; i++)
    {
      data[i] = thirdPile[i];
    }
  }
}