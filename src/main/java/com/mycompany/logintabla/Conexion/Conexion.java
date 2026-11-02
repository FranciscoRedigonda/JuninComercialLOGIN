package com.mycompany.logintabla.Conexion;
//Drivers importados necesarios para la bd 
import java.sql.Connection;  //Interfaz
import java.sql.DriverManager; //este es el que se encarga de los drivers
import java.sql.SQLException; //clase para errores en la bd

public class Conexion {
    
    // esto es para conectarse a la bd de la facultad en servidor remoto
    private static final String URL = "jdbc:mariadb://ies9021.edu.ar:3306/ies9021_SCS";
    private static final String USER = "ies9021_userdb";
    private static final String PASSWORD = "Xsw23edc.2025";

    public Connection getConexion() { 
        Connection con = null; //esto lo puse en null, y te devuelva algun valor si la conexion es exitosa
        try {
            //aca busca el driver que pusimos en pom
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            //si no lo llega a encontrar nos sale el error
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion no pudimos conectar" + e.getMessage());
        }
        //aca le puse un return, si llega a funcionar nos da la coneccion lista, sino devuelve el null porlotanto el error del cahc
        return con;
    }
}