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
    
    public PeliNakyma(Kentta kentta, Palikka palikka){
        this.palikka = palikka;
        this.kentta = kentta;
        setBackground(Color.DARK_GRAY);
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
    }
    
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
                g.setColor(Color.BLACK);
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
                g.setColor(Color.WHITE);
                break;
            case 1: 
                g.setColor(Color.CYAN);
                break;
            case 2:               
                g.setColor(Color.MAGENTA);
                break;
            case 3:
                g.setColor(Color.PINK);
                break;
            case 4:
                g.setColor(Color.RED);
                break;
            case 5:
                g.setColor(Color.GREEN);
                break;
            case 6:
                g.setColor(Color.BLUE);
                break;
            case 7:
                g.setColor(Color.YELLOW);
                break;
        }
    }
}
