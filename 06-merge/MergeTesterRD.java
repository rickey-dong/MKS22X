import java.util.Arrays;
import java.util.Random;
public class MergeTesterRD
{
  public static void main(String[] args)
  {
    Random r = new Random();
    int[] sorted = new int[1000000];
    for (int i = 0; i < sorted.length; i++)
    {
      sorted[i] = i;
    }
    Merge.mergesort(sorted);
    System.out.println(isSorted(sorted));
    System.out.println("--------------------------------------------");
    int[] reverseSorted = new int[1000000];
    for (int i = 0; i < reverseSorted.length; i++)
    {
      reverseSorted[i] = reverseSorted.length - i;
    }
    Merge.mergesort(reverseSorted);
    System.out.println(isSorted(sorted));
    System.out.println("--------------------------------------------");
    int[] oneValue = new int[1000000];
    for (int i = 0; i < oneValue.length; i++)
    {
      oneValue[i] = 66;
    }
    Merge.mergesort(oneValue);
    System.out.println(isSorted(oneValue));
    System.out.println("--------------------------------------------");
    int[] randomArray = new int[1000000];
    for (int i = 0; i < randomArray.length; i++)
    {
      randomArray[i] = r.nextInt(100);
    }
    Merge.mergesort(randomArray);
    System.out.println(isSorted(randomArray));
    System.out.println("--------------------------------------------");
    int[] binaryArray = new int[1000000];
    for (int i = 0; i < binaryArray.length; i++)
    {
      if (i % 2 == 0)
      {
        binaryArray[i] = 0;
      }
      else
      {
        binaryArray[i] = 1;
      }
    }
    Merge.mergesort(binaryArray);
    System.out.println(isSorted(binaryArray));
  }
  public static boolean isSorted(int[] data)
  {
    for (int i = 1; i < data.length; i++)
    {
      if (data[i-1] > data[i])
      {
        return false;
      }
    }
    return true;
  }
}