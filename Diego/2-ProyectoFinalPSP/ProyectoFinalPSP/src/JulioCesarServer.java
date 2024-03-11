import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class JulioCesarServer {
    static final int puerto = 5000;
    private Random random = new Random();

    public JulioCesarServer() {
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Escuchando en el puerto " + puerto);

            while (true) {
                // Aceptar la conexión del cliente
                Socket skCliente = serverSocket.accept();

                // Crear un nuevo hilo para atender al cliente y pasar el socket al constructor
                Thread clienteThread = new Thread(new CenturionHandler(skCliente, 1));
                clienteThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace(); // o usa algún mecanismo de registro adecuado
        }

    }



}
