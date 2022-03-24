package com.afandrade.mock;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
Clase que genera una lista de movimientos bancarios tipicos de forma aleatoria.

Esta clase tendra un unico metodo publico con dos parametros, uno de tipo int con el
numero de movimientos deseado y otro de tipo String en el que se le indicara el
tipo de moneda para los movimientos.

Los tipos de movimientos disponibles seran:

Transferencia -> "Transferencia de x moneda"

Ingreso -> "Ingreso de x moneda"

Retirada -> "Retirada de x moneda"

Pago con tarjeta -> "Pago con tarjeta de x moneda"

Nomina -> "Ingreso nomina de x moneda"

Pago recibo -> "Pago recibo de x moneda"

Se generara una lista con el numero de movimientos indicados por parametro en el que
cada movimiento sera de de uno de los anteriores tipos sleccionad de modo aleatorio
y en el que la cantidad de dinero sera un numero de tipo double aleatorio entre
1.0 y 3000.0
 */
public class GeneradorAleatorioDeMovimientos {

    private static final String TRANSFERENCIA = "Transferencia de ";
    private static final String INGRESO = "Ingreso de ";
    private static final String RETIRADA = "Retirada de ";
    private static final String PAGO_CON_TARJETA = "Pago con tarjeta de ";
    private static final String NOMINA = "Ingreso nomina de ";
    private static final String PAGO_RECIBO = "Pago recibo de ";

    public ArrayList<String> obtenerMovimientos(int numeroDeMovimientos, String moneda) {
        ArrayList<String> movimientos = new ArrayList<>();
        for (int i = 0; i < numeroDeMovimientos; i++) {
            int numeroDeMovimiento = obtenerIntAleatorio(1, 6);
            String tipoDeMovimiento;
            switch (numeroDeMovimiento) {
                case 1:
                    tipoDeMovimiento = TRANSFERENCIA;
                    break;
                case 2:
                    tipoDeMovimiento = INGRESO;
                    break;
                case 3:
                    tipoDeMovimiento = RETIRADA;
                    break;
                case 4:
                    tipoDeMovimiento = PAGO_CON_TARJETA;
                    break;
                case 5:
                    tipoDeMovimiento = NOMINA;
                default:
                    tipoDeMovimiento = PAGO_CON_TARJETA;
            }
            double cantidadAleatoria = obtenerDoubleAleatorio(1.0, 3000.0);
            String movimiento = tipoDeMovimiento + String.format("%.2f", cantidadAleatoria) + " " + moneda;
            movimientos.add(movimiento);
        }
        return movimientos;
    }

    private int obtenerIntAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    private double obtenerDoubleAleatorio(double minimo, double maximo) {
        return ThreadLocalRandom.current().nextDouble(minimo, maximo + 1.0);
    }
}
