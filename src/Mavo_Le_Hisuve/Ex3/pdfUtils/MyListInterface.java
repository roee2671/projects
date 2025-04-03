package Mavo_Le_Hisuve.Ex3.pdfUtils;

public interface MyListInterface<T> {
  /** Adds a String to the i"th link of the List. */
  public void addAt(T a, int i);

  /** Removes the i"th element (link) of this List. */
  public void removeElementAt(int i);

  /** Tests if ‘data’ is a member of this List. */
  public boolean contains(T data);

  /** Returns the i"th element in this List. */
  public T get(int i);

  /** Returns the number of Links in this List. */
  public int size();
}