/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Luokka mallintaa 0-kokoista tyhjaa palikkaa
 */

package peli;

public class PalikkaTyhja extends Palikka {
    
    private final int koko = 0;       
    private final boolean asennot[][][] = {
        {
            {false}
        }
    };
    
    public PalikkaTyhja(){
        super.asento = 0;
        super.koko = this.koko;
        super.asennot = this.asennot;
    } 
    
    @Override
    public void kaanna(){
        
    }
    
}
