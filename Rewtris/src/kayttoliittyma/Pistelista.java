/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Näyttää 20 parasta tulosta
 * 
 * @author sjsaarin
 */
public class Pistelista extends JPanel {
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Tähän tulee highscore lista", 20, 20);
    }
    
}
