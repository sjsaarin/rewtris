/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import java.util.Random;
import kayttoliittyma.Nakyma;
import java.util.Timer;
import java.util.TimerTask;
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
        ohjaus = new Ohjaus(this, nakyma);
        uusiPalikka();
        piirraTilanne();
        kaynnistaAjastin();
    }
    
    /**
     * Lisää uuden satunnaisen palikan kentän huipulle.
     * 
     */
   public void uusiPalikka(){
       int palikannro = arvoPalikanNumero();
       int x;
       lisaaPalikka(palikannro);
       if (palikannro == 1){
           x = (kentanLeveys-1)/2;
       } else if(palikannro == 2) {
           x = ((kentanLeveys)/2)-(palikka.getKoko()/2);
       } else {       
           x = ((kentanLeveys-1)/2)-(palikka.getKoko()/2);
       }
       palikka.setX(x);
       palikka.setY(kentanKorkeus-1);
       piirraTilanne();
   }
   
   public int arvoPalikanNumero(){
       Random random = new Random();
       int luku = random.nextInt(7) + 1;
       return luku;
   }
    
    /**
    * Metodi lisää kenttään syötteenä annettua numeroa vastaavan palikan, kelvolliset syötteet:
    * 0 - Tyhjä palikka, 1 - O-palikka, 2 - I-palikka, 3 - J-palikka, 4 - L-palikka, 5 - S-palikka, 6 - Z-palikka, 7 - T-palikka 
    * Mikäli syötteenä annetaan jokin muu numero lisätään kenttään O-palikka.
    * 
    * @param   nro   
    * 
    */
    public void lisaaPalikka(int nro){
        
        switch(nro){
            case 0: default:
                palikka = new PalikkaTyhja();
            case 1: 
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
            kentanRivi = kentta.getRivi(palikanY-palikanKoko+i+kentanMarginaali);
            for (int j = 0; j < palikanKoko; j++){
                //onko alemmalla rivillä tilaa
                if (palikanSolut[palikanKoko-1-i][j] && kentanRivi[palikanX+j+kentanMarginaali]){
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
                //onko rivillä tilaa oikealla
                if (palikanSolut[i][j] && kentanRivi[palikanX+j+1+kentanMarginaali]){
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
            kentanRivi = kentta.getRivi(palikanY-i+kentanMarginaali);
            for (int j = 0; j < palikanKoko; j++){
                // onko rivillä tilaa
                if (palikanSolut[i][j] && kentanRivi[palikanX+j-1+kentanMarginaali]){
                    return false;
                }
            }
            
        }
        //siirretään vasemmalle
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
    }
    
    /**
     * Kääntää palikkaa myötäpäivään, jos kentässä on tilaa.
     * 
     * @return 'true' jos palikan kääntö onnsitui, muuten 'false' 
     */
    public boolean kaannaPalikka(){
        palikka.kaanna();
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanKoko = palikka.getKoko();
        int palikanY = palikka.getY();
        int palikanX = palikka.getX();
        for (int i=0; i < palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikanY-i+kentanMarginaali);
            for (int j=0; j < palikanKoko; j++){
                //tarkistetaan mahtuiko kääntämään
                if (palikanSolut[i][j] && kentanRivi[palikanX+j+kentanMarginaali]){
                    //ei mahtunut, käännetään takaisin
                    palikka.kaanna();
                    palikka.kaanna();
                    palikka.kaanna();
                    return false;
                }
            }
        }
        piirraTilanne();
        return true;
    }
    
    /**
    * Metodi päivittää kentän solut taulukkoon palikan sijainnin, tarkoitus kutsua aina kun palikkaa on pudotettu niin alas kuin mahdollista
    */
    public void paivitaKentta(){
        boolean[] kentanrivi;
        boolean[][] palikansolut = palikka.getSolut();
        int palikankoko=palikka.getKoko();
        for (int i=0; i<palikankoko; i++){
            int rivi = palikka.getY()+kentanMarginaali-i;
            kentanrivi = kentta.getRivi(rivi);
            for (int j=0; j<palikankoko; j++){
                if (palikansolut[i][j]){
                    kentanrivi[palikka.getX()+j+kentanMarginaali] = true;
                }
            }
            kentta.setRivi(palikka.getY()-i, kentanrivi);
        }
        /*
        palikka = new PalikkaTyhja();
        palikka.setX(0);
        palikka.setY(0);
        */
        piirraTilanne();
        poistaTaydetRivit();
        uusiPalikka();
    }
    
    //käy kentän läpi ja poistaa kaikki täyteen tulleet rivit (tässä annetaan myös pisteet)
    private void poistaTaydetRivit(){
        int rivitaynna;
        boolean[][] kentansolut = kentta.getSolut();
        for (int i = 0; i < kentanKorkeus; i++){
            rivitaynna = 0;
            for (int j = 0; j < kentanLeveys; j++){
               if(kentansolut[i][j]){
                   rivitaynna++;
               }
            }
            if(rivitaynna == kentanLeveys){
                kentta.poistaRivi(i);
                piirraTilanne();
            }
        }
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
    
    private void kaynnistaAjastin(){
        int viive = 1000;
        int jakso = 1000;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
                if(!pudotaPalikkaa()){
                    paivitaKentta();
                }
            }
        }, viive, jakso);
 
    }
    
}
