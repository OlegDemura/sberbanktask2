package solution.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import solution.model.Model;

@SpringJUnitConfig(locations = {
    "classpath:spring/spring.xml"
})
class ModelServiceTest {

  @Autowired
  private ModelService modelService;

  @Test
  void returnMapWithCountAllCharacters() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('ф', 1);
    map.put('а', 1);
    map.put('м', 2);
    map.put('и', 3);
    map.put('л', 1);
    map.put('я', 2);

    Model model = new Model("Имя", "Фамилия");

    Map<Character, Integer> expected = modelService.returnMapWithCountAllCharacters(model);

    assertThat(map, is(expected));
    assertThat(map.size(), is(6));
  }

  @Test
  void returnStringWithRemovedCharacters() {
    Model model = new Model("Имя", "Фамилия");

    String actual = modelService.returnStringWithRemovedCharacters(model);
    String expected = "Фамля";

    assertThat(actual).isEqualTo(expected);
  }
}