/*
 * Clase Vehiculo
 */

public class Vehiculo {
    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    // el método constructor de la clase Vehiculo
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }

    // Metodos
    public String getMatricula() {
        return this.matricula;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getColor() {
        return this.color;
    }
    public double getTarifa() {
        return this.tarifa;
    }
    public boolean getDisponible() {
        return this.disponible;
    }
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método main para probar la clase TarjetaCredito
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        System.out.println("Matricula: " + vehiculo1.getMatricula());
        System.out.println("Marca y modelo: " + vehiculo1.getMarca() + " " + vehiculo1.getModelo());
        System.out.println("Color: " + vehiculo1.getColor());
        System.out.println("Tarifa: " + vehiculo1.getTarifa());        
        //Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", "Negro", 80.0);        
    }    
}
