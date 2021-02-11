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

import java.util.Collection;
import java.util.Set;

public interface Frequency {

  int size();

  int get(String key);

  boolean containsKey(String key);

  void put(String key, int value);

  void forEach(java.util.function.BiConsumer<String, Integer> operation);

  Collection<Integer> values();

  Set<String> keys();
}


