import java.util.NoSuchElementException;
public class MyDequeTesterRD
{
  public static void main(String[] args)
  {
    MyDeque<Integer> numbers = new MyDeque<Integer>(4);
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
    try{
      numbers.addFirst(null);
    }
    catch(NullPointerException e) {
      System.out.println(e + " should be an error");
    }
    try{
      numbers.addLast(null);
    }
    catch(NullPointerException e) {
      System.out.println(e + " should be an error");
    }
    numbers.addFirst(6);
    System.out.println(numbers.toString() + " should be {6}");
    numbers.addLast(8);
    System.out.println(numbers.toString() + " should be {6, 8}");
    System.out.println(numbers.getFirst() + " should be 6");
    System.out.println(numbers.getLast() + " should be 8");
    numbers.addFirst(10);
    System.out.println(numbers.getFirst() + " should be 10");
    numbers.addLast(559);
    System.out.println(numbers.getLast() + " should be 559");
    System.out.println(numbers.toString() + " should be {10, 6, 8, 559}");
  }
}