import java.util.ArrayList;

public class Main {
    //public static int contador = 0;
    public static Contador contadorObjeto = new Contador();
    public static void main(String[] args) {
        ArrayList<Hilo> hilos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Hilo hilo = new Hilo(i);
            hilos.add(hilo);
            //hilo.run();
        }
        for (Hilo hilo: hilos) {
            hilo.run();
        }
    }
}