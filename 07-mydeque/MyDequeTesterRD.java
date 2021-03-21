import java.util.NoSuchElementException;
public class MyDequeTesterRD
{
  public static void main(String[] args)
  {
    MyDeque<Integer> numbers = new MyDeque<Integer>(4);
    System.out.println(numbers.size() + " should be 0");
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
    System.out.println(numbers.toString() + " should be {10, 6, 8, 559}"); //[6,10, 559, 8] start = 2 , end = 1
    System.out.println(numbers.size() + " should be 4");
    //System.out.println(numbers.removeFirst() + " should be 10"); //[6, 10 559, 8] start = 2 end = 2 size = 3
    //System.out.println(numbers.removeFirst() + " should be 6"); // start = 2 end = 3 size = 2
    System.out.println(numbers.removeLast() + " should be 559"); // start = 0 end = 2 size = 1
    System.out.println(numbers.removeLast() + " should be 8"); //start = 0 end = 3 size = 0
    System.out.println(numbers.removeLast() + " should be 6");
    System.out.println(numbers.size() + " should be 1");
    System.out.println(numbers.removeLast() + " should be 10");
    try{
      System.out.println(numbers.removeLast());
    }
    catch(NoSuchElementException e) {
      System.out.println(e + " should be an error");
    }
    
    //
    
    System.out.println("==================================================");
    MyDeque<Integer> numbers2 = new MyDeque<Integer>(4);
    numbers2.addFirst(4);
    numbers2.addFirst(5);
    numbers2.addFirst(6);
    numbers2.addFirst(7);
    System.out.println(numbers2.toString());
    
    System.out.println("==================================================");
    
    MyDeque<Integer> testing = new MyDeque<Integer>(5);
    testing.addLast(3);
    testing.addLast(2);
    testing.addLast(1);
    testing.addLast(0);
    testing.addLast(6);
    //{3,2,1,0,6}
    System.out.println(testing.toString());
    System.out.println(testing.getFirst() + " should be 3");
    System.out.println(testing.removeFirst() + " should be 3");
    System.out.println(testing.getFirst() + " should be 2");
    System.out.println(testing.getLast() + " should be 6");
    System.out.println(testing.toString() + " should be {2, 1, 0, 6}");
    System.out.println(testing.removeFirst() + " should be 2");
    System.out.println(testing.removeLast() + " should be 6");
    System.out.println(testing.toString() + " should be {1, 0}");
    
    System.out.println("===============================================");
    
    MyDeque<Integer> negative = new MyDeque<Integer>(-5);
    negative.addFirst(2);
    negative.addLast(5);
    System.out.println(negative.toString() + " should be {2, 5}");
    MyDeque<Integer> zero = new MyDeque<Integer>(0);
    zero.addFirst(2);
    zero.addLast(5);
    System.out.println(zero.toString() + " should be {2, 5}");
  }
}