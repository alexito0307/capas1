package com.anahuac.desarrollo.capas.daos;

import java.util.List;

import com.anahuac.desarrollo.capas.entidades.Libro;

public interface IDAOLibro {
  public Libro createLibro(String nombre, String autor, String editorial, String isbn);
  public Libro obtenerLibro(int id);
  public boolean modificarLibro(Libro libro);
  public void borrarLibro(String isbn);
  public List<Libro> obtenerAllLibros();
  public Libro findLibroByIsbn(String isbn);
}
