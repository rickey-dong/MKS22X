import java.util.Arrays;
public class PartitionTester
{
  public static void main(String[] args)
  {
    int[] easyToLookAt = {1, 3, 5, 2, 7, 4};
    int i = 0;
    System.out.println(Preliminary.partition(easyToLookAt, 4, 5) + " is the index of the pivot");
    System.out.println(Arrays.toString(easyToLookAt));
    //indices used:     3 ,     4,  5,6 ,7
  }
}