public class QueenBoard
{
  private int[][] board;
  public QueenBoard(int size)
  {
    board = new int[size][size];
    for (int row = 0; row < size; row++)
    {
      for (int col = 0; col < size; col++)
      {
        board[row][col] = 0;
      }
    }
  }
  private boolean addQueen(int row, int col)              // abc
  {                                                       // def          row 0 is abc, col 0 is ad
    
  }
}