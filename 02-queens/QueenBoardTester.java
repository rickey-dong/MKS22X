public class QueenBoardTester
{
  public static void main(String[] args)
  {
    QueenBoard FourByFour = new QueenBoard(4);
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(0,0) + " should be true");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(0,0) + " should be false bc it occupied");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(0,1) + " should be false bc it threatened");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(1,1) + " should be false bc it threatened");
    FourByFour.removeQueen(0,0);
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(0,1) + " should be true");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(2,2) + " should be true");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(3,3) + " should be false");
    System.out.println(FourByFour);
    System.out.println(FourByFour.addQueen(2,2) + " should be false");
    System.out.println(FourByFour);
  }
}