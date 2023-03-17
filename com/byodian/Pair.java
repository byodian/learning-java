package com.byodian;

public class Pair<T> {
  private T first;
  private T second;

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() { 

    System.out.println("first" + first);
    return first;
  }
  public T getSecond() { return second;}

  public void setFirst(T newValue) { 
    System.out.println(newValue instanceof T);
    first = newValue; 
  }
  public void setSecond(T newValue) { second = newValue; }

  public static void main(String[] args) {
    Pair<Number> pair = new Pair<Number>(12, 12);
    pair.getFirst();
  }
}
