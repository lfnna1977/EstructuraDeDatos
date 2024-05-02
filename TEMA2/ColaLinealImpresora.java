/*
 * 2da forma de realizar la tarea de cola de impresión es la herencia
 * Se crea una nueva clase pero la misma de extiende de la clase ColaLineal
 * heredando todos sus atributos y métodos, solo añadiendo a la actual
 * clase los nuevos métodos que se piden.
 */

public class ColaLinealImpresora extends ColaLineal {
    /*
     * Atributos
     * No tiene atributos esta clase, se heredan de la clase super
     * en este caso de la clase ColaLineal  
     */
     TrabajoImpresion trabajo;

    /*
     * Constructor
     * Si no se ha definido un método constructor para la clase,
     * entonces el objeto se instancia indicando el nombre de la clase
     * y a continuación un paréntesis abierto y otro cerrado.
     * Ejemplo: ColaLinealImpresora cola = new ColaLinealImpresora();
     */

    public ColaLinealImpresora(){

    }

    // Métodos

    // Método para insertar un trabajo de impresión
    public void encolarTrabajo(String fichero, String usuario) throws Exception{        
        this.trabajo = new TrabajoImpresion(fichero, usuario);        
        super.encolar(trabajo);
    }

    // Clase interna para representar un trabajo de impresión
    private class TrabajoImpresion {
        // Atributos
        private String nombreFichero;
        private String nombreUsuario;

        // Constructor
        public TrabajoImpresion(String nombreFichero, String nombreUsuario) {
            this.nombreFichero = nombreFichero;
            this.nombreUsuario = nombreUsuario;
        }
    
        // Método toString para imprimir los detalles de la clase
        @Override
        public String toString() {
            return "{" +
                    "Fichero: '" + nombreFichero + '\'' +
                    ", Usuario: '" + nombreUsuario + '\'' +
                    '}';
        }
    }
}
