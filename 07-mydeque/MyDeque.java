public class MyDeque<E>
{
  private E[] data;
  private int size, start, end;
  public MyDeque()
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }
  public MyDeque(int initialCapacity)
  {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
  }
}