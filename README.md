# CSCI 1102 Computer Science 2

### Spring 2021

------

## Lecture Notes

### Week 3: ADTs in Java

#### Topics:

1. ADTs in Java
2. The StringStack ADT & a Postfix Expression Evaluator
---

### 1. ADTs in Java

The main idea of ADTs:

1. When implementing data structures and their associated algorithms we're going to use [Liskov](https://en.wikipedia.org/wiki/Barbara_Liskov)'s [Abstract Data Type](https://en.wikipedia.org/wiki/Abstract_data_type) (ADT) methodology. 

  ADTs have:

  - specifications/APIs  (provided to the user/clients)
  
  - implementations (the details of which are hidden from the user/clients)

Java supports this approach, albeit imperfectly. We'll use Java

  - **interfaces** for ADT specifications (although they don't do everything that ADTs actually require)

  - **classes** for ADT implementations (although they don't do everything that ADTs require either!)

2. Java classes have essentially TWO roles:
   1. as implementations of ADTs;
   2. to otherwise aggregate related definitions, e.g., all of the math functions can be bundled up in a Math class.

 Java has three kinds of types:

1. **base types** —`int`, `long`, `double`, `boolean`, etc, all lowercase;
2. **reference types** — the value of an expression `new ClassName(...)` is allocated in the heap and then *referenced* by an arrow (or pointer or address);
3. **interfaces**.

We will usually use interfaces for types rather than class names. For example, given:

```java
public interface Point { ... }
public class PointC implements Point { ... }
```

We would create a point as in

```java
Point p = new PointC(0, 0);
```

NB: we're using the interface as the type will referring to the class in the `new` expression on the right.

---

### 2. The StringStack ADT

We'll proceed through several iterations, attempting to illustrate important points relating to representation and genericity. We assume known the basic Last-In-First-Out (LIFO) behavior of stacks.

  The specification:

```java
public interface StringStack {

  // public StringStackC();

  void push(String s);
  String pop();
  String peek();
  boolean isEmpty();
  String toString();
}
```

A simple implementation:

```java
// A fixed size stack restricted to Strings.
//
public class StringStackC implements StringStack {

  // Seclecting a representation type of a fixed-length array.
  //
  private final static int CAPACITY = 1000;

  private String[] theStack;
  private int top;

  public StringStackC() {
    this.theStack = new String[CAPACITY];
    this.top = 0;
  }

  public void push(String item) {
    if (this.top == CAPACITY)
      throw new RuntimeException("Stack Overflow.");
    else
      this.theStack[this.top++] = item;
  }

  public String pop() {
    if (this.isEmpty())
      throw new RuntimeException("Stack Underflow.");
    else {
      String item = this.theStack[--this.top];
      this.theStack[this.top] = null;
      return item;
    }
  }

  public String peek() {
    if (this.isEmpty())
      throw new java.util.NoSuchElementException("Stack Underflow.");
    else
      return this.theStack[this.top - 1];
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    for(int i = this.top - 1; i >= 0; i--)
          sb.append(this.theStack[i].toString() + "\n");

    return sb.toString();
  }
  
  public static void main(String[] args) {
    // Unit testing
  }
}
```

## 3. A Postfix Expression Evaluator

See the code in the `src/postfix/` folder.