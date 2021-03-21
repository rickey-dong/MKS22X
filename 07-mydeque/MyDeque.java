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
    start = 0; //start is 0
    end = 9; //end is 9
  }
  public MyDeque(int initialCapacity) //user chooses capacity
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0; //start is 0
    end = data.length - 1; //end is the last index
    if (initialCapacity == 0) //unless the capacity is 0, in which case make them -1
    {
      end = -1;
      start = -1;
    }
    size = 0; //currently no elements in there so far
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
    data[start] = element; //insert the element
    start++; //start moves one index to the right 
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
    data[end] = element; //insert the element
    end--; //end moves one index to the left
    size++; //size increases by 1
  }
  private void resize()
  {
    @SuppressWarnings("unchecked")
    E[] largerDeque = (E[])new Object[(data.length * 2) + 1]; //make a larger deque
    if (data.length == 0) //math manip to prevent indexing errors with -1
    {
      start = 0;
      end = 0;
    }
    for (int i = 0; i <= start-1; i++)
    {
      largerDeque[i] = data[i]; //transplant the elements from the beginning into the larger deque
    }
    int oldLength = data.length-1;
    int newEnding = largerDeque.length - 1; //math manip to set up the transferring of the elements from the end
    for (int i = largerDeque.length - 1; oldLength > end; oldLength--)
    {
      largerDeque[i] = data[oldLength];
      i--;
      newEnding = i; //transplant the elements from the end into the larger deque
    }
    end = newEnding; //new pointer for end in the larger deque but start stays the same
    data = largerDeque; //we have a new larger deque
  }
  public E removeFirst()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty"); //can't remove thin air
    }
    E removedThis;
    if (start != 0)
    {
      removedThis = data[start-1]; //remove the element that was one index behind start and move start down
      start--;
      size--;
    }
    else //this means you didn't add anything from the start, but you did add things from the back
    {
      removedThis = data[end+size]; // the last element is the head when you only added from the back and more math manip
      size--;
    }//size decreases and pointer moves around
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
    else //this means you only added from start and not from end
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
    if (start == 0) //this means we only added from back
    {
      return data[data.length-1];
    }
    return data[start-1];
  }
  public E getLast()
  {
    if (size == 0)
    {
      throw new NoSuchElementException("this deque is empty");
    }
    if (end == data.length - 1) //this means we only added from front
    {
      return data[0];
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
    for (int i = size - 1; i > end; i--)
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