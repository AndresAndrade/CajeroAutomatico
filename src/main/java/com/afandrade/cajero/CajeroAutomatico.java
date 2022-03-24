package com.afandrade.cajero;

import com.afandrade.banco.CuentaBancaria;
import com.afandrade.banco.CuentaDeAhorro;
import com.afandrade.mock.GeneradorAleatorioDeMovimientos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
Clase que emula las funcionalidades de un cajero automatico.

La clase tendra una variable de instancia llamada cuentaBancariaActual de
tipo CuentaBancaria.

La clase tendra un constructor que tendra como prametros un String que identifica
al usuario y otro String que contiene una contraseña.

Como se trata de una emulación, en lugar de conectar con la base de datos del banco
para que nos devuelva la cuenta bancaria del usuario lo que vamos a hacer es crear
un objeto de la clase CuentaBancaria con un nombre cualquiera y un saldo aleatorio.

Esta clase tendra los siguientes metodos:

mostrarSaldo() -> Mostrara por pantalla el saldo cuentaBancariaActual.

ingresarDinero () -> Preguntara al usuario cuanto dinero quiere ingresar y lo
ingresara a cuentaBancaria.

sacarDiner() -> Preguntara al usuario cuanto dinero quiere sacar y lo sacara
de cuentaBancaria

consultarUltimosMoviemientos -> Este metodo de momento no hara nada.

salir() -> Dara las gracias al usuario por usar sus servicios.
 */
public class CajeroAutomatico {

    private CuentaBancaria cuentaBancariaActual;

    protected CajeroAutomatico (String identificador, String password) {
        double cantidadAleatoriaSaldo = ThreadLocalRandom.current().nextDouble(0, 50000);
        cuentaBancariaActual = new CuentaDeAhorro("Nombre cualquiera", cantidadAleatoriaSaldo);
    }

    protected void mostrarSaldo() {

        System.out.println("Su saldo es " + cuentaBancariaActual.obtenerSaldo());
    }

    protected void ingresarDinero() {
        System.out.println("Cuanto dinero quiere ingresar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.ingresarDinero(cantidad);
    }

    protected void sacarDinero() {
        System.out.println("Cuanto dinero quiere sacar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.sacarDinero(cantidad);
    }

    protected void consularUltimosMovimientos() {
        GeneradorAleatorioDeMovimientos generadorAleatorioDeMovimientos = new GeneradorAleatorioDeMovimientos();
        System.out.println("Cuantos movimientos quiere consultar?");
        Scanner scanner = new Scanner(System.in);
        int numeroDeMovimientos = scanner.nextInt();
        ArrayList<String> movimientos = generadorAleatorioDeMovimientos.obtenerMovimientos(numeroDeMovimientos, "euros");
        mostrarMovimientos(movimientos);
    }

    private void mostrarMovimientos(ArrayList<String> movimientos) {
        for (String movimiento: movimientos) {
            System.out.println(movimiento);
        }
    }

    protected void mostrarCondicionesLegales() {
        cuentaBancariaActual.informarSobreCondicionesLegales();
    }

    protected void salir() {

        System.out.println("Muchas gracias por utilizar nuestros servicios.");
    }

}
