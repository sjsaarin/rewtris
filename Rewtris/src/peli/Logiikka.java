/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import kayttoliittyma.Nakyma;
import java.util.Timer;
import kayttoliittyma.Ohjaus;


/**
 * Luokka vastaa pelin logiikasta
 * 
 * @author sjsaarin
 */
public class Logiikka {
    
    public Kentta kentta;
    private Palikka palikka;
    private final Nakyma nakyma;
    private final Ohjaus ohjaus;
    private final int kentanLeveys;
    private final int kentanKorkeus;
    private final int kentanMarginaali;
    private Timer ajastin;
    
    public Logiikka(){
        kentta = new Kentta();
        kentanLeveys = kentta.getLeveys();
        kentanKorkeus = kentta.getKorkeus();
        kentanMarginaali = kentta.getMarginaali();
        //palikka = new PalikkaO();
        nakyma = new Nakyma(palikka, kentta);
        lisaaPalikka(1);
        palikka.setX((kentanLeveys-1)/2);
        palikka.setY(kentanKorkeus);
        ohjaus = new Ohjaus(this, nakyma);
        piirraTilanne();
    }
    
    /**
    * Metodi lisää kenttään syötteenä annettua numeroa vastaavan palikan, kelvolliset syötteet:
    * 1 - O-palikka, 2 - I-palikka, 3 - J-palikka, 4 - L-palikka, 5 - S-palikka, 6 - Z-palikka, 7 - T-palikka 
    * Mikäli syötteenä annetaan jokin muu numero lisätään kenttään O-palikka.
    * 
    * @param   nro   
    * 
    */
    public void lisaaPalikka(int nro){
        switch(nro){
            case 1: default: 
                palikka = new PalikkaO();
                break;
            case 2:               
                palikka = new PalikkaI();
                break;
            case 3:
                palikka = new PalikkaJ();
                break;
            case 4:
                palikka = new PalikkaL();
                break;
            case 5:
                palikka = new PalikkaS();
                break;
            case 6:
                palikka = new PalikkaZ();
                break;
            case 7:
                palikka = new PalikkaT();
                break;
            
        }
          
    }
    
    /**
    * Metodi pudottaa palikkaa yhden rivin alaspäin mikäli alemmalla rivillä on tilaa
    * 
    * @return 'true' mikäli pudotus onnistui, 'false' jos ei onnistunut
    */
    public boolean pudotaPalikkaa(){
        
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanKoko = palikka.getKoko();
        int palikanX = palikka.getX();
        int palikanY = palikka.getY();
        
        //käydään palikka & palikan X:stä kentän seuraavat rivi läpi ja tarkistetaan voiko pudottaa
        for (int i = 0; i<palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikanY-palikanKoko-i+kentanMarginaali);
            for (int j = 0; j<palikanKoko; j++){
                //onko alemmalla rivillä tilaa
                if (palikanSolut[i][j] && kentanRivi[palikanX+kentanMarginaali]){
                    return false;
                }
            }
        }
                
        //tiputetaan palikkaa
        palikka.setY(palikka.getY()-1);
        piirraTilanne();
        return true;   
    }

    
    /**
    * Metodi siirtää palikkaa yhden sarakkeen oikealle mikäli on tilaa
    * 
    * @return 'true' jos siirto onnistui, 'false' jos ei onnistunut
    */
    public boolean palikkaOikealle(){
        int palikanX = palikka.getX();
        int palikanY = palikka.getY();
        int palikanKoko = palikka.getKoko();
        boolean[][] palikanSolut = palikka.getSolut();
        boolean[] kentanRivi;
        for (int i = 0; i < palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikanY-i+kentanMarginaali);
            for (int j = 0; j < palikanKoko; j++){
                //rivillä ei tilaa, ei voi siirtää
                if (kentanRivi[palikanX+j+1+kentanMarginaali] && 
                       palikanSolut[i][j] ){
                    return false;
                }
            }
        }
        palikka.setX(palikanX+1);
        piirraTilanne();
        return true;
    }
    
    /**
    * Metodi siirtää palikkaa yhden sarakkeen vasemmalle mikäli on tilaa
    * 
    * @return 'true' jos siirto onnistui, 'false' jos ei onnistunut
    */
    public boolean palikkaVasemmalle(){
        int palikanX = palikka.getX();
        int palikanY = palikka.getY();
        int palikanKoko = palikka.getKoko();
        boolean[][] palikanSolut = palikka.getSolut();
        boolean[] kentanRivi;
        for (int i = 0; i < palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikanY-i-1+kentanMarginaali);
            for (int j = 0; j < palikanKoko; j++){
                // rivillä ei tilaa ei voi siirtää
                if (palikanSolut[i][j] && kentanRivi[palikanX-j+kentanMarginaali]){
                    return false;
                }
            }
            
        }
        //siirretään oikealle
        palikka.setX(palikanX-1);
        piirraTilanne();
        return true;
    }
    
    /**
    * Metodi pudottaa palikkaa alaspäin niin pitkälle kuin mahdollista
    */
    public void pudotaPalikka(){
        while (pudotaPalikkaa()) {
        }
        paivitaKentta();
        /*
        lisaaPalikka(1);
        palikka.setX((kentanLeveys-1)/2);
        palikka.setY(kentanKorkeus);
        piirraTilanne();*/
    }
    
    /**
     * Kääntää palikkaa myötäpäivään, jos kentässä on tilaa.
     * 
     * @return 'true' jos palikan kääntö onnsitui, muuten 'false' 
     */
    public boolean kaannaPalikka(){
        //ei toteutettu vielä
        piirraTilanne();
        return false;
    }
    
    /**
    * Metodi päivittää kentän solut taulukkoon palikan sijainnin, tarkoitus kutsua aina kun palikkaa on pudotettu niin alas kuin mahdollista
    */
    public void paivitaKentta(){
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanKoko=palikka.getKoko();
        for (int i=0; i<palikanKoko; i++){
            int rivi = palikka.getY()-palikanKoko+1+i;
            kentanRivi = kentta.getRivi(rivi+kentanMarginaali);
            for (int j=0; j<palikanKoko; j++){
                kentanRivi[palikka.getX()+j] = palikanSolut[i][j+kentanMarginaali];                         
            }
            kentta.setRivi(rivi, kentanRivi);
        }
    }
    
    //käy kentän läpi ja poistaa kaikki täyteen tulleet rivit (tässä annetaan myös pisteet riveistä?)
    public void poistaRivit(){
        //ei toteutettu vielä
    }
    
    /**
    * Täyttää kentän
    */
    public void taytaKentta(){
        kentta.tayta();
    }
    
    /**
    * Metodi tyhjentää kentän
    */
    public void tyhjennaKentta(){
        kentta.tyhjenna();
    }
    
    /**
    * Metodi piirtää tilanteen näkymään
    */
    public void piirraTilanne(){
        nakyma.paivita(palikka, kentta);
    }
    
    public Palikka getPalikka(){
        return this.palikka;
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
    }
    
    public void setKentta(Kentta kentta){
        this.kentta = kentta;
    }
    
    /**
     * Asetta kenttaan rivin parametreina saatujen rivinumeron ja rivin mukaan 
     * 
     * @param rivinro Kenttaan asetettavan rivin numero
     * @param rivi Kenttaan asetettava rivi
     */
    public void setKentanRivi(int rivinro, boolean[] rivi){
        kentta.setRivi(rivinro, rivi);
    }
    
}
