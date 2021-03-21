import java.util.NoSuchElementException;
public class MyDeque<E>
{
  private E[] data; //this is an ArrayDeque
  private int size, start, end; //two pointers for head and tail and keep track of current size
  public MyDeque()
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10]; //default capacity 10
    data = d;
    size = 0; //there are no elements in there so far
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity) //user chooses capacity
  {
    if (initialCapacity < 0)
    {
      initialCapacity = 0;
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0; //start is 0
    end = 0;
    size = 0; //currently no elements in there so far
    if (data.length == 0)
    {
      start = -1;
      end = -1;
    }
  }
  public int size()
  {
    return size; //return size
  }
  public void addFirst(E element)
  {
    if (element == null)
    {
      throw new NullPointerException("this deque does not permit null elements"); //cannot be null
    }
    if (size == data.length) //we have no more space
    {
      resize();
    }
    if (size != 0)
    {
      if (start == 0)
      {
        start = data.length - 1;
      }
      else
      {
        start--;
      }
    }
    data[start] = element; //insert the element
    size++; //size increases by 1
  }
  public void addLast(E element)
  {
    if (element == null)
    {
      throw new NullPointerException("this deque does not permit null elements"); //cannot be null
    }
    if (size == data.length) //we have no more space
    {
      resize();
    }
    if (size != 0)
    {
      if (end == data.length - 1)
      {
        end = 0;
      }
      else
      {
        end++;
      }
    }
    data[end] = element; //insert the element
    size++; //size increases by 1
  }
  private void resize()
  {
    @SuppressWarnings("unchecked")
    E[] largerDeque = (E[])new Object[(data.length * 2) + 1]; //make a larger deque
    int indexOfLarger = 0;
    if (data.length != 0)
    {
      if (start >= end)
      {
        for (int i = start; i < data.length; i++)
        {
          largerDeque[indexOfLarger] = data[i];
          indexOfLarger++;
        }
        for (int i = 0; i <= end; i++)
        {
          largerDeque[indexOfLarger] = data[i];
          indexOfLarger++;
        }
      }
      else
      {
        for (int i = start; i <= end; i++)
        {
          largerDeque[indexOfLarger] = data[i];
          indexOfLarger++;
        }
      }
      data = largerDeque;
      start = 0;
      end = size() - 1;
    }
    else
    {
      data = largerDeque;
      start = 0;
      end = 0;
    }
  }
  public E removeFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty"); //can't remove thin air
    }
    E removedThis = data[start];
    if (size != -1)
    {
      if (start == data.length - 1)
      {
        start = 0;
      }
      else
      {
        start++;
      }
    }
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
    if (size != -1)
    {
      if (end == 0)
      {
        end = data.length -1;
      }
      else
      {
        end--;
      }
    }
    size--;
    return removedThis;
  }
  public E getFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    return data[start];
  }
  public E getLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    return data[end];
  }
  public String toString()
  {
    String representation = "{";
    int startPos = start;
    for (int i = 0; i < size; i++)
    {
      if (i != size -1)
      {
        representation += data[startPos % data.length] + ", ";
      }
      else
      {
        representation += data[startPos % data.length];
      }
      startPos++;
    }
    representation += "}";
    return representation;
  }
}