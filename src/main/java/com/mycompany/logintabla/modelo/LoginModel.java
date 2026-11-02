package com.mycompany.logintabla.modelo;

public class LoginModel {
    //esta clase hace que copien exactamente las columnas de la tabla login
    private int id_login; //usamos el private para la seguridad, el id es unico y nadie debe tocar, y tambien evitamos que cualq clase externa altere accidentalente el identificador unico del usuario. recomendacion de la ia
    private String name; 
    private String password;
    private String user_type;
//aca tenemos un constructor vacio para que java sepa como instanciar el objeto en memoria antes de que tenga algun tipo de dato adentro
    public LoginModel() {}

    public int getId_login() { return id_login; } //retornamos el id actual
    public void setId_login(int id_login) { this.id_login = id_login; } //esto nos asigna lo recibido al atributo de la clsae

    public String getName() { return name; } //aca nos permite a la interfaz leer elnombre para mostrar el "saludo"
    public void setName(String name) { this.name = name; } //aca el dao nos guarda el nombre recuperado de la bd

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUser_type() { return user_type; }
    public void setUser_type(String user_type) { this.user_type = user_type; }
}