package com.mycompany.e1p1_lloydcooper;

import java.util.Scanner;

public class E1P1_LloydCooper {
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Lloyd Christopher Cooper 12211056
        int opcion;
       
        do {
            System.out.println("MENU");
            System.out.println("Ingrese su opcion: ");
            System.out.println("1. Número válido ");
            System.out.println("2. Reordenado de cadenas ");
            System.out.println("3. Trigonometría ");
            System.out.println("4. Salida ");
            
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero que desea validar: ");
                    leer.nextLine();
                    String numero = leer.nextLine();
                    if (validarNumero(numero)) {
                        System.out.println(numero + " es un numero valido.");
                    } else {
                        System.out.println(numero + " no es un numero valido.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cadena que desea reordenar: ");
                    leer.nextLine();
                    String cadena = leer.nextLine();
                    reordenarCadena(cadena);
                    break;
                case 3:
                    System.out.print("Ingrese el ángulo (grados) que desea calcular: ");
                    double anguloGrados = leer.nextDouble();
                    System.out.print("Ingrese la precisión deseada: ");
                    double precision = leer.nextDouble();
                    calcularSeno(anguloGrados, precision);
                    break;
                default:
            }
        } while (opcion != 4);
    }
    
   public static boolean validarNumero(String cadena) {
    boolean puntoEncontrado = false;
    boolean signoEncontrado = false;
    for (int i = 0; i < cadena.length(); i++) {
        char c = cadena.charAt(i);
        if (c == '-' && !signoEncontrado && i == 0) {
            signoEncontrado = true;
        } else if (c == '.' && !puntoEncontrado) {
            puntoEncontrado = true;
        } else if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
    }
    public static void reordenarCadena(String cadena) {
        String numeros = "";
        String minusculas = "";
        String mayusculas = "";
        String otros = "";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (Character.isDigit(c)) {
                numeros += c;
            } else if (Character.isLowerCase(c)) {
                minusculas += c;
            } else if (Character.isUpperCase(c)) {
                mayusculas += c;
            } else {
                otros += c;
            }
        }
        String resultado = numeros + minusculas + mayusculas + otros;
        System.out.println("String reordenado: " + resultado);
    }
    public static void calcularSeno(double anguloGrados, double precision) {
        double anguloRadianes = anguloGrados * Math.PI / 180;
        double resultado = 0;

        for (int i = 0; i <= precision; i++) {
            double numerador = Math.pow(-1, i) * Math.pow(anguloRadianes, 2 * i + 1);
            double factorialActual = 1;
            for (int j = 1; j <= 2 * i + 1; j++) {
                factorialActual *= j;
            }
            resultado += numerador / factorialActual;
        }

        System.out.printf("sin(%.16f) = %.16f\n", anguloRadianes, resultado);
    }  
}
