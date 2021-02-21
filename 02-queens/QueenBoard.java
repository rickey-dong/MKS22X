public class QueenBoard
{
  private int[][] board;
  public QueenBoard(int size)
  {
    board = new int[size][size];
    for (int row = 0; row < size; row++)          // abc                                                  
    {                                             // def          row 0 is abc, col 0 is ad
      for (int col = 0; col < size; col++)
      {
        board[row][col] = 0;
      }
    }
  }
  private boolean addQueen(int row, int col)              
  {
    if ( (row < 0 || row >= board[0].length) || (col < 0 || col >= board[0].length) )
    {
      throw new ArrayIndexOutOfBoundsException("row or column must be within the board");
    }
    if (board[row][col] == 0)                  // if the spot we want to add queen is clean, we can add
    {
      board[row][col] = -1;                    // queen is represented by -1
      int columnRay = col+1;
      int rowRay = row-1;
      while (columnRay < board[0].length)
      {
        board[row][columnRay] += 1;                // death ray of queen to the right
        columnRay++;
      }
      columnRay = col+1;
      while (columnRay < board[0].length && rowRay >= 0)
      {
        board[rowRay][columnRay] += 1;
        rowRay--;
        columnRay++;                              // death ray of queen to top right
      }
      columnRay = col+1;
      rowRay = row+1;
      while (columnRay < board[0].length && rowRay < board[0].length)
      {
        board[rowRay][columnRay] += 1;
        rowRay++;
        columnRay++;                              // death ray of queen to bottom right
      }
      return true;
    }
    else                     // if it's already occupied or threatened
    {
      return false;                      
    }
  }
  private void removeQueen(int row, int col)
  {
    board[row][col] = 0;                     // spot now is empty
    int columnRay = col+1;
    int rowRay = row-1;
    while (columnRay < board[0].length)
    {
      board[row][columnRay] -= 1;                // removing death ray of queen to the right
      columnRay++;
    }
    columnRay = col+1;
    while (columnRay < board[0].length && rowRay >= 0)
    {
      board[rowRay][columnRay] -= 1;
      rowRay--;
      columnRay++;                              // removing death ray of queen to top right
    }
    columnRay = col+1;
    rowRay = row+1;
    while (columnRay < board[0].length && rowRay < board[0].length)
    {
      board[rowRay][columnRay] -= 1;
      rowRay++;
      columnRay++;                              // removing death ray of queen to bottom right
    }
  }
}