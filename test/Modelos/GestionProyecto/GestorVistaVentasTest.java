/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelos.GestionProyecto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivota
 */
public class GestorVistaVentasTest {
    
    public GestorVistaVentasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCalcularGanancia() {
        System.out.println("calcularGanancia");
        int ganancia = 100000;
        int cantidad = 2;
        GestorVistaVentas instance = new GestorVistaVentas();
        int expResult = 200000;
        int result = instance.calcularGanancia(ganancia, cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result !=expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of calcularTotal method, of class GestorVistaVentas.
     */
    @Test
    public void testCalcularTotal() {
        System.out.println("calcularTotal");
        int cantidad = 1;
        int impuesto = 1;
        int total = 600000;
        GestorVistaVentas instance = new GestorVistaVentas();
        int expResult = 606000;
        int result = instance.calcularTotal(cantidad, impuesto, total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
          if(result !=expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of validarNumeros method, of class GestorVistaVentas.
     */
    @Test
    public void testValidarNumeros() {
        System.out.println("validarNumeros");
        String datos = "a";
        boolean expResult = false;
        boolean result = GestorVistaVentas.validarNumeros(datos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result !=expResult){
            fail("The test case is a prototype.");
        }
    }

   
    
}
