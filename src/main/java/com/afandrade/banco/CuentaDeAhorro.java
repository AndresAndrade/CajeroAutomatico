package com.afandrade.banco;

public class CuentaDeAhorro extends CuentaBancaria{

    private final double COMISION = 0.12;

    public CuentaDeAhorro(String titular, TipoDeCuenta tipo, double saldo) {
        super(titular, tipo, saldo);
    }

    public CuentaDeAhorro(String titular, double saldo) {

        super(titular, saldo);
    }

    public CuentaDeAhorro() {

        super();
    }

    @Override
    public void sacarDinero(double cantidad) {
        if (cantidad < 0) {
            return;
        }
        saldo -= cantidad;
        saldo -= COMISION;
    }

    @Override
    public void informarSobreCondicionesLegales() {
        System.out.println("Condiones legales de la cuenta de Ahorro del banco ***");
        System.out.println("Segun el acuerdo firmado por usted ***");
        System.out.println("Las comisiones por retirada de dinero de su cuenta seran de " + COMISION + " euros");
    }
}
