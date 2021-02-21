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
    if (board[row][col] == 0)                  // if the spot we want to add queen is clean, we can add
    {
      board[row][col] = -1;                    // queen is represented by -1
      return true;
    }
    else                     // if it's already occupied or threatened
    {
      return false;                      
    }
  }
}