package solution.service;

import com.sun.org.apache.xml.internal.dtm.ref.dom2dtm.DOM2DTM.CharacterNodeHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solution.model.Model;

@Service
public class ModelService {

  private StringWithRemovedCharacters1 service1;
  private StringWithRemovedCharacters2 service2;
  private StringWithRemovedCharacters3 service3;

  @Autowired
  public ModelService(StringWithRemovedCharacters1 service1,
      StringWithRemovedCharacters2 service2, StringWithRemovedCharacters3 service3) {
    this.service1 = service1;
    this.service2 = service2;
    this.service3 = service3;
  }

  public Map<Character, Integer> returnMapWithCountAllCharacters(Model model) {

    String s = model.getFirstName() + model.getLastName();
    Map<Character, Integer> map = new HashMap<>();

    for (Character c : s.toLowerCase().toCharArray()) {
      map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
    }
    return map;
  }

  public String returnStringWithRemovedCharacters(Model model) {
    if (model.getLastName().isEmpty()) {
      return null;
    }

    Map<Character, Integer> map = service1.returnMapWithCountAllCharacters(model);

    int max = service2.returnMax(map);

    List<Character> list = service3.characters(map, max);

    if (list.size() > 1) {
      return model.getLastName();
    }

    return model.getLastName().replace(String.valueOf(list.get(0)), "");
  }

}
