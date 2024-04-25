public class Parentesis {

    public static boolean balanceParentesis(String secuencia) {
        PilaArrayList<Character> pila = new PilaArrayList<>();

        for (char caracter : secuencia.toCharArray()) {
            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                // Verificamos si la pila está vacía o si el elemento superior de la pila no coincide con '('
                if (pila.estaVacia() || pila.pop() != '(') {
                    return false; // Si no está balanceado, retornamos false
                }
            }
        }

        // Al finalizar, la pila debe estar vacía para que la secuencia esté balanceada
        return pila.estaVacia();
    }

    public static void main(String[] args) {
        String secuencia1 = "()()()";
        String secuencia2 = "(()()())";
        String secuencia3 = "(()))(";
        String secuencia4 = "())(";

        System.out.println(secuencia1 + " ¿está balanceada?: " + balanceParentesis(secuencia1));
        System.out.println(secuencia2 + " ¿está balanceada?: " + balanceParentesis(secuencia2));
        System.out.println(secuencia3 + " ¿está balanceada?: " + balanceParentesis(secuencia3));
        System.out.println(secuencia4 + " ¿está balanceada?: " + balanceParentesis(secuencia4));
    }
}
