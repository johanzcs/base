
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
   //creando atributos de la clase 
    String usuario;
    String url;
    String clave;
    Connection conex;//la magia
    //crear el constructor
    public ConexionBD(){
        usuario = "root";
        url="jdbc:mysql://localhost:3306/tiendacarros";
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
    public void hacerConsulta() throws SQLException{
        String textoSql = "SELECT * FROM CARROS";
        Statement consulta_sentencia = this.conex.createStatement();
        ResultSet resultado_sentencia = consulta_sentencia.executeQuery(textoSql);
        System.out.println("Resultado: " + resultado_sentencia);
        resultado_sentencia.getString("nombre");
        
    }
  }

