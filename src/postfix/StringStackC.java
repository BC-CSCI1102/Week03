// file: StringStackC.java
// author: Bob Muller
//
// An implementation of a simple stack ADT.
//

import java.util.NoSuchElementException;

public class StringStackC implements StringStack {

  // Concrete representation type
  private static final int CAPACITY = 1000;
  private int top;
  private String[] theStack;

  public StringStackC() {
    this.top = 0;
    this.theStack = new String[CAPACITY];
  }

  public void push(String s) {
    if (this.top == CAPACITY)
      throw new RuntimeException("Stack Overflow");
    else
      this.theStack[this.top++] = s;
  }

  public String pop() {
    if (this.top == 0)
      throw new NoSuchElementException("Stack Underflow");
    else {
      String item = this.theStack[--this.top];
      this.theStack[this.top] = null;
      return item;
    }
  }

  public String peek() {
    if (this.top == 0)
      throw new NoSuchElementException("Stack Underflow");
    else {
      String item = this.theStack[this.top - 1];
      return item;
    }
  }

  public boolean isEmpty() {
    return this.top == 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = this.top - 1; i >= 0; i--)
      sb.append(String.format("%s\n", this.theStack[i]));

    return sb.toString();
  }

  public static void main(String[] args) {

    // Unit testing
    StringStack myStack = new StringStackC();

    myStack.push("Alice");
    myStack.push("Jose");
    myStack.push("Bob");

    while (!myStack.isEmpty())
      System.out.format("%s\n", myStack.pop());
  }
}

