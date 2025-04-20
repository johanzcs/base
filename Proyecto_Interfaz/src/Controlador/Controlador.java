package Controlador;

import Modelo.Vehiculo;
import Modelo.Usuario;
import Vista.Formulario_Registro_Vehiculo;
import Vista.Formulario_Registro_Cliente;
import Modelo.Coche;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.ConexionBD; // Asegúrate de tener esta clase para manejar la conexión

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
            System.out.println("Vehículo recibido por el controlador:");
            System.out.println(vehiculo.toString());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo: " + e.getMessage());
            return false;
        }
    }

   public boolean registrarUsuario(Usuario usuario) {
    ConexionBD conexionBD = new ConexionBD(); // Crear instancia
    Connection conn = conexionBD.obtenerConexion(); // Obtener conexión

    String sql = "INSERT INTO clientes (nombre, apellido, cedula) VALUES (?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, usuario.getNombre_Cliente());
        stmt.setString(2, usuario.getApellido_Cliente());
        stmt.setString(3, usuario.getCedula_Cliente());
        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e.getMessage());
        return false;
    }
}
// Método para registrar cliente y actualizar tabla y lista
public boolean registrarUsuarioYActualizarVista(Usuario usuario, JTable tablaClientes, DefaultListModel<String> modeloLista) {
    ConexionBD conexionBD = new ConexionBD();
    Connection conn = conexionBD.obtenerConexion();

    String sql = "INSERT INTO clientes (nombre, apellido, cedula) VALUES (?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, usuario.getNombre_Cliente());
        stmt.setString(2, usuario.getApellido_Cliente());
        stmt.setString(3, usuario.getCedula_Cliente());
        stmt.executeUpdate();

        // Actualiza tabla y lista
        actualizarTablaClientes(tablaClientes);
        actualizarListaClientes(modeloLista);

        return true;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e.getMessage());
        return false;
    }
}

// Método para cargar los clientes a la tabla
public void actualizarTablaClientes(JTable tabla) {
    ConexionBD conexionBD = new ConexionBD();
    Connection conn = conexionBD.obtenerConexion();

    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("Cédula");

    String sql = "SELECT nombre, apellido, cedula FROM clientes";

    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Object[] fila = {
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("cedula")
            };
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar tabla: " + e.getMessage());
    }
}

// Método para llenar una lista (JList)
public void actualizarListaClientes(DefaultListModel<String> modeloLista) {
    ConexionBD conexionBD = new ConexionBD();
    Connection conn = conexionBD.obtenerConexion();

    modeloLista.clear();

    String sql = "SELECT nombre, apellido FROM clientes";

    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            String item = rs.getString("nombre") + " " + rs.getString("apellido");
            modeloLista.addElement(item);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar lista: " + e.getMessage());
    }
}
public boolean registrarVehiculo(Coche coche) {
    ConexionBD conexion = new ConexionBD();
    Connection conn = conexion.obtenerConexion();

    String sql = "INSERT INTO vehiculos (placa, modelo, marca, anio, tipo_combustible, aire_acondicionado, vidrios_electricos, numero_puertas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, coche.getSerial_vehiculo());
        ps.setString(2, coche.getModelo_vehiculo());
        ps.setString(3, coche.getMarca());
        ps.setString(4, coche.getaño());
        ps.setString(5, coche.getTipoCombustible());
        ps.setBoolean(6, coche.isAireAcondicionado());
        ps.setBoolean(7, coche.isVidriosElectricos());
        ps.setInt(8, coche.getNumeroPuertas());

        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error al guardar vehículo: " + e.getMessage());
        return false;
    }
}

}
