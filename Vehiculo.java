/*
 * Clase Vehiculo
 */

public class Vehiculo {
    public String matricula;
    public String marca;
    public String modelo;
    public String color;
    public double tarifa;
    public boolean disponible;

    // el método constructor de la clase Vehiculo
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }

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

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        System.out.println("Matricula: " + vehiculo1.matricula);
        System.out.println("Marca y modelo: " + vehiculo1.marca + " " + vehiculo1.modelo);
        System.out.println("Color: " + vehiculo1.color);
        System.out.println("Tarifa: " + vehiculo1.tarifa);
        Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", "Negro", 80.0);
        
    }    
}
