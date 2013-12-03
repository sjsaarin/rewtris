/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import peli.Kentta;
import peli.Palikka;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Luokka vastaa pelitilanteen piirtämisestä näkymään
 * 
 * @author sjsaarin
 */
public class PeliNakyma extends JPanel {
    
    private Palikka palikka;
    private Kentta kentta;
    private final int width = 30;
    private final int height = 30;
    private int x;
    private int y;
    
    private Color palikkaTyhjavari;
    private Color palikkaIvari;
    private Color palikkaJvari;
    private Color palikkaLvari;
    private Color palikkaOvari;
    private Color palikkaSvari;
    private Color palikkaTvari;
    private Color palikkaZvari;
    private Color taustavari;
    private Color ruudukonvari;
 
    
    public PeliNakyma(Kentta kentta, Palikka palikka){
        this.palikka = palikka;
        this.kentta = kentta;
    }
    
    /**
     * Asettaa pelin väriprofiilin, profiileja on kolme: 'Dark', 'Light', 'Monochrome'
     * 
     * @param variprofiili 
     */
    public void setVariprofiili(String variprofiili){
        switch(variprofiili){
            case "Dark": default:
                taustavari = Color.DARK_GRAY;
                setBackground(taustavari);
                palikkaTyhjavari = taustavari;
                palikkaIvari = Color.CYAN;
                palikkaJvari = Color.MAGENTA;
                palikkaLvari = Color.PINK;
                palikkaOvari = Color.RED;
                palikkaSvari = Color.GREEN;
                palikkaTvari = Color.BLUE;
                palikkaZvari = Color.YELLOW;
                ruudukonvari = Color.BLACK;
                break;
             case "Light":
                taustavari = Color.WHITE;
                setBackground(taustavari);
                palikkaTyhjavari = taustavari;
                palikkaIvari = Color.CYAN;
                palikkaJvari = Color.MAGENTA;
                palikkaLvari = Color.PINK;
                palikkaOvari = Color.RED;
                palikkaSvari = Color.GREEN;
                palikkaTvari = Color.BLUE;
                palikkaZvari = Color.YELLOW;
                ruudukonvari = Color.LIGHT_GRAY;
                break;
             case "Monochrome":
                taustavari = Color.WHITE;
                setBackground(taustavari);
                palikkaTyhjavari = taustavari;
                palikkaTyhjavari = Color.WHITE;
                palikkaIvari = Color.DARK_GRAY; 
                palikkaJvari = Color.DARK_GRAY; 
                palikkaLvari = Color.DARK_GRAY; 
                palikkaOvari = Color.DARK_GRAY; 
                palikkaSvari = Color.DARK_GRAY;
                palikkaTvari = Color.DARK_GRAY;
                palikkaZvari = Color.DARK_GRAY;
                ruudukonvari = Color.LIGHT_GRAY;
                break;
        }
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraPalikka(g);    
        piirraKentta(g);
    }
        
    private void piirraPalikka(Graphics g){
        asetaVari(palikka.getTyyppi(), g);
        x = palikka.getX()*width;
        y = (kentta.getKorkeus()-1-palikka.getY())*height;
        boolean[][] koordinaatit = palikka.getSolut();
        for (int i = 0; i < palikka.getKoko(); i++){
            for (int j = 0; j < palikka.getKoko(); j++){
                if (koordinaatit[i][j]){
                    g.fill3DRect(x, y, width, height, true);
                }
                x += width;
            }
            x = palikka.getX()*width;
            y += height;
        }
    }
    
    private void piirraKentta(Graphics g){
        x = 0; 
        y = 0;
        boolean[][] kentanSolut = kentta.getSolut();
        int[][] kentanpalikat = kentta.getPalikat();
        for (int i = kentta.getKorkeus()-1; i >= 0; i--){
            for (int j = 0; j < kentta.getLeveys(); j++){
                if (kentanSolut[i][j]){
                    asetaVari(kentanpalikat[i][j], g);
                    g.fill3DRect(x, y, width, height, true);
                }
                g.setColor(ruudukonvari);
                g.drawRect(x, y, width, height);
                x += width;
            }
            x = 0;
            y += height;
        }
    }
    
    private void asetaVari(int numero, Graphics g){
        switch(numero){
            case 0: default:
                g.setColor(palikkaTyhjavari);
                break;
            case 1: 
                g.setColor(palikkaIvari);
                break;
            case 2:               
                g.setColor(palikkaJvari);
                break;
            case 3:
                g.setColor(palikkaLvari);
                break;
            case 4:
                g.setColor(palikkaOvari);
                break;
            case 5:
                g.setColor(palikkaSvari);
                break;
            case 6:
                g.setColor(palikkaTvari);
                break;
            case 7:
                g.setColor(palikkaZvari);
                break;
        }
    }
}
