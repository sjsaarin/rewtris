/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin S-palikkaa, Luokassa on tieto palikan muodosta eri asennoissa.
 * 
 * @author sjsaarin
 */
public class PalikkaS extends Palikka {
    
    private final int koko = 3;        
    private final int tyyppi = 5;
    private final boolean asennot[][][] = {
        {
            { false, true, true },
            { true, true, false },
            { false, false, false }       
        },
        {
            { false, true, false },
            { false, true, true },
            { false, false, true }
        },
        {
            { false, false, false },
            { false, true, true },
            { true, true, false }
        },
        {
            { true, false, false },
            { true, true, false },
            { false, true, false }
        }
    };
    
    public PalikkaS(){
        super.asento = 0;
        super.asennot = this.asennot;
        super.koko = this.koko;
        super.tyyppi = this.tyyppi;
    }
}
