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
      initialCapacity = 0; //negative should work
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
    } //we now have space
    if (size != 0)  //if there are already some elements in there, ... BUT if there are no elements, just add at [0] line 58
    {
      if (start == 0) //if start is already at [0], wrap around to the end of the array
      {
        start = data.length - 1; //wrap around
      }
      else
      {
        start--; //if you have already wrapped around, go left
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
    } //we now have space
    if (size != 0) //if there are no elements, just add at [0], BUT if there are already, ...
    {
      if (end == data.length - 1) //if you're at the end of the array, wrap around
      {
        end = 0; //to the beginning
      }
      else
      {
        end++; // just keep going right
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
    if (data.length != 0) //transplant the elements to the larger deque
    {
      if (start >= end)                                // 3     9      6         ->    9    6   3    _   _   _  _
      {                                                // e     s                      s        e    extra space
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
      else                                              // 3     5      7       ->      3   5   7   _   _   _  _ 
      {                                                 // s            e       ->      s      e     extra space
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
    else //TO PREVENT out of bounds errors for negatives and zeroes sizes
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
    E removedThis = data[start]; //you're not actually removing it, just ignoring it
    if (size != -1) //but if size IS 1, just decrease size and ignore that removed one
    {
      if (start == data.length - 1) // once you remove the head at the very end, wrap around so that the head is now at the beginning
      {
        start = 0;
      }
      else
      {
        start++; //new start position keeps going right
      }
    }
    size--; //size decreases because an element was removed
    return removedThis;
  }
  public E removeLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty"); //can't remove thin air
    }
    E removedThis = data[end]; //"remove"
    if (size != -1) //just decrease the size if it is size 1
    {
      if (end == 0) //if tail was at beginning, wrap around so new tail is at the very end
      {
        end = data.length -1;
      }
      else
      {
        end--; // new end position goes left
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
    return data[start]; //get element at start
  }
  public E getLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    return data[end]; //get element at end
  }
  public String toString()
  {
    String representation = "{";
    int startPos = start;
    for (int i = 0; i < size; i++)
    {
      if (i != size -1)
      { //modulus property: if start < end, then it'll just go linearly, but otherwise it'll use remainder to loop around since
      // 3 9 6 where 9 is start and 3 is end, when start becomes index 3, 3 % 3 = 0, where index 0 is 3, the ending portion 
        representation += data[startPos % data.length] + ", ";
      }
      else
      {
        representation += data[startPos % data.length]; //don't add comma if last element
      }
      startPos++;
    }
    representation += "}";
    return representation;
  }
}