package cl.sentence.springbootdi.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.sentence.springbootdi.app.models.services.IServicio;

@Controller
public class IndexController {

  @Autowired
  // @Qualifier("MiServicioComplejo")
  private IServicio servicio;

  @GetMapping({ "/", "", "/index" })
  public String index(Model model) {
    model.addAttribute("titulo", "Index");
    model.addAttribute("objeto", servicio.operacion());
    return "index";
  }
}
