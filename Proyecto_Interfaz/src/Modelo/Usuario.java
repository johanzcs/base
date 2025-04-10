
package Modelo;


public class Usuario {
    private String Nombre_Cliente;
    private String Apellido_Cliente;
    private String Cedula_Cliente;

public  Usuario() {
   this.Nombre_Cliente="";
   this.Apellido_Cliente="";
   this.Cedula_Cliente="";
}
public String getNombre_Cliente(){
return Nombre_Cliente;
}
public void setNombre_Cliente (String Nombre_Cliente){
this.Nombre_Cliente = Nombre_Cliente;
}
public String getApellido_Cliente(){
return Apellido_Cliente;
}
public void setApellido_Cliente (String Apellido_Cliente){
this.Apellido_Cliente = Apellido_Cliente;
}
public String getCedula_Cliente(){
return Cedula_Cliente;
}
public void setCedula_Cliente (String Cedula_Cliente){
this.Cedula_Cliente = Cedula_Cliente;
}

}