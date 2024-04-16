/* Este programa calcula el perímetro de una circunferencia */

public class PerimetroCircunferencia {
    public static void main(String[] args) {
        // Declaración de PI y la varaibles radio y perimetro
        final double PI = 3.1415926536;
        double radio = 25.0, perimetro;

        perimetro = 2.0*PI*radio;
        System.out.print("El perimetro de la circunferencia de radio ");
        System.out.print(radio);
        System.out.print(" es ");
        System.out.println(perimetro);
    }    
}
