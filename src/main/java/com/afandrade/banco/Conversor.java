package com.afandrade.banco;

import java.math.BigDecimal;
import java.util.Scanner;

/*
Programa que pida por pantalla introducir una cantidad en euros y devuelva la conversion en USD
El Mensaje con el resultado sera: *** euros equivalen a *** US dolares.
 */
public class Conversor {
    public static void main(String[] args) {

        System.out.println("Bienvenido al conversor de moneda");
        System.out.println("Por favor Introduzca una cantidad en Euros y el programa le devolvera la conversión en USD");

        Scanner scanner = new Scanner(System.in);
        double euros = scanner.nextDouble();

        double dolares = 1.09 * euros;

        System.out.println(euros + " euros equivalen a " + dolares + " USD");

        String euroString = Double.toString(euros);
        BigDecimal eurosBigDecimal = new BigDecimal(euroString);
        double tasaDeCambio = 1.09;
        String tasaDeCambioString = Double.toString(tasaDeCambio);
        BigDecimal tasaDeCambioBigDecimal = new BigDecimal(tasaDeCambioString);

        BigDecimal dolaresBigDecimal = eurosBigDecimal.multiply(tasaDeCambioBigDecimal);

        System.out.println(euros + " euros equivalen a " + dolaresBigDecimal.toString() + " USD");

    }
}
