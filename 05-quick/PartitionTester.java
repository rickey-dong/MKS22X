import java.util.Arrays;
public class PartitionTester
{
  public static void main(String[] args)
  {
    int[] easyToLookAt = {999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(Preliminary.partition(easyToLookAt, 3, 7));
    System.out.println(Arrays.toString(easyToLookAt));
  }
}