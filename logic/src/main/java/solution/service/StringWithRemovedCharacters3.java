package solution.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class StringWithRemovedCharacters3 {

  public List<Character> characters(Map<Character, Integer> map, int max) {
    return map.entrySet().stream()
        .filter(v -> v.getValue() == max).map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

}
