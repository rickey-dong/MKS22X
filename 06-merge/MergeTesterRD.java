import java.util.Arrays;
public class MergeTesterRD
{
  public static void main(String[] args)
  {
    int[] messyArray = {5,7,2};
    System.out.println(Arrays.toString(messyArray));
    Merge.mergesort(messyArray);
    System.out.println(Arrays.toString(messyArray));
  }
}