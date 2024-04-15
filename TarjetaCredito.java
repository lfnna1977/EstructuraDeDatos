public class TarjetaCredito {
    private String numero;
    private String titular;
    private String fechaExpiracion;
    private int cvv;
    private double limiteCredito;
    private double saldoDisponible;

    public TarjetaCredito(String numero, String titular, String fechaExpiracion, int cvv, double limiteCredito) {
        this.numero = numero;
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
        this.limiteCredito = limiteCredito;
        this.saldoDisponible = limiteCredito; // Al principio, el saldo disponible es igual al límite de crédito
    }

    // Métodos para realizar transacciones
    public void realizarCompra(double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible -= monto;
            System.out.println("Compra realizada con éxito. Saldo disponible: " + saldoDisponible);
        } else {
            System.out.println("Fondos insuficientes para realizar la compra.");
        }
    }

    public void realizarPago(double monto) {
        saldoDisponible += monto;
        System.out.println("Pago realizado con éxito. Saldo disponible: " + saldoDisponible);
    }

    // Getters y setters
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public int getCvv() {
        return cvv;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    // Método toString para imprimir los detalles de la tarjeta
    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", cvv=" + cvv +
                ", limiteCredito=" + limiteCredito +
                ", saldoDisponible=" + saldoDisponible +
                '}';
    }

    // Método main para probar la clase TarjetaCredito
    public static void main(String[] args) {
        TarjetaCredito tarjeta = new TarjetaCredito("1234 5678 9012 3456", "Juan Perez", "12/25", 123, 1000.0);

        System.out.println("Detalles de la tarjeta:");
        System.out.println(tarjeta);

        tarjeta.realizarCompra(500.0);
        tarjeta.realizarCompra(700.0);
        tarjeta.realizarPago(200.0);
    }
}
