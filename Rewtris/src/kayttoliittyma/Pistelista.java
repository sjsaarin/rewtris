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
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tulokset.Tulokset;
import tulokset.Tulos;

/**
 * Näyttää 10 parasta tulosta
 * 
 * @author sjsaarin
 */
public class Pistelista extends JPanel {
    
    private Tulokset tulokset;
    
    public Pistelista(){
        setBackground(Color.GRAY);
        alusta();
    }
    
    private void alusta(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel highscoresLabel = new JLabel("High Scores");
        highscoresLabel.setFont(this.getFont().deriveFont(Font.BOLD, 14));
        highscoresLabel.setForeground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.insets = new Insets(3,3,3,3);
        gbc.anchor = GridBagConstraints.PAGE_START;
        this.add(highscoresLabel, gbc);
        highscoresLabel.setVisible(true);
    }
    
    /**
     * Lataa tallennetut tulokset
     */
    public void lataaPisteet(){
        tulokset = new Tulokset();
        tulokset.lataaTulokset();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        g.setColor(Color.GREEN);
        g.setFont(g.getFont().deriveFont(Font.BOLD));
        g.drawString("High Scores",100 ,20);
        */
        g.setColor(Color.WHITE);
        g.drawLine(10, 30, 260, 30);
        for (int i = 0; i < 10; i++){
            g.drawString((i+1)+". ", 20, 50+(25*i));
        }
        g.setFont(g.getFont().deriveFont(Font.PLAIN));
        Tulos tulos;
        for (int i = 0; i < tulokset.getKoko(); i++){
            tulos = tulokset.getTulos(i);
            g.drawString(""+tulos.pisteet, 50, 50+(25*i));
            g.drawString(tulos.nimi, 130, 50+(25*i));
        }
    }
    
}
