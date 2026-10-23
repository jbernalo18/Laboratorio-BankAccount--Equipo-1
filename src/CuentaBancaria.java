public abstract class CuentaBancaria {

    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if (saldoInicial < 0) {
            System.out.println("El saldo no puede ser negativo.");
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }

        if (tasaInteres < 0) {
            System.out.println("La tasa de interes no puede ser negativo.");
            this.tasaInteres = 0;
        } else {
            this.tasaInteres = tasaInteres;
        }

    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.printf("Deposito de $%.2f. Nuevo saldo: $%.2f%n", monto, this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    public abstract void retirar(double monto);

    public void aplicarInteres() {
        double interesGenerado = this.saldo * (this.tasaInteres / 100);
        this.saldo += interesGenerado;
        System.out.printf("Cuenta %s - Interes generado: $%.2f. Nuevo saldo: $%.2f%n",
                this.numeroCuenta, interesGenerado, this.saldo);
    }

    public void mostrarInfo() {
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo actual: $%.2f%n", saldo);
        System.out.printf("Tasa de interes: %.2f%% anual%n", tasaInteres);
    }

}
