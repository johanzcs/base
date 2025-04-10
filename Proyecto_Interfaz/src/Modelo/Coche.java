
package Modelo;


public class Coche extends Vehiculo {
    private int numeroPuertas;

    public Coche() {
        super(); 
        this.numeroPuertas = 4;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
   

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Numero de puertas: " + numeroPuertas);
    }
}
