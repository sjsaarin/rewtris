/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Peli;

/**
 *
 * @author sjsaarin
 */
public class Palikka {
    
    private final int[][][] palikkaI = new int[][][]{
        { {1,0}, {1,1}, {1,2}, {1,3} },
        { {0,2}, {1,2}, {2,2}, {3,2} },
        { {2,0}, {2,1}, {2,2}, {2,3} },
        { {0,1}, {1,1}, {2,1}, {3,1} }
   };
    
   private final int[][][] palikkaL = new int[][][]{
        { {1,0}, {1,1}, {1,2}, {2,0} },
        { {0,0}, {0,1}, {1,1}, {2,1} },
        { {0,2}, {1,0}, {1,1}, {1,2} },
        { {0,1}, {1,1}, {2,1}, {2,2} }
   };
   
   private final int[][][] palikkaJ = new int[][][]{
        { {0,0}, {1,0}, {1,1}, {1,2} },
        { {0,1}, {0,2}, {1,1}, {2,1} },
        { {1,0}, {1,1}, {1,2}, {2,2} },
        { {0,1}, {1,1}, {2,0}, {2,1} }
   };
   
   private final int[][][] palikkaS = new int[][][]{
        { {0,0}, {1,0}, {1,1}, {2,1} },
        { {0,1}, {0,2}, {1,0}, {1,1} },
        { {0,1}, {1,1}, {1,2}, {2,2} },
        { {1,1}, {1,2}, {2,0}, {2,1} }
   };
   
   private final int[][][] palikkaZ = new int[][][]{
        { {0,1}, {1,0}, {1,1}, {2,0} },
        { {0,0}, {0,1}, {1,1}, {1,2} },
        { {0,2}, {1,1}, {1,2}, {2,1} },
        { {1,0}, {1,1}, {2,1}, {2,2} }
   };
   
   private int[][][] palikkaT = new int[][][]{
       { {0,1}, {1,0}, {1,1}, {2,1} },
       { {0,1}, {1,0}, {1,1}, {1,2} },
       { {0,1}, {1,1}, {1,2}, {2,1} },
       { {1,0}, {1,1}, {1,2}, {2,1} }
   };
   
   private int[][][] palikkaO = new int[][][]{
       { {1,0}, {1,1}, {2,0}, {2,1} }
   };
   
   private int[][][][] palikat = new int[][][][]{
       palikkaI, palikkaL, palikkaJ, palikkaS, palikkaZ, palikkaT, palikkaO
   };
   
   private int palikanTyyppi;
   private int asento;
   
   public Palikka(int tyyppi) {
       setTyyppi(tyyppi);
       asento = 0;
   }
   
   private void setTyyppi(int tyyppi){
        this.palikanTyyppi = tyyppi;
   }
   
   private int getTyyppi(){
       return this.palikanTyyppi;
   }
   
   private void setAsento(int asento){
       this.asento = asento;
   }
   
   public int[][] getKoordinaatit(){
       return palikat[palikanTyyppi][asento];
   }
   
   public Palikka kaanna(){
       int asento;
       if (palikanTyyppi == 6){
        return this;
       }
       if (this.asento == 3){
           asento = 0;
       } else {
           asento = this.asento+1;
       }
       Palikka uusiPalikka = new Palikka(palikanTyyppi);
       uusiPalikka.setAsento(asento);
       return uusiPalikka;
   }
        
}
