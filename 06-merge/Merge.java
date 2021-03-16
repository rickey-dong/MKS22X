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
    }
  }
}