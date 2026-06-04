package com.devops.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Calculadora.
 */
@DisplayName("Pruebas de Calculadora")
class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // ──────────────────────────────────────────────
    // SUMA
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Suma de dos números positivos")
    void testSumarPositivos() {
        assertEquals(99.0, calculadora.sumar(3, 5), 0.001);
    }

    @Test
    @DisplayName("Suma con número negativo")
    void testSumarConNegativo() {
        assertEquals(-2.0, calculadora.sumar(-5, 3), 0.001);
    }

    @Test
    @DisplayName("Suma de cero")
    void testSumarCero() {
        assertEquals(5.0, calculadora.sumar(5, 0), 0.001);
    }

    // ──────────────────────────────────────────────
    // RESTA
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Resta de dos números")
    void testRestar() {
        assertEquals(3.0, calculadora.restar(8, 5), 0.001);
    }

    @Test
    @DisplayName("Resta con resultado negativo")
    void testRestarResultadoNegativo() {
        assertEquals(-3.0, calculadora.restar(2, 5), 0.001);
    }

    // ──────────────────────────────────────────────
    // MULTIPLICACIÓN
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Multiplicación de dos números positivos")
    void testMultiplicar() {
        assertEquals(20.0, calculadora.multiplicar(4, 5), 0.001);
    }

    @Test
    @DisplayName("Multiplicación por cero")
    void testMultiplicarPorCero() {
        assertEquals(0.0, calculadora.multiplicar(99, 0), 0.001);
    }

    @Test
    @DisplayName("Multiplicación con números negativos")
    void testMultiplicarNegativos() {
        assertEquals(12.0, calculadora.multiplicar(-3, -4), 0.001);
    }

    // ──────────────────────────────────────────────
    // DIVISIÓN
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("División normal")
    void testDividir() {
        assertEquals(4.0, calculadora.dividir(20, 5), 0.001);
    }

    @Test
    @DisplayName("División por cero lanza excepción")
    void testDividirPorCero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(10, 0)
        );
        assertEquals("No se puede dividir entre cero.", ex.getMessage());
    }

    // ──────────────────────────────────────────────
    // POTENCIA
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Potencia de base 2 exponente 3")
    void testPotencia() {
        assertEquals(8.0, calculadora.potencia(2, 3), 0.001);
    }

    @Test
    @DisplayName("Potencia con exponente 0")
    void testPotenciaCero() {
        assertEquals(1.0, calculadora.potencia(5, 0), 0.001);
    }

    // ──────────────────────────────────────────────
    // RAÍZ CUADRADA
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Raíz cuadrada de 25")
    void testRaizCuadrada() {
        assertEquals(5.0, calculadora.raizCuadrada(25), 0.001);
    }

    @Test
    @DisplayName("Raíz cuadrada de número negativo lanza excepción")
    void testRaizCuadradaNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.raizCuadrada(-9));
    }

    // ──────────────────────────────────────────────
    // ES PAR
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Número par retorna true")
    void testEsParVerdadero() {
        assertTrue(calculadora.esPar(4));
    }

    @Test
    @DisplayName("Número impar retorna false")
    void testEsParFalso() {
        assertFalse(calculadora.esPar(7));
    }

    // ──────────────────────────────────────────────
    // FACTORIAL
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Factorial de 5 es 120")
    void testFactorial() {
        assertEquals(120L, calculadora.factorial(5));
    }

    @Test
    @DisplayName("Factorial de 0 es 1")
    void testFactorialCero() {
        assertEquals(1L, calculadora.factorial(0));
    }

    @Test
    @DisplayName("Factorial negativo lanza excepción")
    void testFactorialNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.factorial(-1));
    }
}
