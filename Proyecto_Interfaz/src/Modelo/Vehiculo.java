package Modelo;

public class Vehiculo {
    private String Serial_vehiculo;
    private String Modelo_vehiculo;
    private String Marca;
    private String año;
    private String TipoCombustible;
    private boolean AireAcondicionado;
    private boolean VidriosElectricos;

    // Constructor vacío (el que ya tenías)
    public Vehiculo() {
        this.Serial_vehiculo = "";
        this.Modelo_vehiculo = "";
        this.Marca = "";
        this.año = "";
        this.TipoCombustible = "";
        this.AireAcondicionado = false;
        this.VidriosElectricos = false;
    }

    // Nuevo constructor con todos los campos
    public Vehiculo(String Sereal, String Modelo, String Marca, String año, String tipoCombustible, boolean AireAcondicionado, boolean VidriosElectricos) {
        this.Serial_vehiculo = Sereal;
        this.Modelo_vehiculo = Modelo;
        this.Marca = Marca;
        this.año = año;
        this.TipoCombustible = tipoCombustible;
        this.AireAcondicionado = AireAcondicionado;
        this.VidriosElectricos = VidriosElectricos;
    }

    // Getters y setters
    public String getSerial_vehiculo() {
        return Serial_vehiculo;
    }

    public void setSerial_vehiculo(String Sereal_vehiculo) {
        this.Serial_vehiculo = Sereal_vehiculo;
    }

    public String getModelo_vehiculo() {
        return Modelo_vehiculo;
    }

    public void setModelo_vehiculo(String Modelo_vehiculo) {
        this.Modelo_vehiculo = Modelo_vehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getaño() {
        return año;
    }

    public void setAnio(String año) {
        this.año = año;
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(String TipoCombustible) {
        this.TipoCombustible = TipoCombustible;
    }

    public boolean isAireAcondicionado() {
        return AireAcondicionado;
    }

    public void setAireAcondicionado(boolean AireAcondicionado) {
        this.AireAcondicionado = AireAcondicionado;
    }

    public boolean isVidriosElectricos() {
        return VidriosElectricos;
    }

    public void setVidriosElectricos(boolean VidriosElectricos) {
        this.VidriosElectricos = VidriosElectricos;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("SERIAL: " + Serial_vehiculo);
        System.out.println("MODELO: " + Modelo_vehiculo);
        System.out.println("MARCA: " + Marca);
        System.out.println("AÑO: " + año);
        System.out.println("COMBUSTIBLE: " + TipoCombustible);
        System.out.println("AIRE ACONDICIONADO: " + (AireAcondicionado ? "Sí" : "No"));
        System.out.println("VIDRIOS ELÉCTRICOS: " + (VidriosElectricos ? "Sí" : "No"));
    }
}
