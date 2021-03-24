public class CalculatorTesterRD
{
  public static void main(String[] args)
  {
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *") + " should be 30.0");
    System.out.println(Calculator.eval("10 2.0 +") + " should be 12.0");
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -") + " should be 893.0");
    System.out.println(Calculator.eval("1 2 3 4 5 + * - -") + " should be 26.0");
    try
    {
      System.out.println(Calculator.eval("") + " should be error");
    }
    catch(IllegalArgumentException e)
    {
      System.out.println(e);
    }
    System.out.println(Calculator.eval("4 5 7 2 + - *") + " should be -16.0");
    System.out.println(Calculator.eval("3 4 + 2 * 7 /") + " should be 2.0");
    System.out.println(Calculator.eval("-5 7 + 6 2 - *") + " should be 8.0");
    try
    {
      System.out.println(Calculator.eval("4 2 3 5 1 - + * + *") + " should be not enough");
    }
    catch(IllegalArgumentException e)
    {
      System.out.println(e);
    }
    System.out.println(Calculator.eval("4 2 + 3 5 1 - * +") + " should be 18.0");
    try
    {
      System.out.println(Calculator.eval("5 3 7 9 + +") + " should be too many");
    }
    catch(IllegalArgumentException e)
    {
      System.out.println(e);
    }
  }
}