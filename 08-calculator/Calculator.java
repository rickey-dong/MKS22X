import java.util.ArrayDeque;
public class Calculator
{
  public static double eval(String s)
  {
    if (s.length() == 0)
    {
      throw new IllegalArgumentException("string is empty.");
    }
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
        if (calcStack.size() <= 1)
        {
          throw new IllegalArgumentException(s + " has too few operands.");
        }
        double secondTerm = calcStack.removeLast();
        double firstTerm = calcStack.removeLast();
        if (oper.equals("+"))
        {
          calcStack.addLast(firstTerm + secondTerm);
        }
        else if (oper.equals("-"))
        {
          calcStack.addLast(firstTerm - secondTerm);
        }
        else if (oper.equals("/"))
        {
          calcStack.addLast(firstTerm / secondTerm);
        }
        else if (oper.equals("*"))
        {
          calcStack.addLast(firstTerm * secondTerm);
        }
        else
        {
          calcStack.addLast(firstTerm % secondTerm);
        }
      }
    }
    if (calcStack.size() > 1)
    {
      throw new IllegalArgumentException(s + " has too many operands.");
    }
    result = calcStack.removeLast();
    return result;
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