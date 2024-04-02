package cl.sentence.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.sentence.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
  @Value("${texto.indexController.index.titulo}")
  private String textoIndex;
  @Value("${texto.indexController.perfil.titulo}")
  private String textoPerfil;
  @Value("${texto.indexController.listar.titulo}")
  private String textoListar;

  @GetMapping(value = { "/", "/index", "home" })
  public String index(Model model) {
    model.addAttribute("titulo", textoIndex);
    model.addAttribute("body", "Mensaje dentro de un cuerpo");
    return "index.html";
  }

  @GetMapping(value = "/perfil")
  public String perfil(Model model) {
    Usuario usuario = new Usuario();
    usuario.setNombre("Fort");
    usuario.setApellido("Knox");
    usuario.setEmail("correo@correo.com");
    model.addAttribute("usuario", usuario);
    model.addAttribute("titulo", textoPerfil);
    return "perfil";
  }

  @GetMapping(value = "/listar")
  public String listar(Model model) {
    model.addAttribute("titulo", textoListar);
    return "listar";
  }

  @ModelAttribute("usuarios")
  public List<Usuario> poblarUsuarios() {
    List<Usuario> usuarios = Arrays.asList(
        new Usuario("Fort", "Knox", "correo@correo.com"),
        new Usuario("Damian", "Wayne", "correo@correo.com"),
        new Usuario("Jessica", "Jones", "correo@correo.com"),
        new Usuario("Juan", "Valdez", "correo@correo.com"));
    return usuarios;
  }
}
