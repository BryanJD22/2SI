import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public Servidor(int puerto) {
        try (ServerSocket server = new ServerSocket(puerto)) {
            System.out.println("Escuchando en el puerto " + puerto);

            // Aceptar la conexión del cliente
            Socket client = server.accept();
            System.out.println("[" + server.getLocalSocketAddress() + "] Cliente aceptado.");

            OutputStream outputStream = client.getOutputStream();
            InputStream inputStream = client.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            dataOutputStream.writeUTF("\"[" + server.getInetAddress() + "] Conexión establecida exitosamente.");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





