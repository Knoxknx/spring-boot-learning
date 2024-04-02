package cl.sentence.springbootdi.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cl.sentence.springbootdi.app.models.domain.ItemFactura;
import cl.sentence.springbootdi.app.models.domain.Producto;
import cl.sentence.springbootdi.app.models.services.IServicio;
import cl.sentence.springbootdi.app.models.services.MiServicio;
import cl.sentence.springbootdi.app.models.services.MiServicioComplejo;

@Configuration
public class AppConfig {

  @Bean("MiServicioSimple")
  public IServicio registrarMiServicio() {
    return new MiServicio();
  }

  @Bean("MiServicioComplejo")
  @Primary
  public IServicio registrarMiServicioComplejo() {
    return new MiServicioComplejo();
  }

  @Bean("itemsFactura")
  public List<ItemFactura> registrarItems() {
    Producto producto1 = new Producto("Yeezy 350", 200000);
    Producto producto2 = new Producto("Yeezy 350 Onyx", 200000);
    Producto producto3 = new Producto("Adidas Forum", 120000);

    ItemFactura linea1 = new ItemFactura(producto1, 2);
    ItemFactura linea2 = new ItemFactura(producto2, 3);
    ItemFactura linea3 = new ItemFactura(producto3, 7);

    return Arrays.asList(linea1, linea2, linea3);
  }

  @Bean("itemsFacturaOficina")
  public List<ItemFactura> registrarItemsOficina() {
    Producto producto1 = new Producto("Monitor Asus TUF", 250000);
    Producto producto2 = new Producto("Notebook Asus TUF", 500000);
    Producto producto3 = new Producto("Impresora HP PRO", 70000);
    Producto producto4 = new Producto("Escritorio electrico", 450000);

    ItemFactura linea1 = new ItemFactura(producto1, 2);
    ItemFactura linea2 = new ItemFactura(producto2, 1);
    ItemFactura linea3 = new ItemFactura(producto3, 5);
    ItemFactura linea4 = new ItemFactura(producto4, 1);

    return Arrays.asList(linea1, linea2, linea3, linea4);
  }
}
