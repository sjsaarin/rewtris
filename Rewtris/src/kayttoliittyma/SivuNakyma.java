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

public class SivuNakyma extends JPanel {
    
    private Logiikka logiikka;
    
    public SivuNakyma(Logiikka logiikka){
        this.logiikka = logiikka;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("Score: "+logiikka.getPisteet(), 30, 30);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        g.drawString("Level: "+logiikka.getTaso(), 30, 60);
        g.drawString("Rewinds:", 30, 150);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        g.drawString(""+logiikka.getKelauksia(), 60, 175);
        
        if (logiikka.getVoikelata()){
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }    
        g.fill3DRect(35, 160, 5, 5, true);
        g.fill3DRect(30, 165, 5, 5, true);
        g.fill3DRect(35, 165, 5, 5, true);
        g.fill3DRect(35, 170, 5, 5, true);
        g.fill3DRect(47, 160, 5, 5, true);
        g.fill3DRect(42, 165, 5, 5, true);
        g.fill3DRect(47, 165, 5, 5, true);
        g.fill3DRect(47, 170, 5, 5, true);
        g.setColor(Color.BLACK);
        //g.drawString("Rewind: "+logiikka.getVoikelata(), 10, 50);
    }
    
}
