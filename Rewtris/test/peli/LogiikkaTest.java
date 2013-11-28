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
       peliLogiikka.aloitaPeli();
    }
    
    @After
    public void tearDown() {
        peliLogiikka.lopetaPeli();
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
        peliLogiikka.aloitaPeli();
        for (int i = 0; i < 20; i++){
            peliLogiikka.pudotaPalikkaa();
        }
        assertEquals(false, peliLogiikka.pudotaPalikkaa());
        peliLogiikka.lopetaPeli();
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
        for (int i = 0; i < 6; i++){
            peliLogiikka.palikkaVasemmalle();
        }
        assertFalse(peliLogiikka.palikkaVasemmalle());
        
    }
    
    @Test
    public void palikanSiirtoReunanYliOikealleEiOnnistu(){
        for (int i = 0; i < 6; i++){
            peliLogiikka.palikkaOikealle();
        }
        assertFalse(peliLogiikka.palikkaOikealle());
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
    
    @Test
    public void pelinAlussaTasoOnYksi(){
        assertEquals(1, peliLogiikka.getTaso());
    }
    
    @Test
    public void pelinAlussaPisteetOnNolla(){
        assertEquals(0, peliLogiikka.getPisteet());
    }
    
    @Test
    public void pelinAlussaKelauksiaOnNolla(){
        assertEquals(0, peliLogiikka.getKelauksia());
    }
    
    @Test
    public void pelinAlussaEiVoiKelata(){
        assertFalse(peliLogiikka.getVoikelata());
    }
    
    @Test 
    public void peliLoppuuKunPalikoitaKentanHuipussaAsti(){
        for (int i = 0; i < 12; i++){
            peliLogiikka.pudotaPalikka();
        }
        assertFalse(peliLogiikka.getPelikaynnissa());
        
    }
    
    @Test
    public void palikkaaEiVoiLiikuttaaJosPeliEiKäynnissä(){
        peliLogiikka.lopetaPeli();
        assertFalse(peliLogiikka.palikkaOikealle() || peliLogiikka.palikkaVasemmalle() || peliLogiikka.kaannaPalikka() || peliLogiikka.pudotaPalikkaa());
    }
    
    @Test
    public void uudenPalikanLisaysTayteenKenttaanLopettaaPelin(){
        peliLogiikka.taytaKentta();
        peliLogiikka.uusiPalikka(1);
        assertFalse(peliLogiikka.getPelikaynnissa());
    }
    
    @Test 
    public void viidestaTaydestaRivistaSaaKelauksen(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        assertEquals(1, peliLogiikka.getKelauksia());
    }
    
    @Test 
    public void TaydenRivinSaanninJälkeenEiVoiKelata(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        assertFalse(peliLogiikka.getVoikelata());
    }
    
    @Test 
    public void kunOnSaanutKelauksenSitaSeuraavallaKierroksellaVoiKelata(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        assertTrue(peliLogiikka.getVoikelata());
    }
    
    @Test 
    public void kunOnKelannutSeuraavallaKierroksellaEiVoiKelata(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        peliLogiikka.kelaaTakaisin();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        assertFalse(peliLogiikka.getVoikelata());
    }
    
    @Test 
    public void taysistaRiveistaSaaPisteita(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        assertTrue(peliLogiikka.getPisteet() > 505);
    }
    
    @Test 
    public void kelausVahentaaPisteita(){
        boolean[] rivi = new boolean[18];
        for (int i = 0; i < 18; i++){
            rivi[i] = true;
        }
        peliLogiikka.setKentanRivi(0, rivi);
        peliLogiikka.setKentanRivi(1, rivi);
        peliLogiikka.setKentanRivi(2, rivi);
        peliLogiikka.setKentanRivi(3, rivi);
        peliLogiikka.setKentanRivi(4, rivi);
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        peliLogiikka.pudotaPalikka();
        while (!peliLogiikka.pudotaPalikkaa()){
        }
        peliLogiikka.kelaaTakaisin();
        assertTrue(peliLogiikka.getPisteet()<500);
    }
    
    
}