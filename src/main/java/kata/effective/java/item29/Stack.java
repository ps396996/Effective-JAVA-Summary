package kata.effective.java.item29;

import java.util.EmptyStackException;
import java.util.Objects;

public class Stack<E>{
  private E[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public Stack(){
    elements = (E[]) new Objects[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E e){
    ensureCapacity();
    elements[size++] = e;
  }

  private void ensureCapacity() {
  }

  public E pop(){
    if (size == 0)
      throw new EmptyStackException();
    E result = elements[--size];
    elements[size] = null;
    return result;
  }
}