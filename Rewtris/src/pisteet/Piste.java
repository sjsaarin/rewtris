/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pisteet;

import java.io.Serializable;

/**
 * Luokka mallintaa yhtä pelitulosta
 * 
 * @author sjsaarin
 */
public class Piste implements Comparable<Piste>, Serializable {
    
    int pisteet;
    String nimi;

    public Piste(int pisteet, String nimi){
        this.pisteet = pisteet;
        this.nimi = nimi;
    } 
    
    @Override
    public int compareTo(Piste t) {
        return pisteet < t.pisteet ? -1 : pisteet > t.pisteet ? 1 : 0;
    }
 
}

