// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Mi2Hilo hilo2 = new Mi2Hilo();

        Thread hilo2 = new Thread(new Mi2Hilo("a"));
        Thread hilo3 = new Thread(new Mi2Hilo("b"));
        Thread hilo4 = new Thread(new Mi2Hilo("c"));

        hilo2.start();
        hilo3.start();
        hilo4.start();


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        hilo2.interrupt();


        System.out.println("Soy el Main, adios Mundo!!!");


    }
}