
package Modelo;

public class Vehiculo{
private String Serial_vehiculo;
private String Modelo_vehiculo;

public  Vehiculo() {
   this.Modelo_vehiculo="";
   this.Serial_vehiculo="";
}
public String getSerial_vehiculo(){
return Serial_vehiculo;
}
public void setSerial_vehiculo (String Serial_vehiculo){
this.Serial_vehiculo = Serial_vehiculo;
}
public String getModelo_vehiculo(){
return Modelo_vehiculo;
}
public void setModelo_vehiculo (String Modelo_vehiculo){
this.Modelo_vehiculo = Modelo_vehiculo;
}
 public void mostrarInfo(){
    System.out.println("SERiAL    " + Serial_vehiculo +      "\nMODELO       " + Modelo_vehiculo);  
}
}
