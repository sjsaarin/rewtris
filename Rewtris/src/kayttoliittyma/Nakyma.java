/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.BorderLayout;
import peli.Kentta;
import peli.Palikka;
import java.awt.Color;
import javax.swing.JFrame;


/**
 * Luokka vastaa pelin 
 * 
 * @author sjsaarin
 */
public class Nakyma extends JFrame {
    
    Palikka palikka;
    Kentta kentta;
    PeliNakyma peliNakyma;
    public DebugNakyma debugNakyma;
    
    public Nakyma(Palikka palikka, Kentta kentta){
        this.palikka = palikka;
        this.kentta = kentta;
        this.setSize(700, 700);
        this.setTitle("Rewtris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        peliNakyma = new PeliNakyma(kentta, palikka);
        peliNakyma.setVisible(true);
        debugNakyma = new DebugNakyma(kentta, palikka);
        debugNakyma.setVisible(true);
    }
    
    public void paivita(Palikka palikka, Kentta kentta){
        this.palikka = palikka;
        this.kentta = kentta;
        peliNakyma = new PeliNakyma(kentta, palikka);
        peliNakyma.setLocation(20, 20);
        peliNakyma.setSize(302, 602);
        //peliNakyma.setBackground(Color.yellow);
        add(peliNakyma, BorderLayout.WEST);
        peliNakyma.repaint();
        paivitaDebug();
       
    }
    
    
    //debug paneeli
    public void paivitaDebug(){
        debugNakyma = new DebugNakyma(kentta, palikka);
        debugNakyma.setLocation(370, 20);
        debugNakyma.setSize(302, 602);
        add(debugNakyma, BorderLayout.EAST);
        debugNakyma.repaint();
    }
    
        
    
    
    /*
    public Nakyma(Kentta kentta, Palikka palikka){
        this.palikka = palikka;
        this.kentta = kentta;
        nakyma = new Frame(kentta, palikka);
        nakyma.setLocationRelativeTo(null);
        nakyma.setVisible(true);
    }
    
    public void paivita(Kentta kentta, Palikka palikka){
        nakyma.paivita(palikka, kentta);
    }
    
    /
    / Toistaiseksi tilanteen piirto konsoliin, korvataan myöhemmin graafisella nakymällä
    / !! ei tomi vielä !!
    
    public void piirra(){
        boolean[] kentanRivi;
        boolean[][] palikanSolut = palikka.getSolut();
        int palikanY = palikka.getY();
        int palikanX = palikka.getX();
        for (int i = kentta.getKorkeus()-1; i >= 0; i--){
            kentanRivi = kentta.getRivi(i);
            for (int j = 0; j < kentta.getLeveys(); j++){
                if (((j - palikanX >= 0) && (j - palikanX < palikka.getKoko())) && ((i - palikanY >= 0) && (i - palikanY < palikka.getKoko()))){
                    if (palikanSolut[i-palikanX][j-palikanY]) {
                        System.out.print("O");
                    } else { 
                    if (kentanRivi[j]){
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
                    
                } else { 
                    if (kentanRivi[j]){
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
    */
}
