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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.border.EtchedBorder;
import peli.Logiikka;


/**
 * Luokka vastaa pelin graafisesta nakymasta 
 * 
 * @author sjsaarin
 */
public class Nakyma extends JFrame {
    
    private Ohjaus ohjaus;
    private Palikka palikka;
    private Kentta kentta;
    private Logiikka logiikka;
    private SivuNakyma sivunakyma;
    private Pistelista pistelista;
    private PeliNakyma pelinakyma;
    private JPanel paneeli;
    //private DebugNakyma debugnakyma;
    private Alkuvalikko alkuvalikko;
    private GridBagConstraints gbc;
    
    public Nakyma(Palikka palikka, Kentta kentta, Logiikka logiikka){
        this.palikka = palikka;
        this.kentta = kentta;
        this.logiikka = logiikka;
        alusta();
    }
    
    private void alusta(){
        this.setSize(650, 700);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Rewtris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        alkuvalikko = new Alkuvalikko(this);
        pistelista = new Pistelista();
        
        pelinakyma = new PeliNakyma(kentta, palikka);
        sivunakyma = new SivuNakyma(logiikka);
        
        paneeli = new JPanel(new GridBagLayout());
        this.getContentPane().add(paneeli);
        
        ohjaus = new Ohjaus(logiikka);
        
        naytaAlkuvalikko();
        
        this.setVisible(true);
    }
    
    /**
     * Näyttää alkuvalikon
     */
    public void naytaAlkuvalikko(){
        gbc = new GridBagConstraints();
        
        alkuvalikko.setPreferredSize(new Dimension(300,600));
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        paneeli.add(alkuvalikko, gbc);
        
        pistelista.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pistelista.setPreferredSize(new Dimension(300,600));
        
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        paneeli.add(pistelista, gbc);
        
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        //this.requestFocus();
        this.repaint();
        
    }
    
    /**
     * Poistaa alkuvalikon näkymästä
     */
    public void poistaAlkuvalikko()
    {
        System.out.println("poista alkuvalikko");
        paneeli.remove(alkuvalikko);
        paneeli.remove(pistelista);
    }
    
    /**
     * piirtää pelinäkymän
     */ 
    public void naytaPeli(){
        
        System.out.println("nayta peli kutsuttu");
        poistaAlkuvalikko();
        
        pelinakyma.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pelinakyma.setPreferredSize(new Dimension(300,600));
    
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
  
        paneeli.add(pelinakyma, gbc);
        
        sivunakyma.setPreferredSize(new Dimension(300,600));
    
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        gbc.gridy = 0;
  
        paneeli.add(sivunakyma, gbc);
       
        this.addKeyListener(ohjaus);
        
        logiikka.aloitaPeli();
        System.out.println("peli aloitettu");
        
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        
        this.setFocusable(true);
        this.requestFocus();
        
        //paivita();
        
    }
    
    /**
     * Poistaa pelinäkymän
     */
    public void poistaPeli(){
        paneeli.remove(pelinakyma);
        paneeli.remove(sivunakyma);
        this.removeKeyListener(ohjaus);
    }
    
    /**
     * päivittää pelinäkymän
     */
    public void paivita(){
        
        pelinakyma.repaint();
        sivunakyma.repaint();
        
    }
    
    public void peliOhi(){
        int response = JOptionPane.showConfirmDialog(null, "Start a new game?", "GAME OVER",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
            System.out.println("No button clicked");
            poistaPeli();
            naytaAlkuvalikko();
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Yes button clicked");
            logiikka.aloitaPeli();
        }
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
        pelinakyma.setPalikka(palikka);
        
    }
    
}
