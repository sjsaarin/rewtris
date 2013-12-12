/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rewtris;

import peli.Logiikka;

/**
 * Pääohjelma, ainoana tehtävänä Logiikka-olion luominen.
 * 
 * @author sjsaarin
 */
public class Rewtris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            aloitaPeli();
    }
    
    private static void aloitaPeli(){
        Logiikka logiikka = new Logiikka();
    }
    
}
