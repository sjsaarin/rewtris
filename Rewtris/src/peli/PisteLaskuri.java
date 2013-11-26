/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka vastaa pisteiden laskusta.
 * 
 * @author sjsaarin
 */
public class PisteLaskuri {
    
    private int pisteet;
    
    public PisteLaskuri(){
        this.pisteet = 0;
    }
    
    /**
     * Pisteyttää parametrina annetun täyden rivin. Pisteitä annetaan seuraavasti:
     * Peruspisteet rivistä: 100 + rivin numero
     * Tason mukaan lisäpisteet: peruspisteet * taso/100
     * 
     * @param rivi
     * @return päivitetyt pisteet 
     */
    public int annaPisteetRivista(int rivi, int taso){
        int rivinpisteet = (100 + rivi);
        rivinpisteet += (rivinpisteet * taso/100);
        this.pisteet += rivinpisteet;
        return this.pisteet;
    }
    
    /**
     * Vähentää pisteitä takaisinkelauksen käytöstä.
     * Pisteitä vähennetään välillä 1-10% sen mukaan kuinka paljon kelauksia on käytettävissä:
     * Jos kelauksia on yksi pisteitä vähennetään 10%, jos kymmenen 1% 
     * 
     * @param kelauksia
     * @return päivitetyt pisteet
     */
    public int vahennaPisteetKelauksesta(int kelauksia){
        int vahennetytpisteet = this.pisteet*(100 - (11-kelauksia))/100;
        this.pisteet = vahennetytpisteet;
        return this.pisteet;
    }
    
    /**
     * Nollaa pistelaskurin
     */
    public void nollaa(){
        this.pisteet = 0;
    }
    
    public int getPisteet(){
        return (int)this.pisteet;
    }
}
