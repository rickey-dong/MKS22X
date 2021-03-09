public class Preliminary
{
  public static int partition(int[] data, int start, int end)
  {
    //randomly choose a pivot within start to end inclusive
    //swap that with the front of the subarray
    //going forward at current, where current = start+1, loop through the rest of the
    //elements in the subarray while also having a pointer at the end
    //if element is less than pivot, don't do anything and current moves right
    //if it's greater than p, swap with the element at end pointer, end pointer moving left
    //if equal to p, just flip a coin to decide if it goes left or right
    //at the very last element, if it's greater than p, p gets inserted right before it/swapped
    //if it's smaller than p, it gets swapper w/ p.
    //return current index of p;
  }
}