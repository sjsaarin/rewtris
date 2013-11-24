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
 * Luokka vastaa pelin ohjauksen toteuttamisesta
 *
 * @author sjsaarin
 */
public class Ohjaus extends KeyAdapter {
    
    private final Logiikka logiikka;
    
    public Ohjaus(Logiikka logiikka, Nakyma nakyma){
        this.logiikka = logiikka;
        lisaaOhjausNakymaan(nakyma);
    }
    
    private void lisaaOhjausNakymaan(Nakyma nakyma){
        nakyma.addKeyListener(this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {

             int nappain = e.getKeyCode();

             switch (nappain) {
             case KeyEvent.VK_LEFT:
             //siirtää palikkaa vasemmalle
             logiikka.palikkaVasemmalle();
                 break;
             case KeyEvent.VK_RIGHT:   
             //siirtää palikkaa oikealle
             logiikka.palikkaOikealle();
                 break;
             case KeyEvent.VK_DOWN:
             //siirtää palikkaa alas
             logiikka.pudotaPalikkaa();
                 break;
             case KeyEvent.VK_UP:
             logiikka.kaannaPalikka();
             //kääntää palikkaa    
                 break;
             case KeyEvent.VK_SPACE:
             //tiputtaa palikan
             logiikka.pudotaPalikka();
                 break;          
             case KeyEvent.VK_R:
             //kelaa takaisin
             logiikka.kelaaTakaisin();
                 break;
             }
             

         }
         
}
