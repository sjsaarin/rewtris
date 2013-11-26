/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import peli.PisteLaskuri;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sjsaarin
 */
public class PisteLaskuriTest {
    
    PisteLaskuri pistelaskuri;
    
    public PisteLaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pistelaskuri = new PisteLaskuri();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void pisteLaskuriAntaaPisteetOikeinRiveista(){
        pistelaskuri.annaPisteetRivista(0, 10); //110
        pistelaskuri.annaPisteetRivista(1, 0);  //211
        pistelaskuri.annaPisteetRivista(2, 0);  //313
        assertEquals(313, pistelaskuri.getPisteet());
    }
    
    @Test
    public void pistelaskuriVahentaaPisteetOikeinKelauksesta(){
        pistelaskuri.annaPisteetRivista(0, 0);
        pistelaskuri.vahennaPisteetKelauksesta(1);
        assertEquals(90, pistelaskuri.getPisteet());
    }
}
