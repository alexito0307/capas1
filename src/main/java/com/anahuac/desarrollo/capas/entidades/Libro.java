package com.anahuac.desarrollo.capas.entidades;

public class Libro {

  private int id;
  private String nombre;
  private String autor;
  private String editorial;
  private String isbn;
  public Libro (int id, String nombre, String autor, String isbn, String editorial) {
    this.id = id;
    this.nombre = nombre;
    this.autor = autor;
    this.isbn = isbn;
    this.editorial = editorial;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getEditorial() {
    return editorial;
  }

  public void setEditorial(String editorial) {
    this.editorial = editorial;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
