/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokeiluja;

import Peli.Palikka;
import Peli.PalikkaI;
import Peli.PalikkaJ;
import java.util.Arrays;

/**
 *
 * @author sjsaarin
 */
public class piirtoTesti {
    
    public static void main(String args[]){
        
        Palikka palikka = new PalikkaI();
        for (int i = 0; i < 5; i++){
            System.out.print(palikka.toString());
            System.out.println(Arrays.toString(palikka.getSolut()));
            palikka.kaannaPalikkaa();
            
        }
    }
    
}
