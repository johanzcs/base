package Modelo;

public class Coche extends Vehiculo {
    private int numeroPuertas;

    public Coche() {
        super(); 
        this.numeroPuertas = 4;
    }

    public Coche(String Sereal, String Modelo, int numeroPuertas, String Marca, String año, String tipoCombustible, boolean AireAcondicionado, boolean VidriosElectricos) {
        super(Sereal, Modelo, Marca, año, tipoCombustible, AireAcondicionado, VidriosElectricos);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numeroPuertas);
    }

   
    public String toString() {
        return super.toString() + 
               "\nNúmero de puertas: " + numeroPuertas;
    }
}

