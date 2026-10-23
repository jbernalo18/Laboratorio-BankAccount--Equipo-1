public class TestBanco {

    public static void main(String[] args) {

        // ============ PASO 1: Crear las Cuentas ============
        // El tipo es CuentaBancaria (el papa), pero el objeto es de la hija: eso es polimorfismo.
        CuentaBancaria cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaBancaria cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);
        CuentaBancaria cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000,
                "Tech Solutions", "123456789-0");
        CuentaBancaria cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");

        // ============ PASO 2: Informacion inicial ============
        titulo("PASO 2: INFORMACION INICIAL DE LAS CUENTAS");
        cuentaAna.mostrarInfo();
        separador();
        cuentaLuis.mostrarInfo();
        separador();
        cuentaTech.mostrarInfo();
        separador();
        cuentaMaria.mostrarInfo();

        // ============ PASO 3: Operaciones ============
        titulo("PASO 3: OPERACIONES");

        System.out.println(">> Ana Perez deposita $10,000.00");
        cuentaAna.depositar(10000);
        separador();

        System.out.println(">> Luis Gomez retira $25,000.00 (debe entrar en sobregiro)");
        cuentaLuis.retirar(25000);
        separador();

        System.out.println(">> Tech Solutions retira $10,000.00 (debe cobrar comision)");
        cuentaTech.retirar(10000);
        separador();

        System.out.println(">> Maria Lopez intenta retirar $20,000.00 (debe fallar)");
        cuentaMaria.retirar(20000);

        // ============ PASO 4: Intereses ============
        titulo("PASO 4: APLICACION DE INTERESES");
        cuentaAna.aplicarInteres();
        cuentaLuis.aplicarInteres();
        cuentaTech.aplicarInteres();
        cuentaMaria.aplicarInteres();

        // ============ PASO 5: Estado final ============
        titulo("PASO 5: ESTADO FINAL DE LAS CUENTAS");
        cuentaAna.mostrarInfo();
        separador();
        cuentaLuis.mostrarInfo();
        separador();
        cuentaTech.mostrarInfo();
        separador();
        cuentaMaria.mostrarInfo();

        // ============ PASO 6: Resumen ============
        titulo("PASO 6: RESUMEN GENERAL");

        int totalCuentas = 4;

        double saldoTotal = cuentaAna.getSaldo()
                + cuentaLuis.getSaldo()
                + cuentaTech.getSaldo()
                + cuentaMaria.getSaldo();

        double promedio = saldoTotal / totalCuentas;

        // Buscar la cuenta con mayor saldo
        // empezamos suponiendo que la primera es la mayor,
        // y solo cambiamos si la siguiente tiene MAS saldo.
        CuentaBancaria mayor = cuentaAna;
        if (cuentaLuis.getSaldo() > mayor.getSaldo()) {
            mayor = cuentaLuis;
        }
        if (cuentaTech.getSaldo() > mayor.getSaldo()) {
            mayor = cuentaTech;
        }
        if (cuentaMaria.getSaldo() > mayor.getSaldo()) {
            mayor = cuentaMaria;
        }

        System.out.println("Total de cuentas    : " + totalCuentas);
        System.out.println("Saldo total         : $" + String.format("%,.2f", saldoTotal));
        System.out.println("Promedio de saldo   : $" + String.format("%,.2f", promedio));
        System.out.println("Cuenta con mayor saldo:");
        System.out.println("   Numero de cuenta : " + mayor.getNumeroCuenta());
        System.out.println("   Titular          : " + mayor.getTitular());
        System.out.println("   Saldo            : $" + String.format("%,.2f", mayor.getSaldo()));
        System.out.println("==================================================");
    }

    /** Imprime un titulo grande para separar cada paso. */
    private static void titulo(String texto) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("  " + texto);
        System.out.println("==================================================");
    }

    /** Imprime una linea delgada para separar cuentas u operaciones. */
    private static void separador() {
        System.out.println("--------------------------------------------------");
    }
}