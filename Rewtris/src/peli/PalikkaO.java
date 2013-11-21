/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin O-palikkaa, Luokassa on tieto palikan muodosta eri asennoissa.
 * 
 * @author sjsaarin
 */
public class PalikkaO extends Palikka {
    
    private final int koko = 2;       
    private final boolean asennot[][][] = {
        {
            {true,true},
            {true,true}
        }
    };
    
    public PalikkaO(){
        super.asento = 0;
        super.koko = this.koko;
        super.asennot = this.asennot;
    } 
    
    @Override
    public void kaannaPalikkaa(){
        
    }
    
}
