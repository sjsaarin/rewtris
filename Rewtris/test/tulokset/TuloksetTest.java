/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

import java.util.Arrays;
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
public class TuloksetTest {
    
    Tulokset tulokset;
    
    @Before
    public void setUp() {
        tulokset = new Tulokset();
        tulokset.lisaaTulos(new Tulos(1, "kymmenes"));
        tulokset.lisaaTulos(new Tulos(4, "seitsemas"));
        tulokset.lisaaTulos(new Tulos(3, "kahdeksas"));
        tulokset.lisaaTulos(new Tulos(5, "kuudes"));
        tulokset.lisaaTulos(new Tulos(6, "viides"));
        tulokset.lisaaTulos(new Tulos(10, "eka"));
        tulokset.lisaaTulos(new Tulos(7, "neljas"));
        tulokset.lisaaTulos(new Tulos(2, "yhdeksas"));
        tulokset.lisaaTulos(new Tulos(9, "toka"));
        tulokset.lisaaTulos(new Tulos(8, "kolmas"));
        
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
    public void tuloksetOnTallennettuJarjestyksessa(){
        Tulos tulos = tulokset.getTulos(9);
        assertEquals(1, tulos.pisteet);
    }
    
    @Test
    public void tayteenTuloksiinUudenLisaaminenEiKasvataKokoa(){
        Tulos tulos = new Tulos(9, "toinen yhdeksas");
        tulokset.lisaaTulos(tulos);
        assertTrue(tulokset.getTulokset().size() == 10);
    }
    
    @Test
    public void uudenTuloksenLisaaminenTayteenToimiiOIkein(){
        Tulos tulos = new Tulos(9, "toinen yhdeksas");
        tulokset.lisaaTulos(tulos);
        assertTrue(tulokset.getTulos(9).pisteet == 2);
    }
    
    @Test
    public void getKokoAntaaOikeanTuloksen(){
        assertEquals(tulokset.getKoko(), 10);
    }
    
    @Test
    public void getHuonoimmatPisteetAntaaHuonoimmatPisteet(){
        assertEquals(tulokset.getHuonoimmatPisteet(), 1);
    }
    
    @Test
    public void getParhaatPisteetAntaaParhaimmatPisteet(){
        assertEquals(tulokset.getParhaatPisteet(), 10);
    }
    
    @Test
    public void josEiOleTalletettuYhtaanTulostaGetKokoPalauttaNolla(){
        Tulokset tulokset = new Tulokset();
        assertEquals(0, tulokset.getKoko());
    }
    
    @Test
    public void tulostenTallennusOnnistuu(){
        assertTrue(tulokset.tallennaTulokset());
    }
    
    @Test
    public void tallennettujenTulostenLatausOnnistuu(){
        assertTrue(tulokset.lataaTulokset());
    }
    
    @Test
    public void tuloksetOnTallennettuOikein(){
        tulokset.tallennaTulokset();
        tulokset.lataaTulokset();
        assertEquals(6, tulokset.getTulos(4).pisteet);
    }
    
    @Test
    public void tyhjaTuloksetAntaaParhaimmiksiPisteiksiNollan(){
        tulokset = new Tulokset();
        assertEquals(0, tulokset.getParhaatPisteet());
    }
    
    @Test
    public void tyhjaTuloksetAntaaHuonoimmiksiPisteiksiNollan(){
        tulokset = new Tulokset();
        assertEquals(0, tulokset.getHuonoimmatPisteet());
    }
}
