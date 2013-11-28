/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

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
public class TulosTest {
    
    Tulos tulos1;
    Tulos tulos2;
    Tulos tulos3;
    
    public TulosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tulos1 = new Tulos(100, "qwerty");
        tulos2 = new Tulos(200, "zxcvb");
        tulos3 = new Tulos(200, "asdfg");
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
    public void suuremmanVertailuPienempäänTuottaaOikeanTuloksen(){
        
        assertEquals(tulos2.compareTo(tulos1), -1);
    }
    
    @Test
    public void pienemmänVertailuSuurempaanTuottaaOikeanTuloksen(){
        
        assertEquals(tulos1.compareTo(tulos2), 1);
    }
    
    @Test
    public void yhtäsuurtenVertailuTuottaaOikeanTuloksen(){
        
        assertEquals(tulos2.compareTo(tulos3), 0);
    }
}
