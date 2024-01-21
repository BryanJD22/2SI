import java.util.ArrayList;

public class Mi2Hilo extends Thread implements Runnable {
    private String letra;
    private ArrayList<Mi2Hilo> hermanos;

    private Mi2Hilo sucesor;
    Mi2Hilo(String letra){
        this.letra = letra;

    }

    public ArrayList<Mi2Hilo> getHermanos() {
        return hermanos;
    }

    public void setHermanos(ArrayList<Mi2Hilo> hermanos) {
        this.hermanos = hermanos;
    }

    @Override
    public synchronized void run() {
        /*for (int i = 0; i < 10; i++) {
            System.out.println("Hola Mundo, soy el hilo " + letra);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hola soy el hilo" + letra + " y me acaban de despertar");
            }
        }*/

        //Discrimar el número de hilo que soy y ponerme a dormir sino soy el primero
        //El primero pone hola mundo y avisa al segundo y termina
        //El segundo despertará pondrá su hola mundo y depierta al tercero
        //y asi sucesivamente

        switch (letra){
            case "A":
                sucesor=hermanos.get(1);
                break;
            case "B":
                sucesor=hermanos.get(2);

                break;
            case "C":
                sucesor=hermanos.get(0);

                break;
        }


        for (int i = 0 ; i<10; i++){
            if (letra.equals("A") && i==0){
                System.out.println("Hola, soy el hilo A");
                hermanos.get(1).interrupt();
                continue;//para que en la ultima iteración salga
            }
            try {
                wait(100);
            }catch (InterruptedException ex){
                System.out.println("Hola, soy el hilo " + letra);
                sucesor.interrupt();

            }
        }




    }
}
