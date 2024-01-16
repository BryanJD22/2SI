import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> letra1 = new ArrayList<>();
        letra1.add("Verso 1");
        letra1.add("Verso 2");
        letra1.add("Verso 3");


        Cancion cancion1 = new Cancion("Cancion1", letra1);

        Hilo hilo1 = new Hilo();
        hilo1.setId(1);
        hilo1.setCancion(cancion1);

        Hilo hilo2 = new Hilo();
        hilo2.setId(2);
        hilo2.setCancion(cancion1);


        Hilo hilo3 = new Hilo();
        hilo3.setId(3);
        hilo3.setCancion(cancion1);

        // Start the threads
        hilo1.start();
        hilo2.start();
        hilo3.start();


    }


}