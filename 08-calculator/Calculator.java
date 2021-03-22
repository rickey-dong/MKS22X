import java.util.ArrayDeque;
import java.util.Arrays;
public class Calculator
{
  public static double eval(String s)
  {
    double result = 0.0;
    double term = 0.0;
    ArrayDeque<Double> calcStack = new ArrayDeque<Double>();
    String[] operatorsAndOperands = s.split(" ");
    for (String oper : operatorsAndOperands)
    {
      if (isNumeric(oper))
      {
        term = Double.parseDouble(oper);
        calcStack.addLast(term);
      }
      else
      {
        double secondTerm = calcStack.removeLast();
        double firstTerm = calcStack.removeLast();
      }
    }
  }
  public static boolean isNumeric(String str)
  {
    try
    {
      double d = Double.parseDouble(str);
    }
    catch(NumberFormatException e)
    {
      return false;
    }
    return true;
  }
}