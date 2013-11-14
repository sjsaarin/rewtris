/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokeiluja;

import Peli.Palikka;
import Peli.PalikkaI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author sjsaarin
 */
public class Panel extends JPanel {
    
    int height = 15;
    int width = 15;
    
    Palikka palikka = new PalikkaI();
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        //g.drawRect(50, 50, width, height);
        //g.drawRect(55, 50, width, height);
        int x = 60;
        int y = 60;
        palikka.kaannaPalikkaa();
        boolean[][] koordinaatit = palikka.getSolut();
        for (int i = 0; i < palikka.getKoko(); i++){
            for (int j = 0; j < palikka.getKoko(); j++){
                if (koordinaatit[i][j]){
                    g.drawRect(x, y, width, height);
                }
                x += 15;
            }
            x = 60;
            y += 15;
        }
    }
}
