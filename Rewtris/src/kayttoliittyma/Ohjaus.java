/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import peli.Logiikka;

/**
 * Luokka vastaa pelin ohjauksen toteuuteksesta eli näppäinkomentojen välittämisestä Logiikalle.
 *
 * @author sjsaarin
 */
public class Ohjaus extends KeyAdapter {    
    
    private final Logiikka logiikka;
    
    public Ohjaus(Logiikka logiikka){
        this.logiikka = logiikka;
    }
    
    /**
     * Metodi lisää ohjauksen kuuntelijan Nakymaan
     * 
     * @param nakyma 
     */
    private void lisaaOhjausNakymaan(Nakyma nakyma){
        nakyma.addKeyListener(this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {

        int nappain = e.getKeyCode();

        switch (nappain) {
            case KeyEvent.VK_LEFT:
                //siirtää palikkaa vasemmalle
                logiikka.siirraPalikkaaVasemmalle();
                break;
             case KeyEvent.VK_RIGHT:   
                //siirtää palikkaa oikealle
                logiikka.siirraPalikkaaOikealle();
                break;
             case KeyEvent.VK_DOWN:
                //siirtää palikkaa alas
                logiikka.pudotaPalikkaa();
                 break;
             case KeyEvent.VK_UP:
                logiikka.kaannaPalikkaa();
                //kääntää palikkaa    
                 break;
             case KeyEvent.VK_SPACE:
                //tiputtaa palikan
                logiikka.tipautaPalikkaAlas();
                break;          
             case KeyEvent.VK_R:
                //kelaa takaisin
                logiikka.kelaaTakaisin();
                break;
             case KeyEvent.VK_P:
                 logiikka.pause();
                 break;
        }      

    }
     
}
