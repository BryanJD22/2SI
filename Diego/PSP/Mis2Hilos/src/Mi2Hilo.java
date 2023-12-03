public class Mi2Hilo implements Runnable{
    private String letra;
    Mi2Hilo(String letra){
        this.letra = letra;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola Mundo, soy el hilo " + letra);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hola soy el hilo" + letra + " y me acaban de despertar");
            }
        }


    }
}
