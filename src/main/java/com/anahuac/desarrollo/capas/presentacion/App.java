package com.anahuac.desarrollo.capas.presentacion;

import com.anahuac.desarrollo.capas.daos.DAOLibroSqlite;
import com.anahuac.desarrollo.capas.daos.IDAOLibro;
import com.anahuac.desarrollo.capas.entidades.Libro;
import com.anahuac.desarrollo.capas.logica.ServicioLibros;

public class App {
  public static void main(String[] args) {
    IDAOLibro dao = new DAOLibroSqlite();
    ServicioLibros servicio = new ServicioLibros(dao);
    
    Libro l = servicio.agregarLibro("ISBN1", "libro1", "autor1", "editorial1");
    servicio.agregarLibro("ISBN2", "libro2", "autor2", "editorial2");
    servicio.agregarLibro("ISBN3", "libro3", "autor3", "editorial3");
  

    if(l == null) {
      System.out.println("El id del libro es: " + l.getId());
    } else {
      System.out.println("El libro ya existe");
    }
  }
}
