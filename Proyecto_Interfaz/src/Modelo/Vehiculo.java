package Modelo;

public class Vehiculo {

    private String serial_vehiculo;
    private String modelo_vehiculo;
    private String marca;
    private int año; 
    private String tipoCombustible;
    private int numeroPuertas;
    private boolean aireAcondicionado;
    private boolean vidriosElectricos;
    private String tipoVehiculo;

    public Vehiculo() {
        this.serial_vehiculo = "";
        this.modelo_vehiculo = "";
        this.marca = "";
        this.año = 0;
        this.tipoCombustible = "";
        this.numeroPuertas = 0;
        this.aireAcondicionado = false;
        this.vidriosElectricos = false;
        this.tipoVehiculo = "";
    }

    public Vehiculo(String serial, String modelo, String marca, int año, String tipoCombustible,
                    int numeroPuertas, boolean aireAcondicionado, boolean vidriosElectricos, String tipoVehiculo) {
        this.serial_vehiculo = serial;
        this.modelo_vehiculo = modelo;
        this.marca = marca;
        this.año = año;  
        this.tipoCombustible = tipoCombustible;
        this.numeroPuertas = numeroPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.vidriosElectricos = vidriosElectricos;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getSerial() {
        return serial_vehiculo;
    }

    public void setSerial(String serial_vehiculo) {
        this.serial_vehiculo = serial_vehiculo;
    }

    public String getModelo() {
        return modelo_vehiculo;
    }

    public void setModelo(String modelo_vehiculo) {
        this.modelo_vehiculo = modelo_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAño() {
        return año;  
    }

    public void setAño(int año) {
        this.año = año;  
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isVidriosElectricos() {
        return vidriosElectricos;
    }

    public void setVidriosElectricos(boolean vidriosElectricos) {
        this.vidriosElectricos = vidriosElectricos;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void mostrarInfo() {
        System.out.println("SERIAL: " + serial_vehiculo);
        System.out.println("MODELO: " + modelo_vehiculo);
        System.out.println("MARCA: " + marca);
        System.out.println("AÑO: " + año);
        System.out.println("COMBUSTIBLE: " + tipoCombustible);
        System.out.println("PUERTAS: " + numeroPuertas);
        System.out.println("AIRE ACONDICIONADO: " + (aireAcondicionado ? "Sí" : "No"));
        System.out.println("VIDRIOS ELÉCTRICOS: " + (vidriosElectricos ? "Sí" : "No"));
        System.out.println("TIPO DE VEHÍCULO: " + tipoVehiculo);
    }

    public String toString() {
        return "Serial: " + serial_vehiculo +
               "\nModelo: " + modelo_vehiculo +
               "\nMarca: " + marca +
               "\nAño: " + año +
               "\nTipo de combustible: " + tipoCombustible +
               "\nNúmero de puertas: " + numeroPuertas +
               "\nAire acondicionado: " + (aireAcondicionado ? "Sí" : "No") +
               "\nVidrios eléctricos: " + (vidriosElectricos ? "Sí" : "No") +
               "\nTipo de vehículo: " + tipoVehiculo;
    }
}

