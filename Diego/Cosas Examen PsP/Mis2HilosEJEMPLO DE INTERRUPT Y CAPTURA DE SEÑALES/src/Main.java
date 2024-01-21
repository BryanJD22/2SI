public class Main {
    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Mi2Hilo("A"));
        Thread hilo2 = new Thread(new Mi2Hilo("B"));
        Thread hilo3 = new Thread(new Mi2Hilo("C"));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.interrupt();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.interrupt();

        System.out.println("Bye world!");
    }
}