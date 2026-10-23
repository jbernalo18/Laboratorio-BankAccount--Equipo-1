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
        if (monto > saldo + limiteSobregiro) {
            System.out.println("Error: saldo insuficiente. Supera el limite de sobregiro.");
            return;
        }

        saldo = saldo - monto;
        System.out.println("Retiro exitoso");

        if (saldo < 0) {
            double montoSobregirado = -saldo;
            double comision = montoSobregirado * porcentajeComisionSobregiro / 100;
            saldo = saldo - comision;
            System.out.printf("Comision por sobregiro: $%.2f%n", comision);
        }

        System.out.printf("Nuevo saldo: $%.2f%n", saldo);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Limite de sobregiro: $%.2f%n", limiteSobregiro);
        System.out.printf("Comision por sobregiro: %.2f%%%n", porcentajeComisionSobregiro);
    }
}
