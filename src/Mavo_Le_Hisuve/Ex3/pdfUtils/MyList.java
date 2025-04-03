package Mavo_Le_Hisuve.Ex3.pdfUtils;

import java.util.ArrayList;

public class MyList<T> implements MyListInterface<T> {
  ArrayList<T> values;

  public MyList() {
    values = new ArrayList<>();
  }

  @Override
  public void addAt(T a, int i) {
    if (i == values.size()) {
      values.add(a);
      return;
    }

    ArrayList<T> newValues = new ArrayList<T>();

    for (int j = 0; j < i; j++) {
      newValues.add(values.get(j));
    }

    newValues.add(a);

    for (int j = i; j < values.size(); i++) {
      newValues.add(values.get(j));
    }

    values = newValues;
  }

  @Override
  public void removeElementAt(int i) {
    ArrayList<T> newValues = new ArrayList<T>();

    for (int j = 0; j < values.size(); j++) {
      if (j != i)
        newValues.add(values.get(j));
    }

    values = newValues;
  }

  @Override
  public boolean contains(T data) {
    for (int i = 0; i < values.size(); i++) {
      if (values.get(i) == data)
        return true;
    }
    return false;
  }

  @Override
  public T get(int i) {
    return values.get(i);
  }

  @Override
  public int size() {
    return values.size();
  }
}
