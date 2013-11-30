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
    
    private final static int KORKEUS = 20;

    private final static int LEVEYS = 10;
    
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
    
    /*
    * kaksiulotteinen taulukko joka sisältää palikoiden numerot kentässä. 
    * Käytetään lähinnä graafisessa näkymässä jos halutaan piirtää palikoita vastaavat solut eri väreillä.
    */
    private int[][] palikat;
    private final boolean muistaapalikat;
    
    /**
     * 
     * @param muistaapalikat 
     */
    public Kentta(boolean muistaapalikat){
        this.muistaapalikat = muistaapalikat;
        todellinenLeveys = LEVEYS+(2*marginaali);
        todellinenKorkeus = KORKEUS+marginaali;
        if (muistaapalikat){
            palikat = new int[todellinenKorkeus][todellinenLeveys];
        }
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
        return Kentta.KORKEUS;
    }
    
    public int getLeveys(){
        return Kentta.LEVEYS;
    }
    
    public int getMarginaali(){
        return this.marginaali;
    }
    
    /**
    * Metodi palauttaa pyydetyn rivin marginaaleineen.
    * Syötteenä rivin numero laskettuna kentan koon + marginaalin mukaan
    * 
    * @param rivinro Rivin numero marginaalin kanssa laskettuna
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
    * Metodi palauttaa pyydetyn rivin palikat taulukosta.
    * 
    * @param rivinro Rivin numero
    * 
    * @return pyydetty rivi
    */
    public int[] getPalikkaRivi(int rivinro){
        int[] annettavaRivi = new int[todellinenLeveys];
        for (int i = 0; i < todellinenLeveys; i++){
            annettavaRivi[i] = this.palikat[rivinro][i];
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
    * Metodin asettaa kenttään annetun rivin.
    * Kirjoittaa yli olemassaolevan rivin.
    * 
    * @param rivi rivin numero laskettuna ilman marginaalia
    *
    * @param uusirivi uusi rivi marginaaleineen
    *
    */
    public void setPalikkaRivi(int rivi, int[] uusirivi){
        for (int i = 0; i < todellinenLeveys; i++){
            palikat[rivi+marginaali][i] = uusirivi[i];
        }
    }
    
    /**
    *  Metodi tyhjentää kentän eli asettaa kaikkien kentän alkioiden arvoksi 'false'
    */
    public void tyhjenna(){
        for (int i = marginaali; i < todellinenKorkeus; i++){
            for (int j = marginaali; j < LEVEYS+marginaali; j++){
                this.solut[i][j] = false;
                if (muistaapalikat){
                    palikat[i][j]= 0;
                }
            }
        }
    }
    
    /**
    *  Poistaa parametrina annetun rivin ja pudottaa rivin yläpuolella olevia riveja yhden alaspäin.
    * 
    *  @param rivi rivin numero ilman marginaalia
    */
    public void poistaRivi(int rivi){
        for (int i=rivi+marginaali; i<todellinenKorkeus; i++){
            for (int j=marginaali; j<LEVEYS+marginaali; j++){
                if (i==todellinenKorkeus-1){
                    this.solut[i][j] = false;
                    if (muistaapalikat){
                        palikat[i][j]= -1;
                    }
                } else {
                    this.solut[i][j] = solut[i+1][j];
                    if (muistaapalikat){
                        palikat[i][j]= palikat[i+1][j];
                    }
                }
            }
        }
    }
    
    
    /**
    * Metodi täyttää kentän eli asettaa kaikkien kentän alkioden arvoksi 'true'
    */
    public void tayta(){
        for (int i = marginaali; i < todellinenKorkeus; i++){
            for (int j = marginaali; j < LEVEYS+marginaali; j++){
                this.solut[i][j] = true;
            }
        }
    }
    
    /**
    * Metodi palauttaaa kopion kentan soluista ilman marginaaleja
    * 
    * @return Kentän solut
    */
    public boolean[][] getSolut(){
        boolean[][] annettavatSolut = new boolean[KORKEUS][LEVEYS];
        for (int i = 0; i < KORKEUS; i++){
            for (int j = 0; j < LEVEYS; j++){
                annettavatSolut[i][j] = solut[i+marginaali][j+marginaali];
            }
        }
        return annettavatSolut;
    }
    
    /**
    * Metodi palauttaaa kopion kentan palikoista ilman marginaaleja
    * 
    * @return Kentän palikat
    */
    public int[][] getPalikat(){
        int[][] annettavatpalikat = new int[KORKEUS][LEVEYS];
        for (int i = 0; i < KORKEUS; i++){
            for (int j = 0; j < LEVEYS; j++){
                annettavatpalikat[i][j] = palikat[i+marginaali][j+marginaali];
            }
        }
        return annettavatpalikat;
    }
        
    /**
    * Metodi asettaa kentän solut parametrina saadun taulukon mukaiseksi. (Lähinnä testausta varten).
    * 
    * @param solut taulukko boolean[kentan korkeus ilman marginaalia][kentan leveys ilman marginaalia] 
    */
    public void setSolut(boolean[][] solut){
        for(int i=marginaali; i<todellinenKorkeus; i++){
            for(int j=marginaali; j<LEVEYS+marginaali; j++){
                this.solut[i][j] = solut[i-marginaali][j-marginaali];
            }
        }
    }
    
    /**
    * Metodi asettaa kentän solut ja palikat taulukon parametreina saatujen taulukoiden mukaisiksi. (Lähinnä testausta varten).
    * 
    * @param solut taulukko boolean[kentan korkeus ilman marginaalia][kentan leveys ilman marginaalia]
    * @param palikat taulukko int[kentan korkeus ilman marginaalia][kentan leveys ilman marginaalia] 
    */
    public void setSolutJaPalikat(boolean[][] solut, int[][] palikat){
        setSolut(solut);
        this.palikat = palikat;
    }

}