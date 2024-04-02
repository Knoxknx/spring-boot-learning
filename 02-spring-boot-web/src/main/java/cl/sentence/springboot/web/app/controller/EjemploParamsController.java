package cl.sentence.springboot.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("titulo", "Enviar parametros del request HTTP GET - URL");

    return "params/index";
  }

  @GetMapping("/string")
  public String param(@RequestParam(name = "texto", defaultValue = "Debe enviar un valor desde la URL") String texto,
      Model model) {
    model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
    model.addAttribute("resultado", "El texto enviado es: " + texto);
    return "params/ver";
  }

  @GetMapping("/mix-params")
  public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
    model.addAttribute("resultado", "El saludo es: " + saludo + " y el numero es: " + numero);
    return "params/ver";
  }

  @GetMapping("/mix-params-request")
  public String param(HttpServletRequest request, Model model) {
    String saludo = request.getParameter("saludo");
    Integer numero = null;

    try {
      numero = Integer.parseInt(request.getParameter("numero"));
    } catch (Exception e) {
      // TODO: handle exception
      numero = 0;
    }
    model.addAttribute("resultado", "El saludo es: " + saludo + " y el numero es: " + numero);
    return "params/ver";
  }

}
