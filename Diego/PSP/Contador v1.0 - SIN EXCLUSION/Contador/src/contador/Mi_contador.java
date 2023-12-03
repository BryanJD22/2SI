/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A10
 */
public class Mi_contador {
    private int c = 0;
    
    
    public Mi_contador(int valor_inicial)
    {
        this.c = valor_inicial;
        
    }
    
    private int valor()
    {
        return c;
    }



    public  int[] incrementar(){
        int[] array = new int[2];
        array[0] = valor();

        /*Random rand;
        rand = new Random();
        try {
            Thread.sleep(rand.nextInt(100));
        } catch (InterruptedException ex) {
            Logger.getLogger(Mi_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        c = array[0] +1;
        array[1] = valor();
        return array;
    }
    
    public  int[] decrementar(){
        // Si hay error devolveré (-1, -1) caso imposible de alcanzar
        // cuando decremento realmente.
        
        int[] array = new int[2];
            
          array[0] = valor();
          c = array[0]-1;
          array[1] = valor();
        
        return array;
    }
    
    
}
