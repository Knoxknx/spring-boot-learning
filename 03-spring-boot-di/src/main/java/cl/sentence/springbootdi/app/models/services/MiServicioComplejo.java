package cl.sentence.springbootdi.app.models.services;

import org.springframework.stereotype.Service;

// @Service("MiServicioComplejo")
public class MiServicioComplejo implements IServicio {

  @Override
  public String operacion() {
    return "ejecutando algun proceso importante complicado...";
  }
}
