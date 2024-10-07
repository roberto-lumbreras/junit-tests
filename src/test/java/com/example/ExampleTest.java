package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExampleTest {
    private Example example = new Example();

    // 1. Test para sumar dos números
    @Test
    public void testSumar() {
        int n1 = 3;
        int n2 = 5;
        int res = n1+n2;
        assertTrue(res==example.sumar(n1, n2));
    }

    // 2. Test para checkPositivo con excepción
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPositivo() {
        assertTrue(example.checkPositivo(1));
        assertTrue(example.checkPositivo(0));
        example.checkPositivo(-1);
    }

    // 3. Test para contar letras 'a'
    @Test
    public void testContarLetrasA() {
        assertTrue(2==example.contarLetrasA("cadena"));
        assertTrue(0==example.contarLetrasA(""));
    }

    // 4. Test para contieneElemento
    @Test
    public void testContieneElemento() {
        List<String>lista=new ArrayList<String>();
        lista.add("chocolate");
        lista.add("caramelo");
        lista.add("roquefort");
        assertTrue(example.contieneElemento(lista, "chocolate"));
        assertFalse(example.contieneElemento(lista, "gazpacho"));
    }

    // 5. Test para revertirCadena
    @Test
    public void testRevertirCadena() {
        assertEquals("sapos",example.revertirCadena("sopas"));
    }

    // 6. Test para factorial
    @Test
    public void testFactorial() {
        try {
            example.factorial(-1);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
        
        assertTrue(120==example.factorial(5));
        assertTrue(1==example.factorial(0));
        assertTrue(1==example.factorial(1));
    }

    // 7. Test para esPrimo
    @Test
    public void testEsPrimo() {
        assertFalse(example.esPrimo(1));
        assertTrue(example.esPrimo(2));
        assertTrue(example.esPrimo(3));
        assertTrue(example.esPrimo(7));
        assertTrue(example.esPrimo(59));
        assertFalse(example.esPrimo(64));
        assertTrue(example.esPrimo(71));
        assertFalse(example.esPrimo(81));
    }

    // 8. Test para mensajeConRetraso
    @Test 
    public void testMensajeConRetraso() {
        String test=null;
        long inicio = System.currentTimeMillis();
        try{
        test = example.mensajeConRetraso();
        }catch(InterruptedException e){
        }
        long fin = System.currentTimeMillis();
        long esperado = fin-inicio;
        assertTrue(esperado>=4900&&esperado<=5100);
        assertEquals("Listo después de retraso",test);
    }

    // 9. Test para convertirAString
    @Test
    public void testConvertirAString() {
        List<Integer>lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        List<String>listaString = new ArrayList<String>();
        listaString.add("1");
        listaString.add("2");
        listaString.add("3");
        assertEquals(listaString, example.convertirAString(lista));
    }

    // 10. Test para calcularMedia
    @Test
    public void testCalcularMedia() {
        try {
            example.calcularMedia(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
        try {
            example.calcularMedia(new ArrayList<>());
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
        List<Integer>lista = new ArrayList<Integer>();
        lista.add(5);
        lista.add(7);
        lista.add(11);
        double d = (5+7+11)/3.0;
        assertTrue(d==example.calcularMedia(lista));
    }

    // 11. Test para convertirListaAString
    @Test
    public void testConvertirListaAString() {
        List<String>lista = new ArrayList<String>();
        lista.add("Gato");
        lista.add("Perro");
        lista.add(null);
        lista.add("Leon");
        String expected = "GATO,PERRO,NULL,LEON";
        assertEquals(expected, example.convertirListaAString(lista));
    }
}
