public class CuentaAhorro extends CuentaBancaria {
    //atributo adicional
    String fechaApertura;

    //constructor
    public CuentaAhorro(String numeroCuenta,String titular,double saldoInicial, String fechaApertura){
    super(numeroCuenta,titular,saldoInicial,2.5);
    this.fechaApertura=fechaApertura;

    if(saldoInicial<10000){
        throw new IllegalArgumentException("El saldo mínímo es insuficiente. Retiro minimo: $10.000");
    }
    }
    //sobreescritura metodo reitrar
    @Override
    public void retirar(double monto){
        if(saldo<monto){
                    System.out.println("Saldo insuficiente. Está intentando retirar: $"+monto);
                    System.out.println("Y su saldo actual es: $"+saldo);
        }else {
            saldo=saldo-monto;
            System.out.println("Retiro exitoso, su nuevo saldo es: $"+String.format("%.2f", saldo));
        }
    }

    //sobrescritura mostrar info
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Fecha apertura: "+fechaApertura);
    }

}




