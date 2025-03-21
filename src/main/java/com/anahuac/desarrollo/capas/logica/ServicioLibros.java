package com.anahuac.desarrollo.capas.logica;

import com.anahuac.desarrollo.capas.daos.DAOLibroSqlite;
import com.anahuac.desarrollo.capas.daos.IDAOLibro;
import com.anahuac.desarrollo.capas.entidades.Libro;

public class ServicioLibros {
  private IDAOLibro daoLibro = new DAOLibroSqlite();

  public ServicioLibros(IDAOLibro dao) {
    this.daoLibro = dao;
  }

  public Libro agregarLibro(String isbn, String nombre, String autor, String editorial) { //Validar que el isbn sea unico
    Libro libro = daoLibro.findLibroByIsbn(isbn);
    if (libro == null) {
      libro = daoLibro.createLibro(isbn, nombre, autor, editorial);
      System.out.println(libro.toString());
      System.out.println("Libro agregado: " + libro.getNombre());
    } else {
      System.out.println("Ya existe el libro.");
    }
    return libro;
  }
}
