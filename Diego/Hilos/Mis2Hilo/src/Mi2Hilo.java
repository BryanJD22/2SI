public class Mi2Hilo implements Runnable{
    private String letra;

    public Mi2Hilo(String letra) {
        this.letra = letra;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola soy el Hilo "+ letra +"; Hola Mundo!!!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
