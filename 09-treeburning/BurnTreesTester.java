public class BurnTreesTester
{
  public static void main(String[] args)
  {
    int WIDTH = 20;
    int HEIGHT = 20;
    double DENSITY = .7;
    WIDTH = Integer.parseInt(args[0]);
    HEIGHT = Integer.parseInt(args[1]);
    DENSITY = Double.parseDouble(args[2]);
    int times_to_test = 50;
    long total_steps = 0;
    for (int i = 1; i <= times_to_test; i++)
    {
      BurnTrees b = new BurnTrees(WIDTH, HEIGHT, DENSITY);
      total_steps += b.run();
    }
    System.out.println(total_steps/times_to_test);
  }
}