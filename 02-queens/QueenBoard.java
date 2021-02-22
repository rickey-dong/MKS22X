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
    if ( (row < 0 || row >= board.length) || (col < 0 || col >= board.length) )
    {
      throw new ArrayIndexOutOfBoundsException("row or column must be within the board");
    }
    if (board[row][col] == 0)                  // if the spot we want to add queen is clean, we can add
    {
      board[row][col] = -1;                    // queen is represented by -1
      int columnRay = col+1;
      int rowRay = row-1;
      while (columnRay < board.length)
      {
        board[row][columnRay] += 1;                // death ray of queen to the right
        columnRay++;
      }
      columnRay = col+1;
      while (columnRay < board.length && rowRay >= 0)
      {
        board[rowRay][columnRay] += 1;
        rowRay--;
        columnRay++;                              // death ray of queen to top right
      }
      columnRay = col+1;
      rowRay = row+1;
      while (columnRay < board.length && rowRay < board.length)
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
    while (columnRay < board.length)
    {
      board[row][columnRay] -= 1;                // removing death ray of queen to the right
      columnRay++;
    }
    columnRay = col+1;
    while (columnRay < board.length && rowRay >= 0)
    {
      board[rowRay][columnRay] -= 1;
      rowRay--;
      columnRay++;                              // removing death ray of queen to top right
    }
    columnRay = col+1;
    rowRay = row+1;
    while (columnRay < board.length && rowRay < board.length)
    {
      board[rowRay][columnRay] -= 1;
      rowRay++;
      columnRay++;                              // removing death ray of queen to bottom right
    }
  }
  public String toString()
  {
    String boardString = "";
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board.length; col++)
      {
        if (board[row][col] == -1)
        {
          boardString += "Q";
        }
        else
        {
          boardString += "_";
        }
        if (col != board.length - 1)
        {
          boardString += " ";
        }
      }
      if (row != board.length - 1)
      {
        boardString += "\n";
      }
    }
    return boardString;
  }
  public boolean solve()
  {
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board.length; col++)
      {
        if (board[row][col] != 0)
        {
          throw new IllegalStateException("board is supposed to start with a clean slate");
        }
      }
    }
    return solve(0);
  }
  public boolean solve(int col)
  {
    if (col == board.length)
    {
      return true;
    }
    else
    {
      for (int row = 0; row < board.length; row++)
      {
        if (addQueen(row, col))
        {
          if (!solve(col+1))
          {
            removeQueen(row, col);
          }
          else
          {
            return true;
          }
        }
      }
    }
    return false;
  }
  public int countSolutions()
  {
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board.length; col++)
      {
        if (board[row][col] != 0)
        {
          throw new IllegalStateException("board is supposed to start with a clean slate");
        }
      }
    }
    return countSolutions(0);
  }
  public int countSolutions(int col)
  {
    if (col == board.length)
    {
      return 1;
    }
    else
    {
      int counter = 0;
      for (int row = 0; row < board.length; row++)
      {
        if (addQueen(row, col))
        {
          counter += countSolutions(col+1);
          removeQueen(row,col);
        }
      }
      return counter;
    }
  }
}