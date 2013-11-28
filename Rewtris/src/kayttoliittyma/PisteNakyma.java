/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import peli.Logiikka;

/**
 * Luokka vastaa pistetilanteen ja muun tiedon piirtämisestä näkymään
 * 
 * @author sjsaarin
 */

public class PisteNakyma extends JPanel {
    
    private Logiikka logiikka;
    
    public PisteNakyma(Logiikka logiikka){
        this.logiikka = logiikka;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        g.drawString("Score: "+logiikka.getPisteet(), 5, 15);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        g.drawString("Level: "+logiikka.getTaso(), 235, 15);
        g.drawString("Rewinds:", 5, 150);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        g.drawString(""+logiikka.getKelauksia(), 160, 15);
        piirraPalikat(130, 1, g);
        
        
    }
    
    private void piirraPalikat(int x, int y, Graphics g){
      
        if (logiikka.getVoikelata()){
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }    
        g.fill3DRect(x+5, y, 5, 5, true);
        g.fill3DRect(x, y+5, 5, 5, true);
        g.fill3DRect(x+5, y+5, 5, 5, true);
        g.fill3DRect(x+5, y+10, 5, 5, true);
        g.fill3DRect(x+17, y, 5, 5, true);
        g.fill3DRect(x+12, y+5, 5, 5, true);
        g.fill3DRect(x+17, y+5, 5, 5, true);
        g.fill3DRect(x+17, y+10, 5, 5, true);
        g.setColor(Color.BLACK);
        
    }
    
}
