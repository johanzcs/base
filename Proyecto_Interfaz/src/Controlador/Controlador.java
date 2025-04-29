package Controlador;

import Modelo.Vehiculo;
import Modelo.Usuario;
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
import Modelo.ConexionBD;

public class Controlador {

    private Vehiculo objVehiculo;
    private Usuario objUsuario;

    public Controlador() {
        this.objVehiculo = new Vehiculo();
    this.objUsuario = new Usuario();
    }

    private Connection obtenerConexion() {
        return new ConexionBD().obtenerConexion();
    }

    public boolean clienteExiste(String cedula) {
        String sql = "SELECT 1 FROM clientes WHERE cedula = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia: " + e.getMessage());
            return false;
        }
    }

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
        String sql = "INSERT INTO clientes (nombre, apellido, cedula) VALUES (?, ?, ?)";
        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
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
    
    public boolean registrarUsuarioYActualizarVista(Usuario usuario, JTable tablaClientes, DefaultListModel<String> modeloLista) {
        if (clienteExiste(usuario.getCedula_Cliente())) {
            JOptionPane.showMessageDialog(null, "El cliente ya está registrado.");
            return false;
        }

        if (registrarUsuario(usuario)) {
            actualizarTablaClientes(tablaClientes);
            actualizarListaClientes(modeloLista);
            return true;
        }

        return false;
    }

    public void actualizarTablaClientes(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cédula");

        String sql = "SELECT nombre, apellido, cedula FROM clientes";

        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    public void actualizarListaClientes(DefaultListModel<String> modeloLista) {
        modeloLista.clear();
        String sql = "SELECT nombre, apellido FROM clientes";

        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String item = rs.getString("nombre") + " " + rs.getString("apellido");
                modeloLista.addElement(item);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar lista: " + e.getMessage());
        }
    }

    public boolean actualizarCliente(String cedula, String nombre, String apellido) {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ? WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, cedula);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(String cedula) {
        String sql = "DELETE FROM clientes WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }

   public void registrarCoche(Coche coche) {
    if (!clienteExistePorId(coche.getIdCliente())) {
        JOptionPane.showMessageDialog(null, "El cliente con ID " + coche.getIdCliente() + " no existe.");
        return;
    }

    ConexionBD conexionBD = new ConexionBD();
    Connection conexion = conexionBD.obtenerConexion();

    String sql = "INSERT INTO vehiculos (placa, modelo, numero_puertas, año, marca, tipo_combustible, " +
                 "aire_acondicionado, vidrios_electricos, id_cliente_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, coche.getSerial());
        statement.setString(2, coche.getModelo());
        statement.setInt(3, coche.getNumeroPuertas());
        statement.setString(4, String.valueOf(coche.getAño()));
        statement.setString(5, coche.getMarca());
        statement.setString(6, coche.getTipoCombustible());
        statement.setBoolean(7, coche.isAireAcondicionado());
        statement.setBoolean(8, coche.isVidriosElectricos());
        statement.setInt(9, coche.getIdCliente());

        statement.executeUpdate();
        System.out.println("Coche registrado con éxito.");
    } catch (SQLException e) {
        System.err.println("Error al registrar el coche: " + e.getMessage());
    }
}
   
    public boolean clienteExistePorId(int idCliente) {
    String sql = "SELECT 1 FROM clientes WHERE id_cliente = ?";
    try (Connection conn = obtenerConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        return rs.next();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al verificar cliente por ID: " + e.getMessage());
        return false;
    }
}
   
public int obtenerIdClientePorCedula(String cedula) {
    int idCliente = -1;
    try {
        Connection conn = obtenerConexion();
        PreparedStatement ps = conn.prepareStatement("SELECT id_cliente FROM clientes WHERE cedula = ?"); 
        ps.setString(1, cedula);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idCliente = rs.getInt("id_cliente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return idCliente;
}


}


