public class CuentaCorriente extends CuentaBancaria {

    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    // Constructor principal
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    // Constructor secundario (valores por defecto)
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000, 5.0);
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getPorcentajeComisionSobregiro() {
        return porcentajeComisionSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser positivo.");
            return;
        }
        if (monto > getSaldo() + limiteSobregiro) {
            System.out.println("Error: saldo insuficiente. Supera el limite de sobregiro.");
            return;
        }

        reducirSaldo(monto);
        System.out.println("Retiro exitoso");

        if (getSaldo() < 0) {
            double montoSobregirado = -getSaldo();
            double comision = montoSobregirado * porcentajeComisionSobregiro / 100;
            reducirSaldo(comision);
            System.out.printf("Comision por sobregiro: $%.2f%n", comision);
        }

        System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Limite de sobregiro: $%.2f%n", limiteSobregiro);
        System.out.printf("Comision por sobregiro: %.2f%%%n", porcentajeComisionSobregiro);
    }
}
