import java.util.Arrays;
public class MergeTesterRD
{
  public static void main(String[] args)
  {
    int[] messyArray = {4,3,5,1, 7};
    System.out.println(Arrays.toString(messyArray));
    Merge.mergesort(messyArray);
    System.out.println(Arrays.toString(messyArray));
  }
}