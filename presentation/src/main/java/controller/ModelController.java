package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import solution.model.Model;
import solution.service.ModelService;

@Controller
@RequestMapping
public class ModelController {

  private ModelService service;

  @Autowired
  public ModelController(ModelService service) {
    this.service = service;
  }

  @PostMapping
  public String getAttributes(HttpServletRequest request, org.springframework.ui.Model model) {
    Model model1 = new Model(request.getParameter("firstName"), request.getParameter("lastName"));
    model.addAttribute("mapWords", service.returnMapWithCountAllCharacters(model1));
    model.addAttribute("string", service.returnStringWithRemovedCharacters(model1));
    return "index";
  }
}
