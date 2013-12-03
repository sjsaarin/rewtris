/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami-Joonas
 */
public class TuloksetTallentajaTest {
    
    TuloksetTallentaja tallentaja;
    
    public TuloksetTallentajaTest() {
    }
    
    @Before
    public void setUp() {
        tallentaja = new TuloksetTallentaja();
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
    public void tuloksetTallentajaTallentaaTuloksetOnnistuneesti(){
        ArrayList<Tulos> tulokset = new ArrayList<Tulos>();
        assertTrue(tallentaja.tallenna(tulokset));
    }
    
    @Test
    public void tuloksetTallentajaLataaTulokset(){
        ArrayList<Tulos> tulokset = new ArrayList<Tulos>();
        tallentaja.tallenna(tulokset);
        ArrayList<Tulos> ladatuttulokset = tallentaja.lataa();
        assertEquals(tulokset, ladatuttulokset);
    }
}
