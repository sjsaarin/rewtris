/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin J-palikkaa, Luokassa on tieto palikan muodosta eri asennoissa.
 * 
 * @author sjsaarin
 */
public class PalikkaJ extends Palikka {
    private final int koko = 3;
    private int asento;        
    private final boolean asennot[][][] = {
        {
            { true, false, false },
            { true, true, true },
            { false, false, false }       
        },
        {
            { false, true, true },
            { false, true, false },
            { false, true, false }
        },
        {
            { false, false, false },
            { true, true, true },
            { false, false, true }
        },
        {
            { false, true, false },
            { false, true, false },
            { true, true, false }
        }
    };
    
    public PalikkaJ(){
        super.koko = this.koko;
        super.asento = 0;
        super.asennot = this.asennot;
    } 
}
