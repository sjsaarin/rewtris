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
    
    private final int KORKEUS = 20;

    private final int LEVEYS = 10;
    
    
    /*
    *  kaksiulotteinen taulukko [i][j] missä
    *  i = kentän rivi alhaalta laskien
    *  j = i:n rivin j:s solu vasemmalta laskien
    */
    boolean[][] solut; 
    
    /*
    *   Parametriton konstruktori luo kentan oletuskorkeudella ja -leveydella, asettaa solut tyhjiksi eli "false"
    */
    public Kentta(){
        solut = new boolean[KORKEUS][LEVEYS];
        tyhjenna();
    }
    
    
    public int getKorkeus(){
        return this.KORKEUS;
    }

    public int getLeveys(){
        return this.LEVEYS;
    }
    
    public boolean[] getRivi(int rivi){
        return solut[rivi];
    }
    
    /*
    / tyhjentää kentän eli asetta kaikki kentän alkiot "false"
    */
    public void tyhjenna(){
        for (int i = 0; i < KORKEUS; i++){
            for (int j = 0; j < LEVEYS; j++){
                solut[i][j] = false;
            }
        }
    }
    
    /*
    * tyhjentää rivin ja tipauttaa rivin yläpuolella olevia riveja yhden alaspäin
    */
    public void tyhjennaRivi(int rivi){
        for (int i=rivi; i<KORKEUS; i++){
            for (int j=0; j<LEVEYS; j++){
                if (i==KORKEUS-1){
                    solut[i][j] = false;
                } else {
                    solut[i][j] = solut[i+1][j];
                }
            }
        }
    }
    
    /*
    * täyttää kentän eli asettaa kaikki kentän alkiot "true"
    */
    public void tayta(){
        for (int i = 0; i < KORKEUS; i++){
            for (int j = 0; j < LEVEYS; j++){
                solut[i][j] = true;
            }
        }
    }
}