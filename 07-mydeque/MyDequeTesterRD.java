import java.util.NoSuchElementException;
import java.util.ArrayDeque;
public class MyDequeTesterRD
{
  public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
  if(a==null && b==null)
    return true;
  if(a==null || b==null)
      return false;
  if(a.size()!=b.size())
    return false;
  if(a.size()==0 && b.size()==0)
    return true;

  try{
    while(b.size()>0){
      if(!a.removeFirst().equals(b.removeFirst())){
        return false;
      }
    }
  }catch(NoSuchElementException e){
    return false;
  }
  return b.size()==0;
}

public static int test6(int max){
  MyDeque<Integer> a = new MyDeque<Integer>();
  ArrayDeque<Integer>b = new ArrayDeque<Integer>();

  for(int i = 0; i < max; i++){
    System.out.println(a.toString() + " is MyDeque");
    System.out.println(a.size() + " is the size");
    System.out.println(b.toString() + " is the correct deque");
    int op = (int)(Math.random()*4);
    System.out.println(op + " is the op");
    if(op == 0){
      a.addLast(i);
      b.addLast(i);
    }
    if(op == 1){
      a.addFirst(i);
      b.addFirst(i);
    }
    if(op == 2){
      if(b.size()>0){
        if(! a.getLast().equals(b.getLast())){
          System.out.println("Fail test6a "+a.getLast()+" vs "+b.getLast());
          return 0;
        }
        a.removeLast();
        b.removeLast();
      }
    }
    if(op == 3){
      if(b.size()>0){
        if(! a.getFirst().equals(b.getFirst())){
          System.out.println("Fail test6b "+a.getFirst()+" vs "+b.getFirst());
          return 0;
        }
        a.removeFirst();
        b.removeFirst();
      }
    }
    System.out.println(a.getStart() + " is the start index");
    System.out.println(a.getEnd() + " is the end index");
    System.out.println("================================");
  }
  if( equals(a,b) ){
    return 1;
  }
  System.out.println("Fail test6 end");
  return 0;
}
  public static void main(String[] args)
  {
    System.out.println(test6(500000));
  //   MyDeque<Integer> numbers = new MyDeque<Integer>(4);
  //   System.out.println(numbers.size() + " should be 0");
  //   System.out.println(numbers.toString() + " should be {}");
  //   try{
  //     System.out.println(numbers.getFirst());
  //   }
  //   catch(NoSuchElementException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   try{
  //     System.out.println(numbers.getLast());
  //   }
  //   catch(NoSuchElementException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   try{
  //     System.out.println(numbers.removeFirst());
  //   }
  //   catch(NoSuchElementException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   try{
  //     System.out.println(numbers.removeLast());
  //   }
  //   catch(NoSuchElementException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   try{
  //     numbers.addFirst(null);
  //   }
  //   catch(NullPointerException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   try{
  //     numbers.addLast(null);
  //   }
  //   catch(NullPointerException e) {
  //     System.out.println(e + " should be an error");
  //   }
  //   numbers.addFirst(6);
  //   System.out.println(numbers.toString() + " should be {6}");
  //   numbers.addLast(8);
  //   System.out.println(numbers.toString() + " should be {6, 8}");
  //   System.out.println(numbers.getFirst() + " should be 6");
  //   System.out.println(numbers.getLast() + " should be 8");
  //   numbers.addFirst(10);
  //   System.out.println(numbers.getFirst() + " should be 10");
  //   numbers.addLast(559);
  //   System.out.println(numbers.getLast() + " should be 559");
  //   System.out.println(numbers.toString() + " should be {10, 6, 8, 559}"); //[6,10, 559, 8] start = 2 , end = 1
  //   System.out.println(numbers.size() + " should be 4");
  //   //System.out.println(numbers.removeFirst() + " should be 10"); //[6, 10 559, 8] start = 2 end = 2 size = 3
  //   //System.out.println(numbers.removeFirst() + " should be 6"); // start = 2 end = 3 size = 2
  //   System.out.println(numbers.removeLast() + " should be 559"); // start = 0 end = 2 size = 1
  //   System.out.println(numbers.removeLast() + " should be 8"); //start = 0 end = 3 size = 0
  //   System.out.println(numbers.removeLast() + " should be 6");
  //   System.out.println(numbers.size() + " should be 1");
  //   System.out.println(numbers.removeLast() + " should be 10");
  //   try{
  //     System.out.println(numbers.removeLast());
  //   }
  //   catch(NoSuchElementException e) {
  //     System.out.println(e + " should be an error");
  //   }
  // 
  //   //
  // 
  //   System.out.println("==================================================");
  //   MyDeque<Integer> numbers2 = new MyDeque<Integer>(4);
  //   numbers2.addFirst(4);
  //   numbers2.addFirst(5);
  //   numbers2.addFirst(6);
  //   numbers2.addFirst(7);
  //   System.out.println(numbers2.toString());
  // 
  //   System.out.println("==================================================");
  // 
  //   MyDeque<Integer> testing = new MyDeque<Integer>(5);
  //   testing.addLast(3);
  //   testing.addLast(2);
  //   testing.addLast(1);
  //   testing.addLast(0);
  //   testing.addLast(6);
  //   //{3,2,1,0,6}
  //   System.out.println(testing.toString());
  //   System.out.println(testing.getFirst() + " should be 3");
  //   System.out.println(testing.removeFirst() + " should be 3");
  //   System.out.println(testing.getFirst() + " should be 2");
  //   System.out.println(testing.getLast() + " should be 6");
  //   System.out.println(testing.toString() + " should be {2, 1, 0, 6}");
  //   System.out.println(testing.removeFirst() + " should be 2");
  //   System.out.println(testing.removeLast() + " should be 6");
  //   System.out.println(testing.toString() + " should be {1, 0}");
  // 
  //   System.out.println("===============================================");
  // 
  //   MyDeque<Integer> negative = new MyDeque<Integer>(-5);
  //   negative.addFirst(2);
  //   negative.addLast(5);
  //   System.out.println(negative.toString() + " should be {2, 5}");
  //   MyDeque<Integer> zero = new MyDeque<Integer>(0);
  //   zero.addFirst(2);
  //   zero.addLast(5);
  //   System.out.println(zero.toString() + " should be {2, 5}");
  }
}