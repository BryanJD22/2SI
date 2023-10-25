
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mi1erHilo hilo1 = new Mi1erHilo(1);
        Mi1erHilo hilo2 = new Mi1erHilo(2);
        Mi1erHilo hilo3 = new Mi1erHilo(3);
        Mi1erHilo hilo4 = new Mi1erHilo(4);
        Mi1erHilo hilo5 = new Mi1erHilo(5);

        hilo1.start();
        hilo1.sleep(100);
        hilo2.start();
        hilo2.sleep(80);
        hilo3.start();
        hilo3.sleep(60);
        hilo4.start();
        hilo4.sleep(40);
        hilo5.start();
        hilo5.sleep(20);


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Adios mundo!!! Soy el Main");
    }
}