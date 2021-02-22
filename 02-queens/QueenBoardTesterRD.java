public class QueenBoardTesterRD
{
  public static void main(String[] args)
  {
    /*QueenBoard FourByFour = new QueenBoard(4);
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
    System.out.println(FourByFour);*/
    QueenBoard OneByOne = new QueenBoard(1);
    //System.out.println(OneByOne.solve() + " should be true");
    QueenBoard TwoByTwo = new QueenBoard(2);
  //  System.out.println(TwoByTwo.solve() + " should be false");
    QueenBoard ThreeByThree = new QueenBoard(3);
//    System.out.println(ThreeByThree.solve() + " should be false");
    QueenBoard FourByFour = new QueenBoard(4);
  //  System.out.println(FourByFour.solve() + " should be true");
  //  try{System.out.println(FourByFour.solve() + " should be error because you already solved");}
//    catch(IllegalStateException e)
  //  {
  //    System.out.println(e);
  //  }
  //  System.out.println(TwoByTwo); //should be filled with zeros
  //  System.out.println(ThreeByThree); //should be filled with zeros
  //  System.out.println(OneByOne); //solved state
  //  System.out.println(FourByFour); //solved state
    QueenBoard ThirtByThirt = new QueenBoard(13);
    //System.out.println(ThirtByThirt.solve());
    //System.out.println(ThirtByThirt);
    System.out.println(OneByOne.countSolutions() + " should be 1");
    System.out.println(TwoByTwo.countSolutions() + " should be 0");
    System.out.println(ThreeByThree.countSolutions() + " should be 0");
    System.out.println(FourByFour.countSolutions());
    System.out.println(ThirtByThirt.countSolutions());
  }
}