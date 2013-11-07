/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PeliTest;

import Peli.Kentta;
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
public class KenttaTest {
    
    Kentta parametritonKentta, kentta;
    
    @Before
    public void setUp() {
        parametritonKentta = new Kentta();
        kentta = new Kentta(30, 5);
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
    public void parametritonKonstruktoriAntaaOikeanKorkeuden(){
         assertEquals(20, parametritonKentta.getKorkeus());
    }
    
    @Test
    public void parametritonKonstruktoriAntaaOikeanLeveyden(){
         assertEquals(10, parametritonKentta.getLeveys());
    }
    
    @Test 
    public void parametrillinenKonstruktoriAsettaaKorkeuden(){
        assertEquals(30, kentta.getKorkeus());
    }
    
    @Test 
    public void parametrillinenKonstruktoriAsettaaLeveyden(){
        assertEquals(5, kentta.getLeveys());
    }
    
    
}
