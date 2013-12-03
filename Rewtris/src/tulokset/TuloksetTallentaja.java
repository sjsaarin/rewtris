/*
 * To change this template, choose Tools | Templates
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

/**
 * Luokka tallentaa ja lataa tulokset levylle/levyltä. Tulokset tallenetaan binäärimuodossa ArrayList<Tulos> oliona.
 * 
 * @author Sami-Joonas
 */
public class TuloksetTallentaja {
    
    private static final String TIEDOSTONNIMI = "SCORES";
    private ArrayList<Tulos> tulokset; 
    
    public TuloksetTallentaja(){
        this.tulokset = new ArrayList<>();
    }
            
    /**
     * Tallentaa tulokset levylle
     * 
     * @param tulokset
     * @return 'true' jos tallennus onnistui, 'false' jos tallennus ei onnistunut
     * 
     */
    public boolean tallenna(ArrayList<Tulos> tulokset) {
        try {
            FileOutputStream fos = new FileOutputStream(TIEDOSTONNIMI);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(tulokset);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e){
            return false;
        }
    }
    
    /**
     * Lataa tulokset levyltä
     * 
     * @return ArrayList<Tulos> jos lataus onnistui, 'null' jos lataus ei onnistunut
     */
    public ArrayList<Tulos> lataa(){
        try {
            FileInputStream fis = new FileInputStream(TIEDOSTONNIMI);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                tulokset = (ArrayList<Tulos>) ois.readObject();
            }
            return tulokset;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    
}
