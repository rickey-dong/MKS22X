public class MyDeque<E>
{
  private E[] data;
  private int size, start, end;
  public MyDeque()
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = data.length - 1;
  }
  public MyDeque(int initialCapacity)
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = data.length - 1;
    if (initialCapacity == 0)
    {
      end = 0;
    }
  }
  public int size()
  {
    return size;
  }
  public void addFirst(E element)
  {
    if (element == null)
    {
      throw new NullPointerException("this deque does not permit null elements");
    }
    if (start == end - 1)
    {
      resize();
    }
    data[start+1] = element;
    start++;
  }
  public void addLast(E element)
  {
    if (element == null)
    {
      throw new NullPointerException("this deque does not permit null elements");
    }
    if (start == end - 1)
    {
      resize();
    }
    data[end-1] = element;
    end--;
  }
  private void resize()
  {
    @SuppressWarnings("unchecked")
    E[] largerDeque = (E[])new Object[(data.length * 2) + 1];
    for (int i = 0; i <= start; i++)
    {
      largerDeque[i] = data[i];
    }
    int ending = end;
    end = largerDeque.length - ending;
    for (int i = largerDeque.length - ending; i < largerDeque.length; i++)
    {
      largerDeque[i] = data[ending];
      ending++;
    }
    data = largerDeque;
  }
}























