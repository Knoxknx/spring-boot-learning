package cl.sentence.springbootdi.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// @Service("miServicioSimple")
@Primary
public class MiServicio implements IServicio {

  @Override
  public String operacion() {
    return "ejecutando algun proceso importante simple...";
  }
}
