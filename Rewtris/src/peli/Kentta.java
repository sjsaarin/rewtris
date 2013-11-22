/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin kenttää. Kenttään on tallennettu tieto siitä mitkä kentän ruuduista ovat täynnä.
 * 
 * @author sjsaarin
 */


public class Kentta {
    
    private final int KORKEUS = 20;

    private final int LEVEYS = 10;
    
    private final int marginaali = 4;
    
    private final int todellinenLeveys;
    private final int todellinenKorkeus;    
    
    /*
    *  kaksiulotteinen taulukko [i][j] missä
    *  i = kentän rivi alhaalta laskien
    *  j = i:n rivin j:s solu vasemmalta laskien
    *  molemmissa reunoissa ja pohjassa "marginaali" muuttujan verran marginaalia
    *  joissa arvot aina "true" palikoiden törmäyslogiikan yksinkertaistamiseksi 
    */
    private boolean[][] solut; 
    
    public Kentta(){
        todellinenLeveys = LEVEYS+(2*marginaali);
        todellinenKorkeus = KORKEUS+marginaali;
        solut = new boolean[todellinenKorkeus][todellinenLeveys];
        alustaKentta();
    }
    
    /*
    *  Metodi alustaa kentän. Asettaa kentän solut marginaalin verran vasemmalta ja oikealta sekä alhaalta arvoon 'true' ja
    *  ja loput arvoon 'false' 
    */
    private void alustaKentta(){
        for (int i = 0; i < todellinenKorkeus; i++){
            for (int j = 0; j < todellinenLeveys; j++){
                solut[i][j] = true;
            }
        }
        tyhjenna();
    }
    
    public int getKorkeus(){
        return this.KORKEUS;
    }
    
    public int getLeveys(){
        return this.LEVEYS;
    }
    
    public int getMarginaali(){
        return this.marginaali;
    }
    
    /**
    * Metodi paluattaa pyydetyn rivin marginaaleineen.
    * Syötteenä rivin numero laskettuna kentan todellisen korkeuden mukaan
    * 
    * @param rivinro Rivin numero
    * 
    * @return pyydetty rivi marginaaleineen
    */
    public boolean[] getRivi(int rivinro){
        boolean[] annettavaRivi = new boolean[todellinenLeveys];
        for (int i = 0; i < todellinenLeveys; i++){
            annettavaRivi[i] = this.solut[rivinro][i];
        }
        return annettavaRivi;
    }
    
    /**
    * Metodin asettaa kenttään annetun rivin.
    * Kirjoittaa yli olemassaolevan rivin.
    * 
    * @param rivi rivin numero laskettuna ilman marginaalia
    *
    * @param uusirivi uusi rivi marginaaleineen
    *
    */
    public void setRivi(int rivi, boolean[] uusirivi){
        for (int i = 0; i < todellinenLeveys; i++){
            solut[rivi+marginaali][i] = uusirivi[i];
        }
    }
    
    /**
    *  Metodi tyhjentää kentän eli asetta kaikkien kentän alkioiden arvoksi "false"
    */
    public void tyhjenna(){
        for (int i = marginaali; i < todellinenKorkeus; i++){
            for (int j = marginaali; j < LEVEYS+marginaali; j++){
                this.solut[i][j] = false;
            }
        }
    }
    
    /**
    *  Poistaa parametrina annetun rivin ja tipauttaa rivin yläpuolella olevia riveja yhden alaspäin.
    * 
    *  @param rivi rivin numero ilma marginaalia
    */
    public void poistaRivi(int rivi){
        for (int i=rivi+marginaali; i<todellinenKorkeus; i++){
            for (int j=marginaali; j<LEVEYS+marginaali; j++){
                if (i==todellinenKorkeus-1){
                    this.solut[i][j] = false;
                } else {
                    this.solut[i][j] = solut[i+1][j];
                }
            }
        }
    }
    
    
    /**
    * Metodi täyttää kentän eli asettaa kaikkien kentän alkioden arvoksi "true"
    */
    public void tayta(){
        for (int i = marginaali; i < todellinenKorkeus; i++){
            for (int j = marginaali; j < LEVEYS+marginaali; j++){
                this.solut[i][j] = true;
            }
        }
    }
    
    /**
    * Metodi palauttaaa kentan solut ilman marginaaleja
    * 
    * @return Kentän solut
    */
    public boolean[][] getSolut(){
        boolean[][] annettavatSolut = new boolean[20][10];
        for (int i = 0; i < KORKEUS; i++){
            for (int j = 0; j < LEVEYS; j++){
                annettavatSolut[i][j] = solut[i+marginaali][j+marginaali];
            }
        }
        return annettavatSolut;
    }
    
    
    /**
    * Metodi asettaa kentän solut parametrina saadun taulukon mukaiseksi.
    * 
    * @param solut Syötteeksi kelpaa taulukko boolean[kentan korkeus][kentan leveys] 
    */
    public void setSolut(boolean[][] solut){
        for(int i=marginaali; i<todellinenKorkeus; i++){
            for(int j=marginaali; j<LEVEYS+marginaali; j++){
                this.solut[i][j] = solut[i][j];
            }
        }
    }
}