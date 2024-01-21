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
 * @author dgenzor
 */
public class Mi_Thread extends Thread{
   private Mi_contador contador;
    
    public Mi_Thread(Mi_contador contador){

        this.contador = contador;
    }
    
    @Override
    public void run(){
        int[] array_mio = contador.incrementar();
                       
        System.out.println("El valor antes de incrementar es: "+ array_mio[0]+" y el valor después es: "+array_mio[1] );
        /*do{
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(100));
                        } catch (InterruptedException ex) {
                Logger.getLogger(Mi_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            array_mio = contador.decrementar();
            if (array_mio[0]==-1 && array_mio[1]==-1){
                System.out.println("Estoy intentando decrementar y NO PUEDORL !!");
            }
        }while (array_mio[0]==-1 && array_mio[1]==-1);
        
        System.out.println("El valor antes de decrementar es: "+ array_mio[0]+" y el valor después es: "+array_mio[1] );
    */
    }

}

