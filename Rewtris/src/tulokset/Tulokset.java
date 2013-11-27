/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

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
 * Luokka vastaa pelitulosten tallennuksesta, tallentaa 20 parasta tulosta.
 * 
 * @author sjsaarin
 */
public class Tulokset {
    
    private List<Tulos> tulokset;
    private final String TIEDOSTONNIMI = "SCORES";
    
    public Tulokset(){
        tulokset = new ArrayList<>();
    }
    
    /**
     * Lisää tuloksen. Jos listassa on tämän jälkeen enemmän kuin 20 tulosta, poistetaan viimeinen.
     * 
     * @param tulos
     */
    public void lisaaTulos(Tulos tulos){
        tulokset.add(tulos);
        Collections.sort(tulokset);
        if (tulokset.size()>20){
            tulokset.remove(20);
        }
    }
    
    /**
     * Tallentaa tulokset levylle
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void tallennaTulokset() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(TIEDOSTONNIMI);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tulokset);
        oos.close();
    }
    
    /**
     * Lataa tulokset levyltä
     * 
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void lataaTulokset() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(TIEDOSTONNIMI);
        ObjectInputStream ois = new ObjectInputStream(fis);
        tulokset = (List<Tulos>) ois.readObject();
        ois.close();
    }
    
    public List getTulokset(){
        return this.tulokset;
    }
 
}
