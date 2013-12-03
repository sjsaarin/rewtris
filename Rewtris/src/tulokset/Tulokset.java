/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tulokset;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka vastaa pelitulosten tallennuksesta, tallentaa 10 parasta tulosta.
 * Tulokset Tallenetaan Tulos olioita sisältävänä ArrayList oliona.
 * 
 * @author sjsaarin
 */
public class Tulokset {
    
    private ArrayList<Tulos> tulokset;
    private final String TIEDOSTONNIMI = "SCORES";
    private final TuloksetTallentaja tallentaja;
    
    public Tulokset(){
        tulokset = new ArrayList<>();
        tallentaja = new TuloksetTallentaja();
    }
    
    /**
     * Lisää tuloksen. Jos listassa on tämän jälkeen enemmän kuin 10 tulosta, poistetaan viimeinen.
     * 
     * @param tulos
     */
    public void lisaaTulos(Tulos tulos){
        tulokset.add(tulos);
        Collections.sort(tulokset);
        if (tulokset.size()>10){
            tulokset.remove(10);
        }
    }
    
    /**
     * Tallentaa tulokset
     * 
     * @return 'true' jos tallennus onnistui, 'false' jos tallennus ei onnistunut
     * 
     */
    public boolean tallennaTulokset() {
        return tallentaja.tallenna(tulokset);
    }
    
    /**
     * Lataa tulokset
     * 
     * @return 'true' jos lataus onnistui, 'false' jos lataus ei onnistunut
     * 
     */
    public boolean lataaTulokset(){
        tulokset = tallentaja.lataa();
        return tulokset != null;
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
    
    public Tulos getTulos(int indeksi){
        return tulokset.get(indeksi);
    }
    
    public ArrayList<Tulos> getTulokset(){
        return this.tulokset;
    }
 
}
