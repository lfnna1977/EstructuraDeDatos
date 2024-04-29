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

    // Getters y setters
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

    // Método toString para imprimir los detalles de la tarjeta
    @Override
    public String toString() {
        return "Vehiculo{" +
                "Matricula: " + matricula + 
                ", Marca: " + marca + 
                ", Modelo: " + modelo + 
                ", Molor: " + color +
                ", Tarifa: " + tarifa +
                ", Disponible: " + disponible +
                '}';
    }

    // Método main para probar la clase Vehiculo
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        System.out.println(vehiculo);

        System.out.println("Matricula: " + vehiculo.getMatricula());
        System.out.println("Marca y modelo: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        System.out.println("Color: " + vehiculo.getColor());
        System.out.println("Tarifa: " + vehiculo.getTarifa());        
    }
}
