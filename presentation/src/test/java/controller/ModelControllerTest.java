package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ModelControllerTest extends AbstractControllerTest {

  @Test
  void getAttributes() throws Exception {
    Map<Character, Integer> map = new HashMap<>();
    map.put('ф', 1);
    map.put('а', 1);
    map.put('м', 2);
    map.put('и', 3);
    map.put('л', 1);
    map.put('я', 2);

    mockMvc.perform(post("/")
        .param("firstName", "Имя")
        .param("lastName", "Фамилия"))
        .andExpect(status().isOk())
        .andExpect(model().size(2))
        .andExpect(model().attributeExists("mapWords"))
        .andExpect(model().attributeExists("string"))
        .andExpect(model().attribute("mapWords", map))
        .andExpect(model().attribute("string", "Фамля"));
  }
}