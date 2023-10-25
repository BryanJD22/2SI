public class Mi1erHilo extends Thread{
    private int numHilo;
    Mi1erHilo(int numHilo){
        this.numHilo = numHilo;
    }
    public void run(){
        System.out.println("Hola mundo!!! Soy el hilo" + this.numHilo);

    }
}
