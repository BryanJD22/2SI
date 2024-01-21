/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador;

/**
 *
 * @author A10
 */
public class Contador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mi_contador contador = new Mi_contador(0);
        
        for(int i = 0 ; i < 100 ; i++){
            Mi_Thread miThread = new Mi_Thread(contador);
            miThread.start();
        }
    }
    
}
