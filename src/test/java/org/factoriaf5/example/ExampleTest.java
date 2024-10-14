package org.factoriaf5.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    @Test
    public void testSumar() {
        // Given
        int num1 = 35; // parametros
        int num2 = 79;

        // When - Cuando
        int result = example.sumar(num1, num2);

        // Then - Entonces
        assertEquals(114, result);
        assertTrue(result > 100);
        assertFalse(result > 120);
        assertNotNull(result);
        assertInstanceOf(Integer.class, result);
    }

    @Test
    public void testPositivo() {
        // Given
        int num1 = 1;
        int num2 = -1;
        // When
        boolean result = example.checkPositivo(num1);
        // Then
        assertEquals(true, result);
        assertTrue(result);
        assertThrows(IllegalArgumentException.class, () ->  {
            example.checkPositivo(num2);
        });
        assertInstanceOf(Boolean.class, result);
    }

    @Test
    public void testContarLetrasA () {
        String texto = "Arancha come patata";
        int result1 = example.contarLetrasA(texto);
        assertEquals(5, result1);
        assertNotNull(result1);
        assertTrue(result1 <= 5);
        assertFalse(result1 > 6);
        assertInstanceOf(Integer.class, result1);
    }
    @Test
    public void testContieneElemento () {
        List<String> nombres = Arrays.asList("Camilo", "Maria", "Aranchito");
        String elemental = "Camilo";
        boolean result = example.contieneElemento(nombres, elemental);
        assertNotNull(result);
        assertEquals(true, result);
        assertInstanceOf(Boolean.class, result);
        assertNotEquals(false, result);
    }
    @Test
    public void testrevertirCadena () {
        String test = "Hello teacher";
        String result = example.revertirCadena(test);
        assertEquals("rehcaet olleH", result);
        assertInstanceOf(String.class, result);
        assertNotEquals("Hello teacher", result);
    }
    @Test
    public void testfactorial () {
        int numero = 5;
        int numero1 = -1;
        long result = example.factorial(numero);
        assertEquals(120, result);
        assertNotEquals(121, result);
        assertTrue(result <= 120);
        assertFalse(result > 121);
        assertThrows(IllegalArgumentException.class, () -> {
            example.factorial(numero1);
        });
    }
    @Test
    public void testesPrimo () {
        int numero = 4;
        int numero1 = 1;
        boolean result1 = example.esPrimo(numero1);
        boolean result = example.esPrimo(numero);
        assertFalse(result1);
        assertFalse(result);
        assertTrue(result != true);
        assertInstanceOf(Boolean.class, result1);
        // antes me dió error porque puse que esperaba un boolean de tipo primitivo
        // y no el boolean de tipo objeto
        assertInstanceOf(Boolean.class, result);
    }
    @Test
    public void testEsPrimoNumerosGrandes() {
        Example example = new Example();
        assertTrue(example.esPrimo(17));
        assertFalse(example.esPrimo(20));
    }
    @Test
    public void testEsPrimoNumerosNoPrimos() {
        Example example = new Example();
        assertFalse(example.esPrimo(0));
        assertFalse(example.esPrimo(1));
        assertFalse(example.esPrimo(-5));
    }
    @Test
    public void testMensajeConRetraso() {
        Thread hilo = new Thread(() -> {
            try {
                String result = example.mensajeConRetraso();
                System.out.println(result);
            } catch (InterruptedException e) {
                fail("El hilo fue interrumpido inesperadamente");
            }
        });
        hilo.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo.interrupt();
        try {
            hilo.join();  // Esto asegura que la ejecución espere a que el hilo termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMensajeConRetraso2 () {
        try {
            String result = example.mensajeConRetraso();
            assertEquals("Listo después de retraso", result);
        } catch (InterruptedException e) {
            System.out.println("no se que se pone aquí");
        }
    }
    @Test
    public void testconvertirAString () {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<String> result = example.convertirAString(numeros);
        assertEquals(Arrays.asList("1","2","3","4","5"), result);
    }
    @Test
    public void testcalcularMedia () {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5);
        List<Integer> numeros1 = Arrays.asList();
        Double result = example.calcularMedia(numeros);
        assertEquals(3.0, result);
        assertThrows(IllegalArgumentException.class, () -> {
            example.calcularMedia(numeros1);
        });
    }
    
    @Test
    public void testCalcularMediaLanzaExcepcion() {
        Example example = new Example();
        assertThrows(IllegalArgumentException.class, () -> example.calcularMedia(null));
        assertThrows(IllegalArgumentException.class, () -> example.calcularMedia(Collections.emptyList()));
    }

    @Test
    public void testconvertirListaAString () {
        List<String> lista = Arrays.asList("Hola", "que", "tal");
        String result = example.convertirListaAString(lista);
        assertEquals("HOLA,QUE,TAL", result);
    }
}