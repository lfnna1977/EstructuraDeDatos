public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Probando clase Vehiculo
         */
        // Declaramos e instanciamos la clase Vehiculo
        Vehiculo susukiAlto = new Vehiculo("XYZ 123", "Susuki", "Alto", "Celeste", 5.00);
        // Mostrar el contenido de la clase Vehiculo
        System.out.println(susukiAlto);
        // Declaramos e instanciamos la clase Vehiculo
        Vehiculo volkswagen = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        // Mostrar el contenido de la clase Vehiculo
        System.out.println(volkswagen);

        /*
         * Probando clase TarjetaCredito
         */        
        TarjetaCredito bancoUnion = new TarjetaCredito("1234 5678 9012 3456", "Juan Perez", "12/25", 123, 1000.0);

        System.out.println("Detalles de la tarjeta:");
        System.out.println(bancoUnion);

        bancoUnion.realizarCompra(500.0);
        bancoUnion.realizarCompra(700.0);
        bancoUnion.realizarPago(200);
    }
}
