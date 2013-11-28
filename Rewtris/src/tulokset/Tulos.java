/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

import java.io.Serializable;

/**
 * Luokka mallintaa yhtä pelitulosta
 * 
 * @author sjsaarin
 */
public class Tulos implements Comparable<Tulos>, Serializable {
    
    public int pisteet;
    public String nimi;

    private static final long serialVersionUID = 659317598;
    
    public Tulos(int pisteet, String nimi){
        this.pisteet = pisteet;
        this.nimi = nimi;
    } 
    
    @Override
    public int compareTo(Tulos t) {
        return pisteet < t.pisteet ? 1 : pisteet > t.pisteet ? -1 : 0;
    }
 
}

