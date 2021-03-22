import java.util.ArrayDeque;
import java.util.Arrays;
public class Calculator
{
  public static void eval(String s)
  {
    ArrayDeque<Double> calcStack = new ArrayDeque<Double>();
    String[] operatorsAndOperands = s.split(" ");
    for (String o : operatorsAndOperands)
    {
      System.out.println(o);
    }
    System.out.println(Arrays.toString(operatorsAndOperands));
  }
}