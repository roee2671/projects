package Mavo_Le_Hisuve.Ex3.pdfUtils;

import java.util.Iterator;

public interface BinaryTree<T> {
  /** @return the left (sub) tree - might be null. */
  public BinaryTree<T> getLeft();

  /** @return the right (sub) tree - might be null. */
  public BinaryTree<T> getRight();

  public T getRoot(); // The root data (type T).

  public boolean isEmpty();

  /** @return the number of nodes in this tree. */
  public int size();

  /**
   * Adds the data "a" to this tree, in a regular BT can be implemented using a
   * random
   * (left/right). In Binary Search Tree-is done using the InOrder (natural)
   * Order.
   */
  public void add(T a);

  /** @return the i'th node using inorder “indexind” */
  public T get(int i);

  /**
   * search the binary tree for the first node that equals to t. If none returns
   * null
   */
  public T find(T t);

  /** returns an in_order iterator */
  public Iterator<T> iterator();

  /**
   * removes the first node that equals to t. If exists - returns it, else returns
   * null
   */
  public T remove(T element);
}