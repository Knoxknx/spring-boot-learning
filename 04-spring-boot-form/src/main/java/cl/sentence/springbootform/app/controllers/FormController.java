package cl.sentence.springbootform.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.sentence.springbootform.app.models.domain.Usuario;

@Controller
public class FormController {

  @GetMapping("/form")
  public String form(Model model) {
    model.addAttribute("titulo", "Formulario usuarios");
    return "form";
  }

  @PostMapping("/form")
  public String procesar(Usuario usuario, Model model) {
    model.addAttribute("titulo", "Formulario usuarios");
    model.addAttribute("usuario", usuario);
    return "resultado";
  }

}
