/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import peli.Logiikka;

/**
 * Luokka vastaa pistetilanteen ja muun tiedon piirtämisestä näkymään
 * 
 * @author sjsaarin
 */

public class PisteNakyma extends JPanel {
    
    private Logiikka logiikka;
    private JLabel pisteLabel;
    private JLabel tasoLabel;
    
    public PisteNakyma(Logiikka logiikka){
        this.logiikka = logiikka;
        alusta();
    }
    
    private void alusta(){
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        pisteLabel = new JLabel();
        pisteLabel.setFont(this.getFont().deriveFont(Font.BOLD, 16));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        this.add(pisteLabel, gbc);
        pisteLabel.setText("Score: ");
        
        tasoLabel = new JLabel();
        tasoLabel.setFont(this.getFont().deriveFont(Font.BOLD, 16));
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        this.add(tasoLabel, gbc);
        tasoLabel.setText("Level: ");
        
        paivita();
        
    }
    
    /**
     * Päivittää pisteet, tason ja kelausten tilan
     */
    public void paivita(){
        pisteLabel.setText("Score: "+logiikka.getPisteet());
        tasoLabel.setText("Level: "+logiikka.getTaso());
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 16));
        g.drawString(""+logiikka.getKelauksia(), 160, 21);
        piirraKelausIndikaattori(130, 7, g);        
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
