import java.util.Random;
public class Preliminary
{
  public static int partition(int[] data, int start, int end)
  {
    //randomly choose a pivot within start to end inclusive
    //swap that with the front of the subarray
    //going forward at current, where current = start+1, loop through the rest of the
    //elements in the subarray while also having a pointer at the end
    //if element is less than pivot, don't do anything and current moves right
    //if it's greater than p, swap with the element at end pointer, end pointer moving left
    //if equal to p, just flip a coin to decide if it goes left or right
    //at the very last element, if it's greater than p, p gets inserted right before it/swapped
    //if it's smaller than p, it gets swapper w/ p.
    //return current index of p;
    int pivotIndex = (int) (Math.random() * ( (end+1) - start + 1) + start); //index of the pivot
    System.out.println(pivotIndex);
    int pivot = data[pivotIndex]; //actual pivot
    System.out.println(pivot);                       //DELETE DELETE DELETE
    int swap = data[pivotIndex];
    data[pivotIndex] = data[start];
    data[start] = swap;
    pivot = data[start]; //now pivot is at the beginning of the array, we don't care about pivotIndex any more
    int current = start+1;
    while (current != end)
    {
      if (data[current] < pivot)
      {
        current++;
      }
      else if (data[current] > pivot)
      {
        swap = data[end];
        data[end] = data[current];
        data[current] = swap;
        end--;
      }
      else
      {
        Random r = new Random();
        if (r.nextBoolean())
        {
          current++;
        }
        else
        {
          swap = data[end];
          data[end] = data[current];
          data[current] = swap;
          end--;
        }
      }
    }
    if (data[current] > pivot)
    {
      swap = data[start];
      data[start] = data[current-1];
      data[current-1] = swap;
      current--;
    }
    else
    {
      swap = data[start];
      data[start] = data[current];
      data[current] = swap;
    }
    return current;
  }
}