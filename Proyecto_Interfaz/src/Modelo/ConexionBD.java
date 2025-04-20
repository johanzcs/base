
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConexionBD {
   //creando atributos de la clase 
    String usuario;
    String url;
    String clave;
    Connection conex;//la magia
    //crear el constructor
    public ConexionBD(){
        usuario = "root";
        url="jdbc:mysql://localhost:3306/coches_coches";
        clave="";
        conex =null;
        
        
    }
    public void hacerConexion() throws SQLException{
        try{
            conex=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Dato conexion:" + conex.toString());
        }catch(SQLException e){
            System.out.println("ERROR: " + e);
            
        }
    }
     public Connection obtenerConexion() {
        if (conex == null) {
            try {
                hacerConexion();
            } catch (SQLException e) {
                System.out.println("Error al obtener conexión: " + e.getMessage());
            }
        }
        return conex;
    }
   public void hacerConsulta() throws SQLException {
    String textoSql = "SELECT * FROM vehiculos";
    Statement consulta_sentencia = this.conex.createStatement();
    ResultSet resultado_sentencia = consulta_sentencia.executeQuery(textoSql);

    while (resultado_sentencia.next()) {
        System.out.println("Placa: " + resultado_sentencia.getString("placa"));
    }
}
   
}
