import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MisAlumnos extends Thread implements Runnable{
    String numAlum;


    public MisAlumnos(String numAlum ){
        this.numAlum = numAlum;

    }

    @Override
    public void run() {
        Random random = new Random();
        int[] examen = new int[5];

        examen[0] = 10;
        examen[1] = 12;
        examen[3] = 15;
        examen[4] = 20;

        for (int i = 1; i < 6; i++) {
            System.out.println("El alumno "+ numAlum + " comienza pregunta "+ i);

        }

    }

}
