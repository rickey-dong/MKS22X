public class RecursionTester
{
  public static void main(String[] args)
  {
    System.out.println(Recursion.reverse("hello"));
    System.out.println(Recursion.reverse(""));
    System.out.println(Recursion.reverse("h"));
    System.out.println(Recursion.reverse("hi"));
    System.out.println(Recursion.reverse("hey"));
    System.out.println("=========================");
    System.out.println(Recursion.countNoDoubleLetterWords(0,"") + " should be 1");
    System.out.println(Recursion.countNoDoubleLetterWords(1,"") + " should be 26");
    System.out.println(Recursion.countNoDoubleLetterWords(2,"") + " should be 650");
    System.out.println(Recursion.countNoDoubleLetterWords(3,""));
    System.out.println("=========================");
    System.out.println(Recursion.sqrt(1) + " should be 1");
    System.out.println(Recursion.sqrt(0) + " should be 0");
    System.out.println(Recursion.sqrt(2) + " should be 1.4142");
    System.out.println(Recursion.sqrt(4) + " should be 2");
    System.out.println(Recursion.sqrt(9) + " should be 3");
    System.out.println(Recursion.sqrt(16) + " should be 4");
    System.out.println(Recursion.sqrt(36) + " should be 6");
    System.out.println(Recursion.sqrt(12.25) + " should be 3.5");
    System.out.println(Recursion.sqrt(13.37) + " should be 3.656");
    System.out.println(Recursion.sqrt(14.2) + " should be 3.768");
    System.out.println(Recursion.sqrt(2.25) + " should be 1.5");
    System.out.println(Recursion.sqrt(67) + " should be 8.185");
    System.out.println(Recursion.sqrt(2.77778) + " should be 1.666667");
    System.out.println(Recursion.sqrt(20.25) + " should be 4.5");
    System.out.println(Recursion.sqrt(0.43) + " should be 0.6557");
    System.out.println(Recursion.sqrt(0.7) + " should be 0.836");
    
  }
}