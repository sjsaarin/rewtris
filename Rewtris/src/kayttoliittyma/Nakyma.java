/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import peli.Kentta;
import peli.Palikka;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


/**
 * Luokka vastaa pelin 
 * 
 * @author sjsaarin
 */
public class Nakyma extends JFrame {
    
    private Palikka palikka;
    private Kentta kentta;
    private PeliNakyma pelinakyma;
    private DebugNakyma debugnakyma;
    
    public Nakyma(Palikka palikka, Kentta kentta){
        this.palikka = palikka;
        this.kentta = kentta;
        alusta();
    }
    
    private void alusta(){
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Rewtris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel paneeli = new JPanel(new GridBagLayout());
        this.getContentPane().add(paneeli);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        pelinakyma = new PeliNakyma(kentta, palikka);
        pelinakyma.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pelinakyma.setPreferredSize(new Dimension(300,600));
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        paneeli.add(pelinakyma, gbc);
        
        debugnakyma = new DebugNakyma(kentta, palikka);
        debugnakyma.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        debugnakyma.setPreferredSize(new Dimension(300,600));
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        paneeli.add(debugnakyma, gbc);      
        
        this.setVisible(true);
    }
    
    public void paivita(){
        
        pelinakyma.repaint();
        paivitaDebug();
       
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
        pelinakyma.setPalikka(palikka);
    }
    
    //debug paneeli
    private void paivitaDebug(){
        debugnakyma.repaint();
    }
    
}
