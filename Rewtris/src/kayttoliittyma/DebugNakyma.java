/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import peli.Kentta;
import peli.Palikka;

/**
 * Debuggaukseen
 * 
 * @author sjsaarin
 */
public class DebugNakyma extends JPanel {
    private Palikka palikka;
    private Kentta kentta;
    
    public DebugNakyma(Kentta kentta, Palikka palikka){
        this.palikka = palikka;
        this.kentta = kentta;
        setBackground(Color.YELLOW);
        setVisible(true);
    }
    
    //public void vastaanOtaViesti(String viesti){
    //    this.viesti = viesti;
    //    this.repaint();
    //}
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
    }
        
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        g.drawString("Debug paneeli:", 10, 20);
        g.drawString("Palikan X: "+palikka.getX(), 10, 50);
        g.drawString("Palikan Y: "+palikka.getY(), 10, 70);
        g.drawString("Palikan koko: "+palikka.getKoko(), 10, 100);
        g.drawString("Kentän leveys: "+kentta.getLeveys(), 10, 150);
        g.drawString("Kentän korkeus: "+kentta.getKorkeus(), 10, 170);
        g.drawString("Nuoli oikealle: oikealle", 10, 380);
        g.drawString("Nuoli vasemmalle: vasemmalle", 10, 400);
        g.drawString("Nuoli ylös: palikan kääntö", 10, 420);
        g.drawString("Nuoli alas: palikka alas", 10, 440);
        g.drawString("Välilyönti: palikan tiputus + uusi palikka", 10, 460);
        g.drawString("R: kelaa takaisin (buginen)", 10, 480);

    }
}
