import java.util.NoSuchElementException;
public class MyDequeTesterRD
{
  public static void main(String[] args)
  {
    MyDeque<Integer> numbers = new MyDeque<Integer>();
    System.out.println(numbers.toString() + " should be {}");
    try{
      System.out.println(numbers.getFirst());
    }
    catch(NoSuchElementException e) {
      System.out.println(e + " should be an error");
    }
    try{
      System.out.println(numbers.getLast());
    }
    catch(NoSuchElementException e) {
      System.out.println(e + " should be an error");
    }
    try{
      System.out.println(numbers.removeFirst());
    }
    catch(NoSuchElementException e) {
      System.out.println(e + " should be an error");
    }
    try{
      System.out.println(numbers.removeLast());
    }
    catch(NoSuchElementException e) {
      System.out.println(e + " should be an error");
    }
  }
}