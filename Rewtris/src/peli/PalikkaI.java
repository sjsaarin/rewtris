/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin palikkaa, Luokassa on tieto palikan muodosta eri asennoissa.
 * 
 * @author sjsaarin
 */
public class PalikkaI extends Palikka {
    
    private int korkeus;
    private int leveys;
    
    private final boolean asennot[][][] = {
        {
            { true, true, true, true }       
        },
        {
            { true },
            { true },
            { true },
            { true }
        },
        {
            { false, false, false, false },
            { false, false, false, false },
            { true, true, true, true },
            { false, false, false, false }
        },
        {
            { false, true, false, false },
            { false, true, false, false },
            { false, true, false, false },
            { false, true, false, false }
        }
    };
    
    private final int asentojenKoot[][] = {
        {1,4}
    };
    
    public PalikkaI(){
        super.asento = 0;
        super.koko = this.koko;
        super.asennot = this.asennot;
    }
    
}
