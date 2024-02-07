import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente {
    static final String HOST = "localhost";
    static final int puerto = 5000;

    public Cliente(){
        try {
            Socket skCliente = new Socket(HOST,puerto);
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            System.out.println(flujo.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
