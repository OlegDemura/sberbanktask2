package solution.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import solution.model.Model;

@Component
public class StringWithRemovedCharacters1 {

  public Map<Character, Integer> returnMapWithCountAllCharacters(Model model) {

    String s = model.getLastName();
    Map<Character, Integer> map = new HashMap<>();

    for (Character c : s.toLowerCase().toCharArray()) {
      map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
    }
    return map;
  }

}
