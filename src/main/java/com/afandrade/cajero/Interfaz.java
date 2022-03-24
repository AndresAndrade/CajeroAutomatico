package com.afandrade.cajero;
/*
    Programa que emula la interfaz de un cajero automatico.

    El programa pedira al usuario su numero de identificacion.

    Una vez introducido pedira al usuario su contraseña.

    Tras esto el programa presentara las siguientes opciones al usuario:

    Elija una de las siguientes opciones:
        Escriba 1 para consultar su saldo.
        Escriba 2 para ingresar dinero.
        Escriba 3 para retirar dinero.
        Escriba 4 para consultar los ultimos movimientos.
    Para salir escriba cualquier otro numero
    Una vez escrita la opcion, pulse la tecla enter.

    Una vez el usuario ha elegido la opcion, el programa le mostrara por pantalla
    el numero correspondiente a la opcion elegida.

    Se creara un objeto de tipo cajero automatico y una vez el usuario ha elegido
    la opcion, se llamara al metodo correspondiente de este objeto.

 */

import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {

        System.out.println("Por favor introduzca su numero de identificacion.");
        Scanner scanner = new Scanner(System.in);
        String identificador = scanner.nextLine();
        System.out.println("Por favor introduzca su contraseña.");
        String contraseña = scanner.nextLine();
        CajeroAutomatico cajero = new CajeroAutomatico(identificador, contraseña);

        int opcion;

        do {

           System.out.println("Bienvenido a Bancolombia!\nPor favor seleccione una de las siguientes opciones:");
           System.out.println("    Escriba 1 para consultar su saldo.");
           System.out.println("    Escriba 2 para ingresar dinero.");
           System.out.println("    Escriba 3 para retirar dinero.");
           System.out.println("    Escriba 4 para consultar los ultimos movimientos.");
           System.out.println("    Escriba 5 para consultar los terminos legales");
           System.out.println("    Para salir escriba cualquier otro número");
           System.out.println("Una vez escrita la opcion, pulse la tecla enter.");

           opcion = scanner.nextInt();

          switch (opcion) {
              case 1:
                  cajero.mostrarSaldo();
                  break;
              case 2:
                  cajero.ingresarDinero();
                  break;
              case 3:
                  cajero.sacarDinero();
                  break;
              case 4:
                  cajero.consularUltimosMovimientos();
                  break;
              case 5:
                  cajero.mostrarCondicionesLegales();
                  break;
              default:
                  cajero.salir();
                  break;
          }
        } while (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5);



    }
}
