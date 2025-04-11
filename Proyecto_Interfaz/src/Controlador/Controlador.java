
package Controlador;

import Modelo.Vehiculo;
import Modelo.Usuario;

import Vista.Formulario_Registro_Vehiculo;
import Vista.Formulario_Registro_Cliente;

import javax.swing.JOptionPane;

public class Controlador {

    private Vehiculo objVehiculo;
    private Usuario objUsuario;

    private Formulario_Registro_Vehiculo objFormularioVehiculo;
    private Formulario_Registro_Cliente objFormularioCliente;

    public Controlador() {
        this.objVehiculo = new Vehiculo();
        this.objUsuario = new Usuario();
        this.objFormularioVehiculo = new Formulario_Registro_Vehiculo();
        this.objFormularioCliente = new Formulario_Registro_Cliente();
    }

    // Método para registrar un vehículo
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        try {
            // Aquí puedes agregar validaciones adicionales si quieres
            // También puedes llamar a una clase DAO para guardar en MySQL
            System.out.println("Vehículo recibido por el controlador:");
            System.out.println(vehiculo.toString());

            // Simulación de guardado exitoso
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo: " + e.getMessage());
            return false;
        }
    }

    // Puedes agregar más métodos como registrarUsuario(), consultarVehiculo(), etc.

}

