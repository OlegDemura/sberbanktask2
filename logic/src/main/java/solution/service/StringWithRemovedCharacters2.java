package solution.service;

import java.util.Comparator;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class StringWithRemovedCharacters2 {

  public Integer returnMax(Map<Character, Integer> map) {
    return map.values().stream().max(Comparator.naturalOrder()).get();
  }

}
