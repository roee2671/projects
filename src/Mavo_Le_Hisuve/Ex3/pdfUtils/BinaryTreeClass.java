package Mavo_Le_Hisuve.Ex3.pdfUtils;

public class BinaryTreeClass<T> implements BinaryTree<T> {
  private T root; // השורש של העץ
  private BinaryTree<T> left; // תת-עץ שמאלי
  private BinaryTree<T> right; // תת-עץ ימני

  @Override
  public BinaryTree<T> getLeft() {
    return left;
  }

  @Override
  public BinaryTree<T> getRight() {
    return right;
  }

  @Override
  public T getRoot() {
    return root;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public int size() {
    if (isEmpty()) return 0;
    return 1 + (left != null ? left.size() : 0) + (right != null ? right.size() : 0);
  }

  @Override
  public void add(T a) {
    if (isEmpty()) {
      root = a;
    } else if (left == null) {
      left = new BinaryTreeClass<>();
      left.add(a);
    } else if (right == null) {
      right = new BinaryTreeClass<>();
      right.add(a);
    } else {
      left.add(a); // מוסיפים באופן רקורסיבי
    }
  }

  @Override
  public T get(int i) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public T find(T t) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public java.util.Iterator<T> iterator() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public T remove(T element) {
    throw new UnsupportedOperationException("Not implemented");
  }

  public void setRoot(T root) {
    this.root = root;
  }

  public void setLeft(BinaryTree<T> left) {
    this.left = left;
  }

  public void setRight(BinaryTree<T> right) {
    this.right = right;
  }
}
