import java.util.Arrays;
import java.util.Random;
public class MyHeapTesterRD
{
  public static void main(String[] args)
  {
    int[] testA = {4, 2, 8};
    /*
        4               8
      2   8    ->    2     4 
    */
    MyHeap.pushDown(testA, 3, 0);
    System.out.println(Arrays.toString(testA) + " should be [8, 2, 4]");
    MyHeap.pushDown(testA, 3, 0);
    System.out.println(Arrays.toString(testA) + " should be [8, 2, 4]");
    MyHeap.pushDown(testA, 3, 1);
    System.out.println(Arrays.toString(testA) + " should be [8, 2, 4]");
    MyHeap.pushDown(testA, 3, 2);
    System.out.println(Arrays.toString(testA) + " should be [8, 2, 4]");
    
    int[] testB = {40, 20, 60, 5, 25};
    /*
          40
        20  60
      5   25
    */
    MyHeap.pushDown(testB, 5, 0);
    System.out.println(Arrays.toString(testB) + " should be [60, 20, 40, 5, 25]");
    MyHeap.pushDown(testB, 5, 1);
    System.out.println(Arrays.toString(testB) + " should be [60, 25, 40, 5, 20]");
    
    int[] testC = {40, 60, 50, 30, 80};
    /*
          40            60
        60 50   ->    80  50  
      30 80         30  40
    */
    MyHeap.pushDown(testC, 5, 0);
    System.out.println(Arrays.toString(testC) + " should be [60, 80, 50, 30, 40]");
    MyHeap.pushDown(testC, 5, 0);
    System.out.println(Arrays.toString(testC) + " should be [80, 60, 50, 30, 40]");
    
    int[] testD = {1, 3, 6, 5, 9};
    /*
          1
        3   6
      5 9  
    */
    MyHeap.buildHeap(testD);
    /*
          9
        5   6
      1 3
    */
    System.out.println(Arrays.toString(testD) + " should be [9, 5, 6, 1, 3]");
    System.out.println("=====================================================");
    
    int[] test0 = {};
    int[] test1 = {1};
    int[] test2 = {1, 3};
    int[] test2p5 = {3, 1};
    int[] test3 = {1, 3, 6};
    int[] test3p5 = {6, 3, 1};
    int[] test3p6 = {1, 6, 3};
    int[] test3p7 = {6, 1, 3};
    int[] test3p8 = {3, 1, 6};
    int[] test3p9 = {3, 6, 1};
    MyHeap.heapsort(test0);
    MyHeap.heapsort(test1);
    MyHeap.heapsort(test2);
    MyHeap.heapsort(test2p5);
    MyHeap.heapsort(test3);
    MyHeap.heapsort(test3p5);
    MyHeap.heapsort(test3p6);
    MyHeap.heapsort(test3p7);
    MyHeap.heapsort(test3p8);
    MyHeap.heapsort(test3p9);
    System.out.println(isSorted(test0));
    System.out.println(isSorted(test1));
    System.out.println(isSorted(test2));
    System.out.println(isSorted(test2p5));
    System.out.println(isSorted(test3));
    System.out.println(isSorted(test3p5));
    System.out.println(isSorted(test3p6));
    System.out.println(isSorted(test3p7));
    System.out.println(isSorted(test3p8));
    System.out.println(isSorted(test3p9));
    Random r = new Random();
    int[] sorted = new int[1000000];
    for (int i = 0; i < sorted.length; i++)
    {
      sorted[i] = i;
    }
    MyHeap.heapsort(sorted);
    System.out.println(isSorted(sorted));
    System.out.println("--------------------------------------------");
    int[] reverseSorted = new int[1000000];
    for (int i = 0; i < reverseSorted.length; i++)
    {
      reverseSorted[i] = reverseSorted.length - i;
    }
    MyHeap.heapsort(reverseSorted);
    System.out.println(isSorted(sorted));
    System.out.println("--------------------------------------------");
    int[] oneValue = new int[1000000];
    for (int i = 0; i < oneValue.length; i++)
    {
      oneValue[i] = 66;
    }
    MyHeap.heapsort(oneValue);
    System.out.println(isSorted(oneValue));
    System.out.println("--------------------------------------------");
    int[] randomArray = new int[1000000];
    for (int i = 0; i < randomArray.length; i++)
    {
      randomArray[i] = r.nextInt(100);
    }
    MyHeap.heapsort(randomArray);
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
    MyHeap.heapsort(binaryArray);
    System.out.println(isSorted(binaryArray));
  }
  private static boolean isSorted(int[] data)
  {
    for (int i = 1; i < data.length; i++)
    {
      if (data[i] < data[i-1])
      {
        return false;
      }
    }
    return true;
  }
}