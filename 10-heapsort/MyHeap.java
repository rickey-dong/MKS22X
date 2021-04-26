public class MyHeap
{
  public static void pushDown(int[] data, int size, int index)
  {
    if ((index * 2) + 1 < size) //if it is NOT a leaf b/c you have at least one child, the left one
    {
      try
      {
        if (data[index] < data[(index * 2) + 2] || data[index] < data[(index * 2) + 1]) //if smaller than right or left child, if right exists
        {
          int leftChild = data[(index * 2) + 1];
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
      }
      catch(ArrayIndexOutOfBoundsException e) //right child does not exist
      {
        if (data[index] < data[(index * 2) + 1]) //if smaller than left child
        {
          int swap = data[index];
          data[index] = data[(index * 2) + 1];
          data[(index * 2) + 1] = swap;
          pushDown(data, size, (index * 2) + 1);
        }
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