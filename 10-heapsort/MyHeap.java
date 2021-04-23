public class MyHeap
{
  private static void pushDown(int[] data, int size, int index)
  {
    if (index < size/2 //if it is NOT a leaf (b/c 50% of tree are leaves) AND
        && (data[index] < data[(index * 2) + 1] //not bigger than left child OR
        || data[index] < data[(index * 2) + 2]))//not bigger than right child
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
}