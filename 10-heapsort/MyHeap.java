public class MyHeap
{
  public static void pushDown(int[] data, int size, int index)
  {
    if  ( (index * 2) + 1 < size //if it is NOT a leaf (b/c you have at least one child) AND
        && (data[index] < data[(index * 2) + 1] //not bigger than left child OR
        || ((index * 2) + 2 < size && data[index] < data[(index * 2) + 2]) ) )//not bigger than right child
    {
      int leftChild = data[(index * 2) + 1];
      if ( (index * 2) + 2 < size)
      {
        int rightChild = data[(index * 2) + 2];
        if (leftChild <= rightChild)
        {
          int swap = data[index];
          data[index] = data[(index * 2) + 2];
          data[(index * 2) + 2] = swap;
          pushDown(data, size, (index * 2) + 2);
        }
        else
        {
          int swap = data[index];
          data[index] = data[(index * 2) + 1];
          data[(index * 2) + 1] = swap;
          pushDown(data, size, (index * 2) + 1);
        }
      }
      else
      {
        pushDown(data, size, (index * 2) + 1);
      }
    }
  }
  public static void buildHeap(int[] data)
  {
    for (int currentIndex = data.length-1; currentIndex >= 0; currentIndex--)
    {
      pushDown(data, data.length, currentIndex);
    }
  }
}