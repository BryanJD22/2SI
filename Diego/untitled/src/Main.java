
public class Main {
    public static void main(String[] args) {
        Mi1erHilo hilo = new Mi1erHilo();
        hilo.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Adios mundo!!! Soy el Main");
    }
}