/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tulokset.Tulokset;
import tulokset.Tulos;

/**
 * Näyttää 20 parasta tulosta
 * 
 * @author sjsaarin
 */
public class Pistelista extends JPanel {
    
    private Tulokset tulokset;
    private boolean tuloksetladattu;
    
    public Pistelista(){
        setBackground(Color.GRAY);
    }
    
    /**
     * Lataa tallennetut tulokset
     */
    public void lataaPisteet(){
        tulokset = new Tulokset();
        tuloksetladattu = tulokset.lataaTulokset();
        System.out.println(tuloksetladattu);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("High Scores",100 ,20);
        g.drawString("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",10 ,30);
        for (int i = 0; i < 10; i++){
            g.drawString((i+1)+". ", 20, 50+(25*i));
        }
        Tulos tulos;
        for (int i = 0; i < tulokset.getKoko(); i++){
            tulos = tulokset.getTulos(i);
            g.drawString(""+tulos.pisteet, 50, 50+(25*i));
            g.drawString(tulos.nimi, 120, 50+(25*i));
        }
    }
    
}
