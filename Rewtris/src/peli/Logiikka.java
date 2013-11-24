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
    
    //takaisinkelausta varten
    private int muistettupalikka;
    private boolean[][] muistettukentta;
    private boolean muistettu;
    private int palikannumero;
    private boolean tallennettu;
    
    public Logiikka(){
        
        muistettu = false;
        tallennettu = false;
        
        kentta = new Kentta();
        kentanLeveys = kentta.getLeveys();
        kentanKorkeus = kentta.getKorkeus();
        kentanMarginaali = kentta.getMarginaali();
        uusiPalikka(0);
        nakyma = new Nakyma(palikka, kentta);
        ohjaus = new Ohjaus(this, nakyma);
        kaynnistaAjastin();
    }
    
    /**
    * Metodi lisää kenttään syötteenä annettua numeroa vastaavan palikan, kelvolliset syötteet:
    * 0 - Tyhjä palikka, 1 - O-palikka, 2 - I-palikka, 3 - J-palikka, 4 - L-palikka, 5 - S-palikka, 6 - Z-palikka, 7 - T-palikka 
    * Mikäli syötteenä annetaan jokin muu numero lisätään kenttään satunnainen palikka. Palikka lisätään kentän huipulle.
    * 
    * @param   nro   
    * 
    */
    public void uusiPalikka(int numero){
    
       int x;
       if (numero < 1 || numero > 7){
         palikannumero = arvoPalikanNumero();
       } else {
           palikannumero = numero;
       }
       lisaaPalikka(palikannumero);
       if (palikannumero == 1){
           x = (kentanLeveys-1)/2;
       } else if(palikannumero == 2) {
           x = ((kentanLeveys)/2)-(palikka.getKoko()/2);
       } else {       
           x = ((kentanLeveys-1)/2)-(palikka.getKoko()/2);
       }
       palikka.setX(x);
       palikka.setY(kentanKorkeus-1);
       
       if(!(palikalleOnTilaa(0,0))){
           lopetaPeli();
       }
   }
   
   /**
    * Metodi arpoo satunnaisen numeron väliltä 1-7
    * 
    * @return palikan numero 
    */
    public int arvoPalikanNumero(){
        Random random = new Random();
        int luku = random.nextInt(7) + 1;
        return luku;
    }
    
    
    /**
    * Metodi pudottaa palikkaa yhden rivin alaspäin mikäli alemmalla rivillä on tilaa
    * 
    * @return 'true' mikäli pudotus onnistui, 'false' jos ei onnistunut
    */
    public boolean pudotaPalikkaa(){
        
        if (palikalleOnTilaa(0,-1)){
        
            palikka.setY(palikka.getY()-1);
            piirraTilanne();
            return true;
        }
        return false;
    }

    /**
    * Metodi siirtää palikkaa yhden sarakkeen oikealle mikäli on tilaa
    * 
    * @return 'true' jos siirto onnistui, 'false' jos ei onnistunut
    */
    public boolean palikkaOikealle(){
        if (palikalleOnTilaa(1, 0)){
            palikka.setX(palikka.getX()+1);
            piirraTilanne();
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * Metodi siirtää palikkaa yhden sarakkeen vasemmalle mikäli on tilaa
    * 
    * @return 'true' jos siirto onnistui, 'false' jos ei onnistunut
    */
    public boolean palikkaVasemmalle(){
        
        //siirretään vasemmalle jos onnistuu
        if (palikalleOnTilaa(-1, 0)){
            palikka.setX(palikka.getX()-1);
            piirraTilanne();
            return true;
        } else {
            return false;
        }
    }
    
     /**
     * Kääntää palikkaa myötäpäivään, jos kentässä on tilaa.
     * 
     * @return 'true' jos palikan kääntö onnsitui, muuten 'false' 
     */
    public boolean kaannaPalikka(){
        //käännetaan palikkaa
        palikka.kaanna();
        //tarkistetaan mahtuuuko palikka
        if (palikalleOnTilaa(0,0)){
            piirraTilanne();
            return true;
        }
        //ei mahtunut, käännetään takaisin
        palikka.kaanna();
        palikka.kaanna();
        palikka.kaanna();
        return false;
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
    * Metodi päivittää kentän solut taulukkoon palikan sijainnin, tarkoitus kutsua aina kun palikkaa on pudotettu niin alas kuin mahdollista
    */
    public void paivitaKentta(){
        //pysäytetään ajastin varmuuden vuoksi jottei yritä tipauttaa palikkaa turhaan
        ajastin.cancel();
        
        //otetaan kentän solut ja palikan numero talteen takaisinkelausta varten 
        tallenna();
        
        while(!tallennettu){
            
        }
        tallennettu = false;
        
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
        uusiPalikka(0);
        poistaTaydetRivit();
        nakyma.setPalikka(palikka);
        kaynnistaAjastin();
        piirraTilanne();
    }
    
    /**
    * Täyttää kentän
    */
    public void taytaKentta(){
        kentta.tayta();
    }
    
    /**
    * Tyhjentää kentän
    */
    public void tyhjennaKentta(){
        kentta.tyhjenna();
    }
    
    /**
    * Metodi piirtää tilanteen näkymään
    */
    public void piirraTilanne(){
        nakyma.paivita();
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
    
    /**
     * lopettaa pelin
     */
    public void lopetaPeli(){
        tyhjennaKentta();
    }
    
    /**
     * Kelaa takaisin edelliseen palikkaan
     */
    public void kelaaTakaisin(){
        if (muistettu){
            ajastin.cancel();
            lisaaPalikka(muistettupalikka);
            kentta.setSolut(muistettukentta);
            kaynnistaAjastin();
            piirraTilanne();
        }
        
    }
    
    private void tallenna(){
        muistettukentta = kentta.getSolut();
        muistettupalikka = palikannumero;
        muistettu = true;
        tallennettu = true;
    }
    
    private void kaynnistaAjastin(){
        int viive = 1000;
        int jakso = 1000;

        ajastin = new Timer();
        ajastin.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                if(!pudotaPalikkaa()){
                    paivitaKentta();
                }
            }
        }, viive, jakso);
 
    }
    
    private void lisaaPalikka(int nro){
        
        switch(nro){
            case 0: default:
                palikka = new PalikkaTyhja();
                break;
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
    
    //käy kentän läpi ja poistaa kaikki täyteen tulleet rivit (tässä annetaan myös pisteet?)
    private void poistaTaydetRivit(){
        int rivitaynna;
        boolean[][] kentansolut;
        int rivi = 0;
        while (rivi < kentanKorkeus){
          kentansolut = kentta.getSolut();
          rivitaynna = 0;
          for (int i = 0; i < kentanLeveys; i++){
              if(kentansolut[rivi][i]){
                   rivitaynna++;
               }
          }
          if (rivitaynna == kentanLeveys){
              kentta.poistaRivi(rivi);
          } else {
              rivi++;
          }
            
        }
    }
    
    private boolean palikalleOnTilaa(int x, int y){
        int palikanX = palikka.getX();
        int palikanY = palikka.getY();
        int palikanKoko = palikka.getKoko();
        boolean[][] palikanSolut = palikka.getSolut();
        boolean[] kentanRivi;
        for (int i = 0; i < palikanKoko; i++){
            kentanRivi = kentta.getRivi(palikanY-i+kentanMarginaali+y);
            for (int j = 0; j < palikanKoko; j++){
                // onko rivillä tilaa
                if (palikanSolut[i][j] && kentanRivi[palikanX+j+kentanMarginaali+x]){
                    return false;
                }
            }
            
        }
        return true;
    }
    
}
