/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kokeiluja;

/**
 *
 * @author sjsaarin
import Peli.Panel;
 */

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JFrame {


    public Frame() {

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel();
        panel.setLocation(0, 200);
        panel.setSize(150, 150);
        getContentPane().add(panel);
   }


    public static void main(String[] args) {

        Frame nakyma = new Frame();
        nakyma.setLocationRelativeTo(null);
        nakyma.setVisible(true);

    } 
}
    
