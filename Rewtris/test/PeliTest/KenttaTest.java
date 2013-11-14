/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PeliTest;

import Peli.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sjsaarin
 */
public class KenttaTest {
    
    Kentta kentta;
    
    @Before
    public void setUp() {
        kentta = new Kentta();
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getKorkeusAntaaOikeanKorkeuden(){
         assertEquals(20, kentta.getKorkeus());
    }
    
    @Test
    public void getLeveysAntaaOikeanLeveyden(){
         assertEquals(10, kentta.getLeveys());
    }
    
    @Test
    public void getRiviTaydellaKentallaAntaaRivinJaRivinKokoOnOikea(){
        kentta.tayta();
        boolean[] rivi = kentta.getRivi(0);
        boolean rivitOikein = true;
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (!rivi[i] == true){
                rivitOikein = false;
            }
        }
        assertEquals(true, rivitOikein);
    }
    
    @Test
    public void getRiviTyhjallaKentallaAntaaRivinJaRivinKokoOnOikea(){
        kentta.tyhjenna();
        boolean[] rivi = kentta.getRivi(0);
        boolean rivitOikein = true;
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (rivi[i] == true){
                rivitOikein = false;
            }
        }
        assertEquals(true, rivitOikein);
    }
    
    @Test 
    public void kentanTyhjennysToimii(){
        
        kentta.tyhjenna();
        boolean rivitOikein = true;
        
        boolean[] rivi = kentta.getRivi(10);
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (rivi[i] == true){
                rivitOikein = false;
            }
        }
        
        rivi = kentta.getRivi(5);
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (rivi[i] == true){
                rivitOikein = false;
            }
        }
        
        assertEquals(true, rivitOikein);
        
    }
    
    @Test
    public void kentanTayttoToimii(){
        
        kentta.tayta();
        boolean rivitOikein = true;
        
        boolean[] rivi = kentta.getRivi(10);
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (!rivi[i] == true){
                rivitOikein = false;
            }
        }
        
        rivi = kentta.getRivi(5);
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (!rivi[i] == true){
                rivitOikein = false;
            }
        }
        
        assertEquals(true, rivitOikein);
        
        
    }
    
    @Test
    public void rivinTyhjennysToimii(){
        kentta.tayta();
        kentta.tyhjennaRivi(5);
        
        boolean[] rivi = kentta.getRivi(19);
        boolean rivitOikein = true;
        for (int i = 0; i < kentta.getLeveys(); i++){
            if (rivi[i] == true){
                rivitOikein = false;
            }
        }
        assertEquals(true, rivitOikein);
        
    }
    
    
}
