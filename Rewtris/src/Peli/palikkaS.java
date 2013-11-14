/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Peli;

/**
 *
 * @author sjsaarin
 */
public class palikkaS extends Palikka {
    private final int koko = 3;        
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
    
    public palikkaS(){
        super.asento = 0;
        super.asennot = this.asennot;
        super.koko = this.koko;
    }
}
