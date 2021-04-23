public class MyHeap
{
  private static void pushDown(int[] data, int size, int index)
  {
    
  }
  private static int[] getIndicesOfChildren(int parentIndex)
  {
    int[] childrenIndices = new int[2];
    childrenIndices[0] = (parentIndex * 2) + 1;
    childrenIndices[1] = (parentIndex * 2) + 2;
    return childrenIndices;
  }
}