/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin L-palikkaa, Luokassa on tieto palikan muodosta eri asennoissa.
 * 
 * @author sjsaarin
 */
public class PalikkaL extends Palikka {
    
    private final int koko = 3;
    private final int tyyppi = 3;
    private final boolean asennot[][][] = {
        {
            { false, false, true },
            { true, true, true },
            { false, false, false }       
        },
        {
            { false, true, false },
            { false, true, false },
            { false, true, true }
        },
        {
            { false, false, false },
            { true, true, true },
            { true, false, false }
        },
        {
            { true, true, false },
            { false, true, false },
            { false, true, false }
        }
    };
    
    public PalikkaL(){
        super.asento = 0;
        super.asennot = this.asennot;
        super.koko = this.koko;
        super.tyyppi = this.tyyppi;
    }
}
