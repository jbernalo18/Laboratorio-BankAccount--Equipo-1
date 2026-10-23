public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String RUT){
        super(numeroCuenta, titular, saldoInicial, 1.5);

        if(saldoInicial < 100000){
            throw new IllegalArgumentException("El saldo minimo para abrir la cuenta es $100,000");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;

    }

    @Override
    public void retirar(double monto) {
        if (monto + comisionRetiro > getSaldo()) {
            System.out.println("Error: saldo insuficiente para retirar $" + monto
                    + " mas la comision de $" + comisionRetiro);
            return;
        }
        reducirSaldo(monto + comisionRetiro);
        System.out.println("Retiro exitoso");
        System.out.println("Comision por retiro: $" + comisionRetiro);
        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
    }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public String getRUT() { return RUT; }
    public double getComisionRetiro() { return comisionRetiro; }
}
