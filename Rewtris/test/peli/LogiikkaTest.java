/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

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
    
    @Test
    public void palikanSiirtoTyhjassaKentassaOikealleOnnistuu(){
        peliLogiikka.tyhjennaKentta();
        assertEquals(true, peliLogiikka.palikkaOikealle());
    }
    
    @Test
    public void palikanSiirtoTaydessaKentassaVasemmalleEiOnnistu(){
        peliLogiikka.taytaKentta();
        assertEquals(false, peliLogiikka.palikkaVasemmalle());
    }
    
    @Test
    public void palikanSiirtoTyhjassaKentassaVasemmalleOnnistuu(){
        assertEquals(true, peliLogiikka.palikkaVasemmalle());
    }
    
    @Test
    public void palikanSiirtoTaydessaKentassaOikealleEiOnnistu(){
        peliLogiikka.taytaKentta();
        assertEquals(false, peliLogiikka.palikkaOikealle());
    }
    
    
    @Test
    public void palikanSiirtoReunanYliVasemmalleEiOnnistu(){
        
    }
    
    @Test
    public void palikanSiirtoReunanYliOikealleEiOnnistu(){
        
    }
    
    @Test
    public void palikanArvontaArpooLuvutOikein(){
        //int[] luvut = new int[100];
        boolean onYksi = false;
        boolean onKaksi = false;
        boolean onKolme = false;
        boolean onNelja = false;
        boolean onViisi = false;
        boolean onKuusi = false;
        boolean onSeitseman = false;
        boolean onSallittuLuku = true;
        
        
        
        for (int i = 0; i<100; i++){
            int luku = peliLogiikka.arvoPalikanNumero();
            if (luku == 1) {
                onYksi = true;
            }
            if (luku == 2) {
                onKaksi = true;
            }
            if (luku == 3) {
                onKolme = true;
            }
            if (luku == 4) {
                onNelja = true;
            }
            if (luku == 5) {
                onViisi = true;
            }
            if (luku == 6) {
                onKuusi = true;
            }
            if (luku == 7) {
                onSeitseman = true;
            }
            if (luku < 1 || luku > 7){
                onSallittuLuku = false;
            }
        }
        assertTrue(onYksi && onKaksi && onKolme && onNelja && onViisi && onKuusi && onSeitseman && onSallittuLuku);
        
    }
}
