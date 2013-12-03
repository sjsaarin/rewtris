/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Dimension;
import peli.Kentta;
import peli.Palikka;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DocumentFilter;
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
    private PisteNakyma sivunakyma;
    private Pistelista pistelista;
    private PeliNakyma pelinakyma;
    private JPanel paneeli;
    private Alkuvalikko alkuvalikko;
    private GridBagConstraints gbc;
    private Timer peliajastin;
    private final int paivitystiheys = 33;
    
    public Nakyma(Palikka palikka, Kentta kentta, Logiikka logiikka){
        this.palikka = palikka;
        this.kentta = kentta;
        this.logiikka = logiikka;
        alusta();
    }
    
    private void alusta(){
        this.setSize(320, 680);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Rewtris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        alkuvalikko = new Alkuvalikko(this);
        pistelista = new Pistelista();
        
        pelinakyma = new PeliNakyma(kentta, palikka);
        sivunakyma = new PisteNakyma(logiikka);
        
        paneeli = new JPanel(new GridBagLayout());
        this.getContentPane().add(paneeli);
        
        ohjaus = new Ohjaus(logiikka);
        
        peliajastin = new javax.swing.Timer(paivitystiheys, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              pelinakyma.repaint();
          }
        });
        
        naytaAlkuvalikko();
        
        this.setVisible(true);
    }
    
    /**
     * Näyttää alkuvalikon
     */
    public void naytaAlkuvalikko(){
        gbc = new GridBagConstraints();
        
        alkuvalikko.setPreferredSize(new Dimension(300,300));
        
        gbc.insets = new Insets(5,5,15,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        paneeli.add(alkuvalikko, gbc);
        
        pistelista.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pistelista.setPreferredSize(new Dimension(270,300));
        
        gbc.insets = new Insets(15,5,15,5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        paneeli.add(pistelista, gbc);
        pistelista.lataaPisteet();
        
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        this.repaint();
        
    }
    
    /**
     * Poistaa alkuvalikon näkymästä
     */
    public void poistaAlkuvalikko()
    {
        paneeli.remove(alkuvalikko);
        paneeli.remove(pistelista);
    }
    
    /**
     * Näyttää pelinäkymän
     */ 
    public void naytaPeli(){
        
        poistaAlkuvalikko();
        
        sivunakyma.setPreferredSize(new Dimension(300,30));
    
        gbc.insets = new Insets(1,1,1,1);
        gbc.gridx = 0;
        gbc.gridy = 0;
  
        paneeli.add(sivunakyma, gbc);
    
        pelinakyma.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pelinakyma.setPreferredSize(new Dimension(300,600));
        
        gbc.insets = new Insets(4,1,1,1);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
  
        paneeli.add(pelinakyma, gbc);
        
        this.addKeyListener(ohjaus);
        
        logiikka.aloitaPeli();
        
        this.getContentPane().invalidate();
        this.getContentPane().validate();
        
        this.setFocusable(true);
        this.requestFocus();
        
        peliajastin.start();
        
        paivita();
        
    }
    
    /**
     * Poistaa pelinäkymän
     */
    public void poistaPeli(){
        peliajastin.stop();
        paneeli.remove(pelinakyma);
        paneeli.remove(sivunakyma);
        this.removeKeyListener(ohjaus);
    }
    
    /**
     * Päivittää pistenäkymän
     */
    public void paivita(){
        
        //pelinakyma.repaint();
        sivunakyma.repaint();
        
    }
    
    /**
     * Näyttää 'Game Over' ilmoituksen ja kysyy pelaajalta haluaako pelata uudestaan.
     */
    public void peliOhi(){
        int vastaus = JOptionPane.showConfirmDialog(this, "Start a new game?", "GAME OVER",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (vastaus == JOptionPane.NO_OPTION || vastaus == JOptionPane.CLOSED_OPTION) {
            poistaPeli();
            naytaAlkuvalikko();
        } else if (vastaus == JOptionPane.YES_OPTION) {
            logiikka.aloitaPeli();
            paivita();
        }
    }
    
    /**
     * Näyttää 'High Score' ilmoituksen ja kysyy pelaajan nimeä. 
     * Palautetaan merkkijono jossa on enintään 15 ensimmäistä merkkiä syötetystä nimestä.
     * 
     * @return nimi
     */
    public String peliOhiJaOnHighScore(){
 
        String vastaus = (String)JOptionPane.showInputDialog(this, "Congratulations!\n"
                                                                  +"You got a high score.\n\n"
                                                                  +"Enter your name:",
                                                                  "HIGH SCORE",
                                                                JOptionPane.PLAIN_MESSAGE);
        if ( vastaus == null || vastaus.length() < 16){
            return vastaus;
        } else {
            return vastaus.substring(0, 15);
        }
    }
    
    public void setPalikka(Palikka palikka){
        this.palikka = palikka;
        pelinakyma.setPalikka(palikka);
        
    }
    
}
