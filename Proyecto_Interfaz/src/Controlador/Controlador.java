
package Controlador;

import Modelo.Vehiculo;
import Modelo.Usuario;

import Vista.Formulario_Registro_Vehiculo;
import Vista.Formulario_Registro_Cliente;
public class Controlador {
    private Vehiculo objVehiculo;
    private Formulario_Registro_Vehiculo objFormulario;
    private Usuario objUsuario;
    private Formulario_Registro_Cliente objFrmularios;
    
    
    public Controlador(){
        this.objVehiculo = new Vehiculo ();
        this.objFormulario = new Formulario_Registro_Vehiculo();
        this.objUsuario = new Usuario ();
        this.objFrmularios = new Formulario_Registro_Cliente();
    }
}
