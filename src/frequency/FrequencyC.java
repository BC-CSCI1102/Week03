/* *****************************************************************************
 *  Name:    Ada Lovelace
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;

public class FrequencyC implements Frequency {

  private Map<String, Integer> ft;

  public FrequencyC() {
    this.ft = new HashMap<String, Integer>();
  }

  public FrequencyC(String file) {
    this.ft = new HashMap<String, Integer>();

    In in = new In(file);
    try {
      while (true) {
        String school = in.readString();
        String major = in.readString();
        if (this.ft.containsKey(major))
          this.ft.put(major, this.ft.get(major) + 1);
        else
          this.ft.put(major, 1);
        int year = in.readInt();
      }
    }
    catch (NoSuchElementException e) {
      in.close();
    }
  }

  public int get(String key) {
    return ft.get(key);
  }

  public boolean containsKey(String key) {
    return ft.containsKey(key);
  }

  public void put(String key, int value) {
    ft.put(key, value);
  }

  public void forEach(BiConsumer<String, Integer> opn) {
    ft.forEach(opn);
  }

  public Collection<Integer> values() {
    return ft.values();
  }

  public Set<String> keys() {
    return ft.keySet();
  }

  public int size() {
    return ft.size();
  }

  private static void myPrinter(String s, Integer i) {
    System.out.format("%s = %d ", s, i);
  }

  public static void main(String[] args) {

    // Unit testing for the Frequency Table Type.
    //
    Frequency frequency = new FrequencyC();

    frequency.put("Alice", 20);
    frequency.put("Bob", 10);

    frequency.forEach((key, value) -> System.out.format("%s = %d ", key, value));
    System.out.println();
    frequency.forEach(FrequencyC::myPrinter);

  }
}
