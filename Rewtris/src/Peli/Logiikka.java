/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Peli;

import Kayttoliittyma.Nakyma;

/**
 *
 * @author sjsaarin
 */
public class Logiikka {
    
    private Kentta kentta;
    private Palikka palikka;
    private Nakyma nakyma;
    private int kentanLeveys;
    private int kentanKorkeus;
    
    public Logiikka(){
        kentta = new Kentta();
        nakyma = new Nakyma(kentta, palikka);
        kentanLeveys = kentta.getLeveys();
        kentanKorkeus = kentta.getKorkeus();
        lisaaPalikka();
    }
    
    /*
    / To do: metodi arpomaan palikka satunnaisesti
    */
    public void lisaaPalikka(){
        palikka = new PalikkaO();
        palikka.setX(kentanLeveys/2);
        palikka.setY(kentanKorkeus);  
    }
    
    public boolean pudotaPalikkaa(){
        
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanKoko = palikka.getKoko();
        
        //jos palikka on jo pohjalla ei voi pudottaa
        if (palikka.getY()-palikka.getKoko() == 0){
            return false;
        }
        
        //käydään palikka & palikan X:stä kentän seuraavat rivi läpi ja tarkistetaan voiko pudottaa
        for (int i = 0; i<palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikka.getY()-palikanKoko-1+i);
            for (int j = 0; j<palikanKoko; j++){        
                if (palikanSolut[i][j] && kentanRivi[palikka.getX()-1]){
                    return false;
                }
            }
        }
                
        //tiputetaan palikkaa
        palikka.setY(palikka.getY()-1);
        return true;   
    }

    
    
    //siirtää palikkaa oikealle
    public void palikkaOikealle(){
        
    }
    
    //siirtää palikaa vasemmalle
    public void palikkaVasemmalle(){
        
    }
    
    //pudottaa palikan suoraan alas
    public void pudotaPalikka(){
        
    }
    
    //käy kentän läpi ja poistaa kaikki täyteen tulleet rivit (tässä annetaan myös pisteet riveistä?)
    public void poistaRivit(){
        
        
    }
    
    //vain testausta varten
    public void taytaKentta(){
        kentta.tayta();
    }
    
    
    //kutsutaan jokaisen siirron päätteeksi?
    public void piirraTilanne(){
        nakyma.piirra();
    }
    
}
