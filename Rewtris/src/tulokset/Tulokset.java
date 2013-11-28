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
     * @return 'true' jos tallennus onnistui, 'false' jos tallennus ei onnistunut
     * 
     */
    public boolean tallennaTulokset() {
        try {
            FileOutputStream fos = new FileOutputStream(TIEDOSTONNIMI);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tulokset);
            oos.close();
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
     * @return 'true' jos lataus onnistui, 'false' jos lataus ei onnistunut
     * 
     */
    public boolean lataaTulokset(){
        try {
            FileInputStream fis = new FileInputStream(TIEDOSTONNIMI);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tulokset = (List<Tulos>) ois.readObject();
            ois.close();
            return true;
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
    /**
     * Palauttaa montako tulosta on tallennettuna
     * 
     * @return tulosten lukumäärä
     */
    public int getKoko(){
        return this.tulokset.size();
    }
    
    /**
     * Palauttaa parhaimman talletetun pisteluvun
     * 
     * @return pisteet
     */
    public int getParhaatPisteet(){
        if (tulokset.isEmpty()){
            return 0;
        } else {
            Tulos tulos = tulokset.get(0);
            return tulos.pisteet;
        }
    }
    
    /**
     * Palauttaa huonoimman talletetun pisteluvun
     * 
     * @return pisteet
     */
    public int getHuonoimmatPisteet(){
        if (tulokset.isEmpty()){
            return 0;
        } else {
            int viimeinen = tulokset.size() - 1;
            Tulos tulos = tulokset.get(viimeinen);
            return tulos.pisteet;
        }
    }
    
    public List getTulokset(){
        return this.tulokset;
    }
    
    public Tulos getTulos(int indeksi){
        return tulokset.get(indeksi);
    }
 
}
