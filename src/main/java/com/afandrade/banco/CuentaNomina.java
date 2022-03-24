package com.afandrade.banco;

public class CuentaNomina extends CuentaBancaria{

    public CuentaNomina(String titular, TipoDeCuenta tipo, double saldo) {
        super(titular, tipo, saldo);
    }

    public CuentaNomina(String titular, double saldo) {

        super(titular, saldo);
    }

    public CuentaNomina() {

        super();
    }

    @Override
    public void informarSobreCondicionesLegales() {
        System.out.println("Condiones legales de la cuenta de Nomina del banco ***");
        System.out.println("Segun el acuerdo firmado por usted ***");
        System.out.println("Mientras mantenga las condiciones de su cuenta, usted no tendra comision sobre las transacciones");
    }
}
