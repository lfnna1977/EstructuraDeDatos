public class NodoBinario {
    private int dato;
    private NodoBinario izquierda;
    private NodoBinario derecha;

    // Constructor
    public NodoBinario(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    // Getters y setters
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoBinario getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoBinario izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinario getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoBinario derecha) {
        this.derecha = derecha;
    }
}
