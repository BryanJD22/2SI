import java.util.ArrayList;

public class Hilo extends Thread{

    private int id;

    private Cancion cancion;


    @Override
    public void run() {
        String verso = cancion.getLetra().get(id - 1);
        System.out.println("Hilo " + id + ": " + verso);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }


}
