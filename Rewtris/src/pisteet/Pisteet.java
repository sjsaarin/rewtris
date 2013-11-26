/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pisteet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luokka vastaa pisteiden tallennuksesta, tallentaa 20 parasta tulosta.
 * 
 * @author sjsaarin
 */
public class Pisteet {
    
    private List<Piste> pisteet;
    private final String TIEDOSTONNIMI = "PISTEET";
    
    public Pisteet(){
        pisteet = new ArrayList<>();
    }
    
    /**
     * Lisää tuloksen
     * 
     * @param piste 
     */
    public void lisaaPiste(Piste piste){
        pisteet.add(piste);
        Collections.sort(pisteet);
    }
    
    /**
     * Tallentaa pisteet levylle
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void tallennaPisteet() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(TIEDOSTONNIMI);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pisteet);
        oos.close();
    }
    
    /**
     * Lataa pisteet levyltä
     * 
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void lataaPisteet() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(TIEDOSTONNIMI);
        ObjectInputStream ois = new ObjectInputStream(fis);
        pisteet = (List<Piste>) ois.readObject();
        ois.close();
    }
    
    public List getPisteet(){
        return this.pisteet;
    }
 
}
