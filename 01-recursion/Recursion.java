public class Recursion
{
  public static String reverse(String s)
  {
    if (s.length() <= 1)
    {
      return s;
    }
    else
    {
      return s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
    }
  }
  public static long countNoDoubleLetterWords(int length, String word)
  {
    if (length == 0)
    {
      return 1;
    }
    else
    {
      long count = 0;
      for (char letter = 'a'; letter <= 'z'; letter++)
      {
        if (word.length() == 0 || word.charAt(word.length()-1) != letter)
        {
          count += countNoDoubleLetterWords(length-1, word+letter);
        }
      }
      return count;
    }
  }
  public static double sqrt(double n)
  {
    return sqrt(double n, double guess);
  }
}