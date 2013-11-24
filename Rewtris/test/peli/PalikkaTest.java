/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import java.util.Arrays;
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
public class PalikkaTest{
    
    Palikka palikkaO;
    Palikka palikkaI;
    Palikka palikkaJ;
    Palikka palikkaL;
    Palikka palikkaT;
    Palikka palikkaS;
    Palikka palikkaZ; 
    
    @Before
    public void setUp() {
        palikkaO = new PalikkaO();
        palikkaI = new PalikkaO();
        palikkaJ = new PalikkaO();
        palikkaL = new PalikkaO();
        palikkaT = new PalikkaO();
        palikkaS = new PalikkaO();
        palikkaZ = new PalikkaO();
        
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void xKoordinaatinAsetusToimii(){
        palikkaO.setX(10);
        assertEquals(10, palikkaO.getX());
    }
    
    @Test
    public void yKoordinaatinAsetusToimii(){
        palikkaO.setY(10);
        assertEquals(10, palikkaO.getY());
    }
    
    public void getKokoAntaaKoonOikein(){
        assertEquals(2, palikkaO.getKoko());
    }
    
    @Test
    public void getSolutToimii(){
        boolean solut[][] = palikkaO.getSolut();
        boolean onOikein = true;
        for (int i = 0; i<palikkaO.getKoko(); i++){
            for (int j = 0; j<palikkaO.getKoko(); j++){
                if (solut[i][j] == false){
                    onOikein = false;
                }
            }
        }
        assertEquals(true, onOikein);
    }
    
    @Test
    public void palikoideKaantoToimii(){
        
        palikkaO.kaanna();
        palikkaI.kaanna();
        palikkaJ.kaanna();
        palikkaL.kaanna();
        palikkaS.kaanna();
        palikkaZ.kaanna();
        palikkaT.kaanna();
        
        boolean solut[][] = palikkaO.getSolut();
        boolean onOikein = true;
        for (int i = 0; i<palikkaO.getKoko(); i++){
            for (int j = 0; j<palikkaO.getKoko(); j++){
                if (solut[i][j] == false){
                    onOikein = false;
                }
            }
        }
        assertEquals(true, onOikein);
        
    }      
    
}
