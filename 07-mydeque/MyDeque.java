import java.util.NoSuchElementException;
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
      end = -1;
      start = -1;
    }
    size = 0;
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
    if (size == data.length)
    {
      resize();
    }
    data[start] = element;
    start++;
    size++;
  }
  public void addLast(E element)
  {
    if (element == null)
    {
      throw new NullPointerException("this deque does not permit null elements");
    }
    if (size == data.length)
    {
      resize();
    }
    data[end] = element;
    end--;
    size++;
  }
  private void resize()
  {
    start--;
    end++;
    @SuppressWarnings("unchecked")
    E[] largerDeque = (E[])new Object[(data.length * 2) + 1]; //3
    for (int i = 0; i <= start; i++)
    {
      largerDeque[i] = data[i];
    }
    int ending = end; //0
    if (end == 0)
    {
      ending++;
      end = largerDeque.length - ending; //2  
      ending--;
    }
    else
    {
      end = largerDeque.length - ending;
    }
    for (int i = end; i < largerDeque.length; i++)
    {
      largerDeque[i] = data[ending];
      ending++;
    }
    if (data.length == 0)
    {
      start = 0;
      end = 0;
    }
    data = largerDeque;
    start++;
    end--;
  }
  public E removeFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    E removedThis = data[start];
    start--;
    size--;
    return removedThis;
  }
  public E removeLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    E removedThis = data[end];
    end++;
    size--;
    return removedThis;
  }
  public E getFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    return data[start-1];
  }
  public E getLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    return data[end+1];
  }
  public String toString()
  {
    String representation = "{";
    for (int i = start-1; i >= 0; i--)
    {
      if (data[i] != null)
      {
        representation += data[i];
        if (end != data.length - 1 && data[end+1] != null)
        {
          representation += ", ";
        }
      }
    }
    for (int i = data.length - 1; i > end; i--)
    {
      if (data[i] != null)
      {
        if (i != end + 1)
        {
          representation += data[i];
          representation += ", ";
        }
        else
        {
          representation += data[i];
        }
      }
    }
    representation += "}";
    return representation;
  }
}