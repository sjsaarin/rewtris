/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PeliTest;

import Peli.Palikka;
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
public class PalikkaTest {
    
    Palikka palikkaI, palikkaL, palikkaJ, palikkaS, palikkaZ, palikkaT, palikkaO;
    
    @Before
    public void setUp() {
        palikkaI = new Palikka(0);
        palikkaL = new Palikka(1);
        palikkaJ = new Palikka(2);
        palikkaS = new Palikka(3);
        palikkaZ = new Palikka(4);
        palikkaT = new Palikka(5);
        palikkaO = new Palikka(6);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void konstruktoriLuoPalikan(){
        Palikka uusiPalikka = new Palikka(6);
        assertEquals("[[-1, 0], [-1, -1], [0, 0], [0, -1]]", Arrays.deepToString(uusiPalikka.getKoordinaatit()));
    }
    
    @Test
    public void palikanKaantoToimii(){
        Palikka kaannetty = palikkaI.kaanna();
        assertEquals("[[0, 1], [0, 0], [0, -1], [0, -2]]", Arrays.deepToString(kaannetty.getKoordinaatit()));
    }
    
    @Test
    public void palikanKaantoNeljaKertaaPalauttaaAlkuperaisessaAsennossaOlevanPalikan(){
        Palikka kaannettyNeljasti = palikkaT.kaanna();
        kaannettyNeljasti = kaannettyNeljasti.kaanna();
        kaannettyNeljasti = kaannettyNeljasti.kaanna();
        kaannettyNeljasti = kaannettyNeljasti.kaanna();
        assertEquals("[[-1, 0], [0, 1], [0, 0], [1, 0]]", Arrays.deepToString(kaannettyNeljasti.getKoordinaatit()));
    }
    
    @Test
    public void viidestiKaannettySamassaAsennossaKuinKerranKaannetty(){
        Palikka kerranKaannetty = palikkaZ.kaanna();
        Palikka viidestiKaannetty = kerranKaannetty.kaanna();
        viidestiKaannetty = viidestiKaannetty.kaanna();
        viidestiKaannetty = viidestiKaannetty.kaanna();
        viidestiKaannetty = viidestiKaannetty.kaanna();
        assertEquals(Arrays.deepToString(kerranKaannetty.getKoordinaatit()), Arrays.deepToString(viidestiKaannetty.getKoordinaatit()));
    }
    
    @Test
    public void nelioPalikanKaantoEiMuutaKoordinaatteja(){
        Palikka kaannettyNelio = palikkaO.kaanna();
        assertEquals("[[-1, 0], [-1, -1], [0, 0], [0, -1]]", Arrays.deepToString(kaannettyNelio.getKoordinaatit()));
    }
}
