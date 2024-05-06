import java.util.Scanner;

public class NavegadorConDosPilas {
    private Pila<String> historial;
    private Pila<String> retroceso;

    public NavegadorConDosPilas() {
        this.historial = new Pila<>();
        this.retroceso = new Pila<>();
    }

    public void visitar(String url) {
        historial.push(url);
        System.out.println("Visitando: " + url);
        retroceso.limpiar(); // Limpiar la pila de retroceso al visitar una nueva URL
    }

    public void retroceder() {
        if (historial.estaVacia()) {
            System.out.println("No hay historial de navegación.");
        } else {
            String urlActual = historial.pop();
            retroceso.push(urlActual);
            if (!historial.estaVacia()) {
                System.out.println("Retrocediendo a: " + historial.peek());
            }
        }
    }

    public void avanzar() {
        if (retroceso.estaVacia()) {
            System.out.println("No se puede avanzar.");
        } else {
            String urlAnterior = retroceso.pop();
            historial.push(urlAnterior);
            System.out.println("Avanzando a: " + urlAnterior);
        }
    }

    public static void main(String[] args) {
        NavegadorConDosPilas navegador = new NavegadorConDosPilas();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Ingrese la URL que desea visitar ('<' para retroceder, '>' para avanzar): ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("<")) {
                    navegador.retroceder();
                } else if (entrada.equalsIgnoreCase(">")) {
                    navegador.avanzar();
                } else {
                    navegador.visitar(entrada);
                }            
            }
        } finally {
            scanner.close();
        }        
    }
}
