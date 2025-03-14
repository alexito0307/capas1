package com.anahuac.desarrollo.capas.presentacion;

import com.anahuac.desarrollo.capas.daos.DAOLibroSqlite;
import com.anahuac.desarrollo.capas.daos.IDAOLibro;
import com.anahuac.desarrollo.capas.entidades.Libro;
import com.anahuac.desarrollo.capas.logica.ServicioLibros;

public class App {
  public static void main(String[] args) {
    IDAOLibro dao = new DAOLibroSqlite();
    ServicioLibros servicio = new ServicioLibros(dao);
    
    Libro l = servicio.agregarLibro("ISBN1000", "libro1000", "autor1000", "editorial1000");

    if(l != null) {
      System.out.println("Libro agregado: " + l.getId());
    } else {
      System.out.println("Libro no agregado, ya existe");
    }
  }
}
