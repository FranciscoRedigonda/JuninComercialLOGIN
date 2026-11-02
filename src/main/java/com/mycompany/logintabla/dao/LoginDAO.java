package com.mycompany.logintabla.dao;

// conexion a la base de datos con importaciones
import com.mycompany.logintabla.Conexion.Conexion; 
import com.mycompany.logintabla.modelo.LoginModel;
//para hablar con la bd
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; //para los errores

//cree este metodo que busca un usuario en la base de datos con el nombre y contraseña ya cargados.
public class LoginDAO {

    public LoginModel autenticar(String name, String password) {
        
        LoginModel usuarioLogueado = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
//todas las variables en null, por si no llega a encontrar nada q lo tire
//sentencia sql
        String sql = "SELECT * FROM login WHERE name = ? AND password = ?";

        try {
            // 1.clase Conexion y le pedimos el puente abierto hacia internet
            Conexion conexion = new Conexion();
            con = conexion.getConexion();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
            //esto hace que se prepara la consulta y el driver envia el esqueleto sql al del servidor.
            ps = con.prepareStatement(sql);
            // se sustituyen los "?" en orden 1 al 2
            //es mas seguro
            ps.setString(1, name);
            ps.setString(2, password);
            
            //aca nos devuelve los resultados a Resulset "rs"
            rs = ps.executeQuery();

            //aca si nos devuelve el "true" significa q es correcto y nos devuelve a la fila 1
            if (rs.next()) {
                
                usuarioLogueado = new LoginModel();//aca cree el objeto molde para pasar los datos de la bd a java.
                //aca tomamos la columna de slq y los guardamos en el atributo de java
                usuarioLogueado.setId_login(rs.getInt("id_login"));
                usuarioLogueado.setName(rs.getString("name"));
                usuarioLogueado.setPassword(rs.getString("password"));
                usuarioLogueado.setUser_type(rs.getString("user_type"));
            }
        } catch (SQLException e) {
            //esto es si llega a fallar el servidor de nuestra facultad va a fallar y el error se queda aca
            System.err.println("Error en la consulta DAO: " + e.getMessage());
        } finally {
            //este siempre se ejecuta haya o no algun tipo de error, para no dejar conexiones "vivas" o muertas en el servidor, recomendacion de la ia
            try {
                //esto es para cerrar de atras para adelante, chequeando que no sea "null"
                if (rs != null) rs.close(); 
                if (ps != null) ps.close();
                if (con != null) con.close();
                
            } catch (SQLException e) {
                //si devuelve algo null nos va a tirar el error delc ahch
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
        //aca retornamos si entra al "if" se llena con los datos, sino el null en donde nos tiraria el error.
        return usuarioLogueado;
    }
}