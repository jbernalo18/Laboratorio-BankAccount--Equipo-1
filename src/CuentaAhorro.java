public class CuentaAhorro extends CuentaBancaria {
    //atributo adicional
    String fechaApertura;

    //constructor
    public CuentaAhorro(String numeroCuenta,String titular,double saldoInicial,double tasaInteres, String fechaApertura){
    super(numeroCuenta,titular,saldoInicial,tasaInteres);
    this.fechaApertura=fechaApertura;
    }
    //sobreescritura metodo reitrar
    @Override
    public void retirar(double monto){
        if(saldo<monto){
            System.out.println("Saldo insuficiente");
        }else {
            saldo=saldo-monto;
            System.out.println("Retiro exitoso, su nuevo saldo es: "+ saldo);
        }
    }

    //sobrescritura mostrar info
    @Override
    public void mostrarInfo(){

    }

}
