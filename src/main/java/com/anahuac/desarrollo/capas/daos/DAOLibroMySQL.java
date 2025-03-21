package com.anahuac.desarrollo.capas.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.anahuac.desarrollo.capas.entidades.Libro;

public class DAOLibroMySQL implements IDAOLibro {

    public Connection getConnection() {
    Connection con = null;
    try {
        String url = "jdbc:mysql://localhost:3307/libreria";
        con = DriverManager.getConnection(url, "root", "123456");
    }
    catch(Exception e) {
        System.out.println("Exception at connection: " + e);
    }
    return con;
    }

    @Override
    public Libro createLibro(String isbn, String nombre, String autor, String editorial) {
        Connection con = getConnection();
        int id = -1;
        Libro libro = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO libros (nombre, autor, isbn, editorial) " + "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, autor);
            ps.setString(3, isbn);
            ps.setString(4, editorial);

            //Ejecutar el PS
        
            int rows = ps.executeUpdate(); //Regresa el numero de filas afectadas
            if(rows >= 1){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    id = rs.getInt(1);
                }
                libro = new Libro(id, nombre, autor, isbn, editorial);
            }
            con.close();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return libro;
    
    }

    public Libro findLibroByIsbn(String isbn) {
      Connection con = getConnection();
      Libro libro = null;
      try {
          PreparedStatement ps;
          ps = con.prepareStatement("SELECT * FROM libros WHERE isbn = ?");
          ps.setString(1, isbn);
          ResultSet rs = ps.executeQuery();
          if(rs.next()) {
              libro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
          }
          con.close();
          ps.close();
      }
      catch(Exception e) {
          System.out.println(e);
      }
      return libro;
  }

    @Override
    public Libro obtenerLibro(int id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'obtenerLibro'");
    }

    @Override
    public boolean modificarLibro(Libro libro) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'modificarLibro'");
    }

    @Override
    public void borrarLibro(String isbn) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'borrarLibro'");
    }

    @Override
    public List<Libro> obtenerAllLibros() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'obtenerAllLibros'");
    }
}
