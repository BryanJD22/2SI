import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Mi2Hilo> hermanos = new ArrayList<>();

        Mi2Hilo hilo1 = new Mi2Hilo("A");
        Mi2Hilo hilo2 = new Mi2Hilo("B");
        Mi2Hilo hilo3 = new Mi2Hilo("C");





        hermanos.add(hilo1);
        hermanos.add(hilo2);
        hermanos.add(hilo3);

        hilo1.setHermanos(hermanos);
        hilo2.setHermanos(hermanos);
        hilo3.setHermanos(hermanos);

        hilo1.start();
        hilo2.start();
        hilo3.start();


        System.out.println("Hola class!");


    /*    try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

*/
    }
}