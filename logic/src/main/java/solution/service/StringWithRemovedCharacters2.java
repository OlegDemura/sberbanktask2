package solution.service;

import java.util.Comparator;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class StringWithRemovedCharacters2 {

  /*public Character returnCharacter(Map<Character, Integer> map) {
    return map.entrySet().stream()
        .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
        .get()
        .getKey();
  }*/

  public Integer returnMax(Map<Character, Integer> map) {
    return map.values().stream().max(Comparator.naturalOrder()).get();
  }

}
