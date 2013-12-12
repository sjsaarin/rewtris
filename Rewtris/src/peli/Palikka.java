/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

/**
 * Luokka mallintaa pelin palikkaa, Luokassa on tieto palikan muodosta ja sijainnista.
 * 
 * @author sjsaarin
 */
public abstract class Palikka {
    
    /**
     * palikan sivun pituus
     */
    int koko;
    
    /**
     * palikan asento
     */
    int asento;
    
    /**
     * taulukko sisältää palikan muodot kaikissa mahdollisissa asennoissa
     */
    boolean[][][] asennot;
    
    /**
     * palikan muoto
     */
    boolean[][] solut;
    
    /**
     * palikan tyyyppi
     */
    int tyyppi;
    
    /**
    *   Palikan vasemman yläkulman x ja y koordinaatit
    */
    private int sijaintiX;
    private int sijaintiY;

    public int getKoko() {
         return koko;
    }
    
    /**
     * Paluttaa boolean[palikan koko][palikan koko] taulukon jossa tieto palikan muodosta.
     * Taulukon alkion arvona 'true' mikäli palikassa kyseisessä solussa on jotain 
     * muuten 'false'
     * 
     * @return palikan muoto kaksiulotteisena boolean taulukkona 
     * 
     */
    public boolean[][] getSolut() {
        return this.asennot[asento];
    }
    
    /**
     * Kääntää palikkaa myötäpäivään
     */
    public void kaanna() {
        if (asento < 3){
            asento++;
        } else {
            asento = 0;
        }
    }
    
    public void setX(int x){
        this.sijaintiX = x;
    }
    
    public int getX(){
        return this.sijaintiX;
    }
    
    public void setY(int y){
        this.sijaintiY = y;
    }
    
    public int getY(){
        return this.sijaintiY;
    }
    
    public int getTyyppi(){
        return this.tyyppi;
    }
    
}
