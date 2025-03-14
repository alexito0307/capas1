package com.anahuac.desarrollo.capas.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.anahuac.desarrollo.capas.entidades.Libro;

public class DAOLibroSqlite implements IDAOLibro{

    public Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:sqlite:/Users/alexi/OneDrive/Desktop/Folders/Semestre6/Ingenieria de Software/librosdb.db";
            con = DriverManager.getConnection(url);
        } catch(Exception e) {
            System.out.println("Exception at connection: " + e());
            }
        return con;
    }

    public Libro createLibro(String nombre, String autor, String isbn, String editorial) {
        Connection con = getConnection();
        int id = -1;
        Libro libro = null
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO libro (nombre, autor, isbn, editorial) VALUES (?, ?, ?, ?)"); //Cuando tenemos valores de tipo cadena que pueden tener /'s y eso, se usa el ? para reemplazarlo directamente a la variable
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
            System.out.println("Error: " + e.printStackTrace());
        }
        return libro;
    }

    public Libro findByISBN(String isbn) {
        Connection con = getConnection();
        Libro libro = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM libro WHERE isbn = ?");
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                libro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            con.close();
            ps.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.printStackTrace());
        }
        return libro;
    }
}