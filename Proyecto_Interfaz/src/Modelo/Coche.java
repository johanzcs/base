package Modelo;

public class Coche extends Vehiculo {

    private int idCliente;

    public Coche() {
        super();
        setNumeroPuertas(4);
        setTipoVehiculo("Coche"); 
    }

    public Coche(String serial, String modelo, int numeroPuertas, int año, String marca,
                 String tipoCombustible, boolean aireAcondicionado, boolean vidriosElectricos,
                 String tipoVehiculo, int idCliente) {
        super(serial, modelo, marca, año, tipoCombustible, numeroPuertas, aireAcondicionado, vidriosElectricos, tipoVehiculo);
        this.idCliente = idCliente;
    }

    public Coche(String serial, String modelo, int numeroPuertas, int año, String marca,
                 String tipoCombustible, boolean aireAcondicionado, boolean vidriosElectricos,
                 String tipoVehiculo) {
        super(serial, modelo, marca, año, tipoCombustible, numeroPuertas, aireAcondicionado, vidriosElectricos, tipoVehiculo);
        this.idCliente = -1; 
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("ID Cliente: " + idCliente);
    }

    public String toString() {
        return super.toString() +
               "\nID Cliente: " + idCliente;
    }
}
