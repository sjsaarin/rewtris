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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sjsaarin
 */
public class Alkuvalikko extends JPanel {
    
    Nakyma nakyma;
    
    public Alkuvalikko(Nakyma nakyma){
        this.nakyma = nakyma;
        alusta();
    }
    
    private void alusta(){
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JButton aloitaPainike = new JButton("Start Game");
        
        aloitaPainike.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nakyma.naytaPeli();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        this.add(aloitaPainike, gbc);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("Rewtris", 117, 80);
        g.setColor(Color.GREEN);
        g.fill3DRect(120, 100, 30, 30, true);
        g.fill3DRect(180, 100, 30, 30, true);
        g.fill3DRect(90, 130, 30, 30, true);
        g.fill3DRect(120, 130, 30, 30, true);
        g.fill3DRect(150, 130, 30, 30, true);
        g.fill3DRect(180, 130, 30, 30, true);
        g.fill3DRect(120, 160, 30, 30, true);
        g.fill3DRect(180, 160, 30, 30, true);
    }
    
}
