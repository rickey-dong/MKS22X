import java.util.Arrays;
public class MergeTesterRD
{
  public static void main(String[] args)
  {
    int[] messyArray = {5,7,6,3,2,1,6,7,8,9,19,34,22,5,66,7,7,3,3,22,2,7};
    System.out.println(Arrays.toString(messyArray));
    Merge.mergesort(messyArray);
    System.out.println(Arrays.toString(messyArray));
  }
}