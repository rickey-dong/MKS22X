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
  }
}