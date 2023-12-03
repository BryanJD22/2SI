public class Mi2Hilo implements Runnable{
    private String letra;

    public Mi2Hilo(String letra) {
        this.letra = letra;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (letra=="a"){
                System.out.println("Hola soy el Hilo "+ letra +"; Hola Mundo!!!");

            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    System.out.println("Hola soy el Hilo "+ letra+" y me acaban de despertar");

                }

            }



        }
    }
}
