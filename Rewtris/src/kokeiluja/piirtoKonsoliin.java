/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokeiluja;

import Peli.Kentta;
import Kayttoliittyma.Nakyma;
import Peli.Palikka;
import Peli.PalikkaI;
import Peli.PalikkaJ;
import Peli.PalikkaO;

/**
 *
 * @author sjsaarin
 */
public class piirtoKonsoliin {
    
    public static void main(String[] args){
        Kentta kentta = new Kentta();
        Palikka palikka = new PalikkaO();
        palikka.setX(4);
        palikka.setY(20);
        Nakyma nakyma = new Nakyma(kentta, palikka);
        kentta.tayta();
        nakyma.piirra();
        System.out.println("---------------------------------");
        kentta.tyhjennaRivi(2);
        nakyma.piirra();
        System.out.println("---------------------------------");
        kentta.tyhjennaRivi(2);
        nakyma.piirra();
    }
    
}
