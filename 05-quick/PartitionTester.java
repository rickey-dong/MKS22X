import java.util.Arrays;
public class PartitionTester
{
  public static void main(String[] args)
  {
    int[] easyToLookAt = {999,999,999,4,3,2,1,0,999,999,999};
    int i = 0;
    System.out.println(Preliminary.partition(easyToLookAt, 3, 7) + " is the index of the pivot");
    System.out.println(Arrays.toString(easyToLookAt));
    //indices used:     3 ,     4,  5,6 ,7
  }
}