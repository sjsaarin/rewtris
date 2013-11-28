/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rewtris;

import peli.Logiikka;

/*
 *
 * @author sjsaarin
 */
public class Rewtris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            aloitaPeli();
        } catch (Throwable ex) {
            System.err.println("Uncaught exception - " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
        
    }
    
    
    private static void aloitaPeli(){
        Logiikka logiikka = new Logiikka();
    }
    
}
