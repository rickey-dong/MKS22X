import java.util.Random;
public class Quick
{
  public static int partition(int[] data, int lo, int hi)
  {
    if (lo == hi)
    {
      return lo;
    }
    Random r = new Random();
    int pivotIndex = r.nextInt((hi-lo) + 1) + lo;
    int swap = data[pivotIndex];
    data[pivotIndex] = data[lo];
    data[lo] = swap;
    int pivot = data[lo];
    int current = lo+1;
    while (current < hi)
    {
      if (data[current] < pivot)
      {
        current++;
      }
      else if (data[current] > pivot)
      {
        swap = data[hi];
        data[hi] = data[current];
        data[current] = swap;
        hi--;
      }
      else
      {
        if (r.nextBoolean())
        {
          current++;
        }
        else
        {
          swap = data[hi];
          data[hi] = data[current];
          data[current] = swap;
          hi--;
        }
      }
    }
    if (data[current] > pivot)
    {
      swap = pivot;
      data[lo] = data[current-1];
      data[current-1] = swap;
      current--;
    }
    else
    {
      swap = pivot;
      data[lo] = data[current];
      data[current] = swap;
    }
    return current;
  }
  public static int quickselect(int[] data, int k)
  {
    int start = 0;
    int end = data.length - 1;
    int potentiallyCorrectIndex = partition(data, start, end);
    while (potentiallyCorrectIndex != k)
    {
      if (potentiallyCorrectIndex < k)
      {
        start = potentiallyCorrectIndex+1;
        potentiallyCorrectIndex = partition(data, start, end);
      }
      else
      {
        end = potentiallyCorrectIndex-1;
        potentiallyCorrectIndex = partition(data, start, end);
      }
    }
    return data[k];
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}