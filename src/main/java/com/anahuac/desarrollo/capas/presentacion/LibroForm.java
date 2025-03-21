package com.anahuac.desarrollo.capas.presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.anahuac.desarrollo.capas.daos.DAOLibroMySQL;
import com.anahuac.desarrollo.capas.daos.DAOLibroSqlite;
import com.anahuac.desarrollo.capas.daos.IDAOLibro;
import com.anahuac.desarrollo.capas.entidades.Libro;
import com.anahuac.desarrollo.capas.logica.ServicioLibros;

public class LibroForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton b1, b2;  
    JPanel newPanel;  
    JLabel nombreLabel, autorLabel, isbnLabel, editorialLabel;  
    final JTextField  nombreTxt, autorTxt, isbnTxt, editorialTxt;  
      
    //calling constructor  
    public LibroForm()  
    {     
          
        //create label for username   
        nombreLabel = new JLabel();  
        nombreLabel.setText("Nombre");      //set label value for textField1  
        //create text field to get username from the user  
        nombreTxt = new JTextField(15);    //set length of the text  
        
        autorLabel = new JLabel();  
        autorLabel.setText("Autor");     
        autorTxt = new JTextField(15);  

        isbnLabel = new JLabel();  
        isbnLabel.setText("ISBN");      
        isbnTxt = new JTextField(15);  

        editorialLabel = new JLabel();  
        editorialLabel.setText("Editorial");      
        editorialTxt = new JTextField(15);
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
        b2 = new JButton("CANCEL");
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(5, 2));  
        newPanel.add(nombreLabel);    //set username label to panel  
        newPanel.add(nombreTxt);   //set text field to panel  
        newPanel.add(autorLabel);    //set password label to panel  
        newPanel.add(autorTxt);   //set text field to panel  
        newPanel.add(isbnLabel);
        newPanel.add(isbnTxt);
        newPanel.add(editorialLabel);
        newPanel.add(editorialTxt);
        newPanel.add(b1);           //set button to panel  
        newPanel.add(b2);
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        IDAOLibro daoLibro = new DAOLibroMySQL();
        ServicioLibros servicio = new ServicioLibros(daoLibro);
        Libro l = servicio.agregarLibro(isbnTxt.getText(), nombreTxt.getText(), autorTxt.getText(), editorialTxt.getText());
        // String userValue = textField1.getText();        //get user entered username from the textField1  
        // String passValue = textField2.getText();        //get user entered pasword from the textField2  
        // String userValue = textField1.getText();        //get user entered username from the textField1  
        // String passValue = textField2.getText();        //get user entered pasword from the textField2  
        
        // DAOLibroSqlite dao = new DAOLibroSqlite();
        // ServicioLibros servicio = new ServicioLibros(dao);
        
        
        // //check whether the credentials are authentic or not  
        // if (servicio.login(userValue, passValue)) {  //if authentic, navigate user to a new page  
              
        //     //create instance of the NewPage  
        //     NewPage page = new NewPage();  
              
        //     //make page visible to the user  
        //     page.setVisible(true);  
              
        //     //create a welcome label and set it to the new page  
        //     JLabel wel_label = new JLabel("Welcome: "+userValue);  
        //     page.getContentPane().add(wel_label);  
        // }  
        // else{  
        //     //show error message  
        //     System.out.println("Please enter valid username and password");  
        // }  
    }

	 
}  
