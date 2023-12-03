public class Hilo extends Thread{

    private int num;

    public Hilo(int num){
        this.num = num;

    }

    @Override
    public void run() {
        Main.contadorObjeto.contador++;
        System.out.println("Soy el hilo: " + num + " y el contador es: " + Main.contadorObjeto.getContador());
    }
}
