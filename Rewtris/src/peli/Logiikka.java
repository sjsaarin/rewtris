/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import java.util.Calendar;
import java.util.Random;
import kayttoliittyma.Nakyma;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Luokka vastaa pelin logiikasta
 * 
 * @author sjsaarin
 */
public class Logiikka {
    
    public Kentta kentta;
    private Palikka palikka;
    private final Nakyma nakyma;
    private final int kentanLeveys;
    private final int kentanKorkeus;
    private final int kentanMarginaali;
    private  PisteLaskuri pistelaskuri;
    private Timer ajastin;
    private int ajastimenjakso;
    private int taso;
    private long aikaleima;
    private boolean pelikaynnissa;
    private int palikannumero;

    //takaisinkelausta varten
    private int kelauksia;
    private int kelauslaskuri;
    private boolean voikelata;
    private int muistettupalikka;
    private boolean[][] muistettukentta;
    
    public Logiikka(){
               
        kentta = new Kentta();
        kentanLeveys = kentta.getLeveys();
        kentanKorkeus = kentta.getKorkeus();
        kentanMarginaali = kentta.getMarginaali();
        pistelaskuri = new PisteLaskuri();
        nakyma = new Nakyma(palikka, kentta, this);
        pelikaynnissa = false;
        
    }
    
    /**
     * Aloittaa pelin
     */
    public void aloitaPeli(){
        
        pelikaynnissa = true;
        
        kentta.tyhjenna();
        pistelaskuri.nollaa();
        
        voikelata = false;
        kelauslaskuri = 0;
        
        taso = 1;
        kelauksia = 0;
      
        Calendar cal = Calendar.getInstance();
        aikaleima = cal.getTimeInMillis(); 
        
        uusiPalikka(-1);
                
        ajastimenjakso = 1000;
        kaynnistaAjastin(ajastimenjakso);
        
    }
    
    /**
    * Metodi lisää peliin syötteenä annettua numeroa vastaavan palikan, mikäli peli on käynnissä. Kelvolliset syötteet:
    * 0 - tyhja palikka, 1 - O-palikka, 2 - I-palikka, 3 - J-palikka, 4 - L-palikka, 5 - S-palikka, 6 - Z-palikka, 7 - T-palikka 
    * Mikäli syötteenä annetaan jokin muu numero lisätään kenttään satunnainen palikka. Palikka lisätään kentän huipulle.
    * 
    * @param   numero   
    * 
    */
    public void uusiPalikka(int numero){
    
        if (pelikaynnissa){
            
            int x;
            
            if (numero < 0 || numero > 7){
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
       
            //jos palikalle ei ole tilaa kentässä lopetetaan peli, muuten lisätään palikka peliin;
            if(!(palikalleOnTilaa(0,0))){
                lopetaPeli();
            } else {
                nakyma.setPalikka(palikka);
            }
            //piirraTilanne();
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
            //piirraTilanne();
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
            //piirraTilanne();
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
            //piirraTilanne();
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
            //piirraTilanne();
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
        lopetaKierros();
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
    * Metodi päivittää pisteet ja muut tiedot sivunäkymään
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
        pelikaynnissa = false;
        ajastin.cancel();
        //odotetaan pari sekunttia ennen kuin ilmoitetaan näkymälle että peli ohi, jotta ajastin varmasti on pysähtynyt
        ajastin = new Timer();
        ajastin.schedule(new TimerTask(){
                @Override
                public void run(){
                    nakyma.peliOhi();
                }
            },2000);
    }
    
    /**
     * Kelaa pelitilanteen takaisin edelliseen palikkaan
     */
    public void kelaaTakaisin(){
        if (kelauksia>0 && voikelata){
            ajastin.cancel();
            uusiPalikka(muistettupalikka);
            kentta.setSolut(muistettukentta);
            pistelaskuri.vahennaPisteetKelauksesta(kelauksia);
            kelauksia--;
            voikelata = false;
            piirraTilanne();
            kaynnistaAjastin(ajastimenjakso);
        }    
    }
    
    public int getPisteet(){
        return pistelaskuri.getPisteet();
    }
    
    public int getTaso(){
        return this.taso;
    }
    
    public int getKelauksia(){
        return this.kelauksia;
    }
    
    public boolean getVoikelata(){
        return (this.voikelata && kelauksia > 0);
    }
    
    //kutsutaan kierroksen lopussa, kun palikkaa on tiputettu niin pitkälle kuin mahdollista
    private void lopetaKierros(){
        //otetaan kentän solut ja palikan numero talteen takaisinkelausta varten
        tallenna();
        voikelata = true;
        ajastin.cancel();
        paivitaKentta();
        piirraTilanne();
        uusiKierros();
    }
    
    //tallentaa kentän solut ja palikan numeron takaisinkelausta varten
    private void tallenna(){
        muistettukentta = kentta.getSolut();
        muistettupalikka = palikannumero;
    }
    
    //päivittää kentän solut taulukkoon palikan solut kierroksen lopuksi
    private void paivitaKentta(){
        
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
        //kun palikka päivitetty kenttään tarkastetaan tuliko täysiä rivejä
        poistaTaydetRivit();
       
    }
    
    //käynnistää palikoita tiputtavan ajastimen jos peli on käynnissä
    private void kaynnistaAjastin(int jakso){
      
        if (pelikaynnissa){

            int viive = jakso;
            
            ajastin = new Timer();
            ajastin.scheduleAtFixedRate(new TimerTask()
                {
                    @Override
                    public void run()
                {
                    if(!pudotaPalikkaa()){
                        this.cancel();
                        lopetaKierros();
                }
            }
            }, viive, jakso);
        }    
    }
    
    //lisaa numeron mukaisen palikan peliin
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
    
    //käy kentän läpi ja poistaa kaikki täyteen tulleet rivit (tässä annetaan myös pisteet riveistä)
    private void poistaTaydetRivit(){
        int rivitaynna;
        int rivejapoistettu = 0;
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
              
              //annetaan pisteet rivistä
              pistelaskuri.annaPisteetRivista(rivi+rivejapoistettu, taso);
              
              kentta.poistaRivi(rivi);
              rivejapoistettu++;             
              
              paivitaKelaukset();
              
          } else {
              rivi++;
          }
            
        }
    }
    
    //kutsutaan kun saatu täysi rivi, päivittää kelaukset
    private void paivitaKelaukset(){
              //lisätään kelaus jos täysiä rivejä tullut 5 ja nollataan kelauslaskuri
              if (kelauslaskuri<5){
                  kelauslaskuri++;
              }
              if (kelauslaskuri == 5){
                  if (kelauksia < 10){
                      kelauksia++;
                  }
                  kelauslaskuri = 0;
              }
              
              //tuli täysi rivi, ei voi kelata seuraavalla kierroksella
              voikelata = false;
    }
    
    //tarkistaa onko annetuissa koordinaateissa suhteessa palikkaan tilaa palikalle
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
    
    //aloittaa uuden kierroksen jos peli on käynnissä
    private void uusiKierros(){
        if (pelikaynnissa){
            Calendar cal = Calendar.getInstance();
            long aikanyt = cal.getTimeInMillis();
            //mikäli aikaa on kulunut yli 30 sekuntia edellisestä tason nostosta, nostetaan tasoa
            if (aikanyt - aikaleima > 30000){
                if (taso < 20) {
                    taso++;
                    ajastimenjakso -= 50;
                }
                aikaleima = aikanyt;
            }
            uusiPalikka(-1);
            //piirraTilanne(); 
            kaynnistaAjastin(ajastimenjakso);
        }
    }
    
}
