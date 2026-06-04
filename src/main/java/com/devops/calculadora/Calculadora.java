package com.devops.calculadora;

/**
 * Clase Calculadora con operaciones matemáticas básicas.
 * Proyecto de ejemplo para GitHub Actions, JaCoCo y SonarCloud.
 */
public class Calculadora {

    /**
     * Suma dos números.
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     * @throws IllegalArgumentException si el divisor es cero.
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    /**
     * Calcula la potencia de una base elevada a un exponente.
     */
    public double potencia(double base, int exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Calcula la raíz cuadrada de un número.
     * @throws IllegalArgumentException si el número es negativo.
     */
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(numero);
    }

    /**
     * Determina si un número es par.
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /**
     * Calcula el factorial de un número no negativo.
     * @throws IllegalArgumentException si el número es negativo.
     */
    public long factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    //cambio para hacer el push de ejempplo y ver que el pipeline este funcionando:
}
