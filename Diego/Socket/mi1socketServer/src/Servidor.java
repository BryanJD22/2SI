import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int puerto = 5000;
    public Servidor() {
        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Escucho el puerto "+ puerto);
            for (int numcli = 0; numcli<3; numcli++){
                Socket skcliente = serverSocket.accept();
                System.out.println("Sirvo al cliente "+ numcli);
                OutputStream aux = skcliente.getOutputStream();
                DataOutput flujo = new DataOutputStream(aux);
                flujo.writeUTF("Hola cliente " + numcli);
                skcliente.close();

            }
            System.out.println("Demasiados cliente por hoy");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
