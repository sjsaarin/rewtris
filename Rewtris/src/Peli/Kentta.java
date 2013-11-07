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


public class Kentta {
    
    private int korkeus = 20;

    private int leveys = 10;
            
    
    /*
    *   Parametriton konstruktori luo kentan oletuskorkeudella ja -leveydella
    */
    public Kentta(){
    }
    
    /*
    *   Konstruktori, parametreinä kentän korkeus ja leveys
    */
    public Kentta(int korkeus, int leveys){
        this.korkeus = korkeus;
        this.leveys = leveys;
    }
    
    public int getKorkeus(){
        return this.korkeus;
    }

    public int getLeveys(){
        return this.leveys;
    }        
    
}