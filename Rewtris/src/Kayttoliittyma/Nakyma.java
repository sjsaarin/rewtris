/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kayttoliittyma;

import Peli.Kentta;
import Peli.Palikka;

/**
 *
 * @author sjsaarin
 */
public class Nakyma {
    
    Palikka palikka;
    Kentta kentta;
    
    public Nakyma(Kentta kentta, Palikka palikka){
        this.palikka = palikka;
        this.kentta = kentta;
    }
    
    /*
    / Toistaiseksi tilanteen piirto konsoliin, korvataan myöhemmin graafisella nakymällä
    / !! ei tomi vielä !!
    */
    public void piirra(){
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanY = palikka.getY();
        int palikanX = palikka.getX();
        for (int i = kentta.getKorkeus()-1; i >= 0; i--){
            kentanRivi = kentta.getRivi(i);
            for (int j = 0; j < kentta.getLeveys(); j++){
                if (((j - palikanX >= 0) && (j - palikanX < palikka.getKoko())) && ((i - palikanY >= 0) && (i - palikanY < palikka.getKoko()))){
                    if (palikanSolut[i-palikanX][j-palikanY]) {
                        System.out.print("O");
                    } else { 
                    if (kentanRivi[j]){
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
                    
                } else { 
                    if (kentanRivi[j]){
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
    
}
