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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Alkuvalikko, näytetään kun ohjelma on käynnistetty
 * 
 * @author sjsaarin
 */
public class Alkuvalikko extends JPanel {
    
    Nakyma nakyma;
    static String variprofiili1 = "Dark";
    static String variprofiili2 = "Light";
    static String variprofiili3 = "Monochrome";
    private GridBagConstraints gbc;
    
    public Alkuvalikko(Nakyma nakyma){
        this.nakyma = nakyma;
        alusta();
    }
    
    private void alusta(){
        
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        lisaaVariValikko();
        lisaaAloitaPainike();
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        
        g.drawString("Set game colors:", 50, 220);
        
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("Rewtris", 119, 60);
        g.setColor(Color.GREEN);
        g.fill3DRect(120, 80, 30, 30, true);
        g.fill3DRect(180, 80, 30, 30, true);
        g.fill3DRect(90, 110, 30, 30, true);
        g.fill3DRect(120, 110, 30, 30, true);
        g.fill3DRect(150, 110, 30, 30, true);
        g.fill3DRect(180, 110, 30, 30, true);
        g.fill3DRect(120, 140, 30, 30, true);
        g.fill3DRect(180, 140, 30, 30, true);
        
        g.setColor(Color.BLACK);
        g.drawRect(120, 80, 30, 30);
        g.drawRect(180, 80, 30, 30);
        g.drawRect(90, 110, 30, 30);
        g.drawRect(120, 110, 30, 30);
        g.drawRect(150, 110, 30, 30);
        g.drawRect(180, 110, 30, 30);
        g.drawRect(120, 140, 30, 30);
        g.drawRect(180, 140, 30, 30);
        
    }
    
    private void lisaaAloitaPainike(){
        
        JButton aloitaPainike = new JButton("Start Game");
        
        aloitaPainike.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nakyma.naytaPeli();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        this.add(aloitaPainike, gbc);
        
    }
 
    private void lisaaVariValikko(){
        
        JRadioButton variprofiili1Valinta = new JRadioButton(variprofiili1);
        variprofiili1Valinta.setActionCommand(variprofiili1);
        variprofiili1Valinta.setSelected(true);

        JRadioButton variprofiili2Valinta = new JRadioButton(variprofiili2);
        variprofiili2Valinta.setActionCommand(variprofiili2);

        JRadioButton variprofiili3Valinta = new JRadioButton(variprofiili3);
        variprofiili3Valinta.setActionCommand(variprofiili3);
        
        ButtonGroup varivalinta = new ButtonGroup();
        varivalinta.add(variprofiili1Valinta);
        varivalinta.add(variprofiili2Valinta);
        varivalinta.add(variprofiili3Valinta);
        
        VariValinnanKuuntelija vvk = new VariValinnanKuuntelija();
        
        variprofiili1Valinta.addActionListener(vvk);
        variprofiili2Valinta.addActionListener(vvk);
        variprofiili3Valinta.addActionListener(vvk);
        
        JPanel varivalintapaneeli = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        varivalintapaneeli.add(variprofiili1Valinta, gbc);
        gbc.gridx = 1;
        varivalintapaneeli.add(variprofiili2Valinta, gbc);
        gbc.gridx = 3;
        varivalintapaneeli.add(variprofiili3Valinta, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 10.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        this.add(varivalintapaneeli, gbc);
        
    }
    
    private class VariValinnanKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nakyma.variprofiili = e.getActionCommand();
        }
    }
}
