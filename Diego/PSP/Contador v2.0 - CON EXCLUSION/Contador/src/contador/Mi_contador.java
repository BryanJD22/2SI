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


    // Hago el método incrementar de modo que duerman los hilos un poquito
    // el problema será que al entrar varios a la vez todos verán el valor "0"
    // del contador, dormirán un poquito (dando tiempo al resto a entrar y ver el "0")
    // y posteriormente varios (entre 80 y 90) incrementarán el "0" a la vez poniendo "1" !!!
    // y mi contador NUNCA alcanzará el valor "100" que yo deseo
    //
    // SOLUCIÓN:  Prueba a quitar el comentario del método "synchronized" para que
    // nuestro método sea sincronizado y solo pueda entrar a ejecutarlo UN UNICO HILO
    // de manera simultánea, de este modo el primero que llegue verá el "0" y aunque duerma
    // un poquito NO DEJARÁ a ningún otro entrar mientras él duerme a ejecutar el método
    // y evitaremos que otros procesos lean de manera simultánea el "0", así el siguiente
    // hilo que entre lo hará cuando éste salga del método y podrá leer ya el valor "1"
    // que el primer hilo que accedió habrá modificado.
    
    public /*synchronized*/ int[] incrementar(){
        int[] array = new int[2];
        array[0] = valor();

        Random rand;
        rand = new Random();
        try {
            Thread.sleep(rand.nextInt(100));
        } catch (InterruptedException ex) {
            Logger.getLogger(Mi_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }

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
