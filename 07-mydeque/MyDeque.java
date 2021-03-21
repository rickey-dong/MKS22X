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
    System.out.println(start);
    System.out.println(end);
    @SuppressWarnings("unchecked")
    E[] largerDeque = (E[])new Object[(data.length * 2) + 1]; //3
    for (int i = 0; i <= start-1; i++)
    {
      largerDeque[i] = data[i];
    }
    int ending = end; //10
    if (end == 0)
    {
      ending++;
      end = largerDeque.length - ending; //2  
      ending--;
    }
    else
    {
      end = largerDeque.length - ending; //11
    }
    for (int i = end; i < data.length; i++)
    {
      System.out.println(i);
      System.out.println(largerDeque.length);
      System.out.println(ending);
      largerDeque[i+data.length+1] = data[ending];
      ending++;
    }
    if (data.length == 0)
    {
      start = 0;
      end = 0;
    }
    data = largerDeque;
  }
  public E removeFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    E removedThis;
    if (start != 0)
    {
      removedThis = data[start-1];
      start--;
      size--;
    }
    else
    {
      removedThis = data[data.length-end];
      size--;
      end++;
    }
    return removedThis;
  }
  public E removeLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    E removedThis;
    if (end != data.length -1)
    {
      removedThis = data[end+1];
      end++;
      size--;
    }
    else
    {
      removedThis = data[Math.abs(size-start)];
      size--;
    }
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
        if (i != 0 || end != data.length - 1 && data[end+1] != null)
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