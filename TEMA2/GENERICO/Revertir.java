public class Revertir {
    public static String revertirCadena(String cadena) {
        Pila<Character> pila = new Pila<>();

        // Paso 1: Agregar cada carácter de la cadena a la pila
        for (char c : cadena.toCharArray()) {
            pila.push(c);
        }

        // Paso 2: Crear una nueva cadena extrayendo los caracteres de la pila en orden
        StringBuilder resultado = new StringBuilder();
        while (!pila.estaVacia()) {
            resultado.append(pila.pop());
        }
        
        return resultado.toString();
    }

    public static void main(String[] args) {
        String cadena = "amor";
        String cadenaRevertida = revertirCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena revertida: " + cadenaRevertida);
    }
}
