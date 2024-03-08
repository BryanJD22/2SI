import java.net.Socket;

public class CenturionHandler implements Runnable{
    private final Socket skCenturion;
    private final int centurionId;

    public CenturionHandler(Socket skCliente, int centurionId) {
        this.skCenturion = skCliente;
        this.centurionId = centurionId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Atendiendo al Centurion " + centurionId + " desde " + skCenturion.getInetAddress());




        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}