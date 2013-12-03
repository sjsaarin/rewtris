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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 16));
        g.drawString("Score: "+logiikka.getPisteet(), 10, 18);
        g.drawString("Level: "+logiikka.getTaso(), 230, 18);
        g.drawString(""+logiikka.getKelauksia(), 160, 18);
        piirraKelausIndikaattori(130, 4, g);        
    }
    
    private void piirraKelausIndikaattori(int x, int y, Graphics g){
      
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
