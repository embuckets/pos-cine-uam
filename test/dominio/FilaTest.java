/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emilio
 */
public class FilaTest {

    Fila[] filaTested;

    public FilaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        filaTested = new Fila[27];
        for (int i = 1; i < 26; i++) {
            filaTested[i] = new Fila(i, 20);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNumero method, of class Fila.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        for (int i = 1; i < 26; i++) {
            System.out.println("Fila " + i + ": " + filaTested[i].toString());
        }
    }

    /**
     * Test of agregarAsiento method, of class Fila.
     */
    @Test
    public void testAgregarAsiento() {
        System.out.println("agregarAsiento");
        filaTested[1].agregarAsiento();
        for (int i = 1; i < 26; i++) {
            System.out.println("Fila " + i + ": " + filaTested[i].toString());
        }

    }

}
