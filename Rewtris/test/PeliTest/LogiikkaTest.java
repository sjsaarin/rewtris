/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PeliTest;

import Peli.Logiikka;
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
public class LogiikkaTest {
    
    Logiikka peliLogiikka;
    
    @Before
    public void setUp() {
       peliLogiikka = new Logiikka();
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void palikanTiputusTyhjassaKentassaOnnistuu(){
        assertEquals(true, peliLogiikka.pudotaPalikkaa());
    }
    
    @Test
    public void palikanTiputusKentanPohjastaLapiEiOnnistu(){
        for (int i = 0; i < 20; i++){
            peliLogiikka.pudotaPalikkaa();
        }
        assertEquals(false, peliLogiikka.pudotaPalikkaa());
    }
    
    @Test
    public void palikanTiputusTaydessaKentassaEiOnnistu(){
        peliLogiikka.taytaKentta();
        assertEquals(false, peliLogiikka.pudotaPalikkaa());
    }
}
