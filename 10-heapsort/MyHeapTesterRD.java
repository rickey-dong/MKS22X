import java.util.Arrays;
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
  } 
}