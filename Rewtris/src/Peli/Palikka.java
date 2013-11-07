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
    
    /*
    * Palikoiden määrittelyt
    */
    private final int[][][] palikkaI = new int[][][]{
        { {-2,0}, {-1,0}, {0,0}, {1,0} },
        { {0,1}, {0,0}, {0,-1}, {0,-2} },
        { {-2,-1}, {-1,-1}, {0,-1}, {1,-1} },
        { {-1,1}, {-1,0}, {-1,-1}, {-1,-2} }
   };
    
   private final int[][][] palikkaL = new int[][][]{
        { {-1,0}, {-1,-1}, {0,0}, {1,0} },
        { {-1,1}, {0,1}, {0,0}, {0,-1} },
        { {-1,0}, {0,0}, {1,1}, {1,0} },
        { {0,1}, {0,0}, {0,-1}, {1,-1} }
   };
   
   private final int[][][] palikkaJ = new int[][][]{
        { {-1,1}, {-1,0}, {0,0}, {1,0} },
        { {0,1}, {0,0}, {0,-1}, {1,1} },
        { {-1,0}, {0,0}, {1,0}, {1,-1} },
        { {-1,-1}, {0,1}, {0,0}, {0,-1} }
   };
   
   private final int[][][] palikkaS = new int[][][]{
        { {-1,0}, {0,1}, {0,0}, {1,1} },
        { {0,1}, {0,0}, {1,0}, {1,-1} },
        { {-1,-1}, {0,0}, {0,-1}, {1,0} },
        { {-1,1}, {-1,0}, {0,0}, {0,-1} }
   };
   
   private final int[][][] palikkaZ = new int[][][]{
        { {-1,1}, {0,1}, {0,0}, {1,0} },
        { {0,0}, {0,-1}, {1,1}, {1,0} },
        { {-1,0}, {0,0}, {0,-1}, {1,-1} },
        { {-1,0}, {-1,-1}, {0,1}, {0,0} }
   };
   
   private final int[][][] palikkaT = new int[][][]{
       { {-1,0}, {0,1}, {0,0}, {1,0} },
       { {0,1}, {0,0}, {0,-1}, {1,0} },
       { {-1,0}, {0,0}, {0,-1}, {0,0} },
       { {-1,0}, {0,1}, {0,0}, {0,-1} }
   };
   
   private final int[][][] palikkaO = new int[][][]{
       { {-1,0}, {-1,-1}, {0,0}, {0,-1} }
   };
   
   /*
   * Taulukko jossa eri palikat, indeksissä:
   *
   * [0] I-palikka
   * [1] L-palikka
   * [2] J-palikka
   * [3] S-palikka
   * [4] Z-palikka
   * [5] T-palikka
   * [6] O-palikka
   *
   */
   private int[][][][] palikat = new int[][][][]{
       palikkaI, palikkaL, palikkaJ, palikkaS, palikkaZ, palikkaT, palikkaO
   };
   
   private int tyyppi;
   private int asento;
   
   public Palikka(int tyyppi) {
       this.tyyppi = tyyppi;
       this.asento = 0;
   }
   
   public int[][] getKoordinaatit(){
       return palikat[tyyppi][asento];
   }
   
   /*
   * Kääntää palikkaa myötäpäivään ja palautta uuden palikan uudella asennolla
   */
   public Palikka kaanna(){
       int asento;
       //jos palikka on O-palikka ei tehdä mitään ja palautetaan alkuperäinen olio
       if (tyyppi == 6){
        return this;
       }
       if (this.asento == 3){
           asento = 0;
       } else {
           asento = this.asento+1;
       }
       Palikka uusiPalikka = new Palikka(tyyppi);
       uusiPalikka.setAsento(asento);
       return uusiPalikka;
   }
   
   private void setAsento(int asento){
       this.asento = asento;
   }
        
}
