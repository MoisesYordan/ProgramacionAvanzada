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
        int i=2;
        switch(i){
            case 0:
                int cantidad1=2;
                int ganancia1 = 100000;
                GestorVistaVentas instance1 = new GestorVistaVentas();
                int expResult1 = 200000;
                int result1 = instance1.calcularGanancia(ganancia1, cantidad1);
                assertEquals(expResult1, result1);
                break;
                
            case 1:
                int cantidad2=0;
                int ganancia2 = 100000;
                GestorVistaVentas instance2 = new GestorVistaVentas();
                int expResult2 = 0;
                int result2 = instance2.calcularGanancia(ganancia2, cantidad2);
                assertEquals(expResult2, result2);
                break;
            case 2:
                int cantidad3=-1;
                int ganancia3 = 100000;
                GestorVistaVentas instance3 = new GestorVistaVentas();
                int expResult3 = -100000;
                int result3 = instance3.calcularGanancia(ganancia3, cantidad3);
                assertEquals(expResult3, result3);
                break;
        }
    }

    @Test
    public void testCalcularTotal() {
        System.out.println("calcularTotal");
        int i=2;
        switch(i){
            case 0:
                int cantidad0 = 1;
                int impuesto0 = 1;
                int total0 = 600000;
                GestorVistaVentas instance0 = new GestorVistaVentas();
                int expResult0 = 606000;
                int result0 = instance0.calcularTotal(cantidad0, impuesto0, total0);
                assertEquals(expResult0, result0);
                break;
            case 1:
                int cantidad1 = 1;
                int impuesto1 = 15;
                int total1 = 600000;
                GestorVistaVentas instance1 = new GestorVistaVentas();
                int expResult1 = 690000;
                int result1 = instance1.calcularTotal(cantidad1, impuesto1, total1);
                assertEquals(expResult1, result1);
                break;
            case 2:
                int cantidad2 = 1;
                int impuesto2 = 20;
                int total2 = 600000;
                GestorVistaVentas instance2 = new GestorVistaVentas();
                int expResult2 = 720000;
                int result2 = instance2.calcularTotal(cantidad2, impuesto2, total2);
                assertEquals(expResult2, result2);
                break;
        }

    }

    /**
     * Test of validarNumeros method, of class GestorVistaVentas.
     */
    @Test
    public void testValidarNumeros() {
        System.out.println("validarNumeros");
        String letra="1-23";
        switch(letra.toLowerCase()){
            case "1aa":
                boolean expResult0 = false;
                boolean result0 = GestorVistaVentas.validarNumeros(letra);
                assertEquals(expResult0, result0);
                break;
            case "123":
                boolean expResult1 = true;
                boolean result1 = GestorVistaVentas.validarNumeros(letra);
                assertEquals(expResult1, result1);
                break;
            case"1-23":
                boolean expResult2 = false;
                boolean result2 = GestorVistaVentas.validarNumeros(letra);
                assertEquals(expResult2, result2);
                break;            
        }
    }

   
    
}
