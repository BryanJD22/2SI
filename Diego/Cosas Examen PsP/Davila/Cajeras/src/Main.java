// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente(2, new int[]{1, 3, 5, 1, 1});

        Cajera cajera1 = new Cajera(1);

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        long tiempo = cajera1.procesarCompra(cliente1, initialTime);
        tiempo = cajera1.procesarCompra(cliente2, initialTime + tiempo);

    }
}





























/*import java.util.Arrays;

class Cajera {
    public void cobrar(Cliente cliente) {
        System.out.println("Procesando la compra del cliente...");
        for (int i = 0; i < cliente.getProductos().length; i++) {
            System.out.println("Escaneando producto " + (i + 1) + " durante " + cliente.getProductos()[i] + " segundos");
            try {
                Thread.sleep(cliente.getProductos()[i] * 1000); // Simulando el tiempo de escaneo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cobro completado en " + cliente.calcularTiempoTotal() + " segundos");
    }
}

class Cliente {
    private int[] productos;

    public Cliente(int[] productos) {
        this.productos = productos;
    }

    public int[] getProductos() {
        return productos;
    }

    public int calcularTiempoTotal() {
        return Arrays.stream(productos).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] productosCliente1 = {1, 3, 5};
        int[] productosCliente2 = {2, 4, 6};

        Cliente cliente1 = new Cliente(productosCliente1);
        Cliente cliente2 = new Cliente(productosCliente2);

        Cajera cajera = new Cajera();

        // Procesar la compra del cliente 1
        cajera.cobrar(cliente1);

        // Procesar la compra del cliente 2
        cajera.cobrar(cliente2);
    }
}
///////////////////////////////////////
import java.util.Arrays;

class Cajera extends Thread {
    private Cliente cliente;

    public Cajera(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("Procesando la compra del cliente...");
        for (int i = 0; i < cliente.getProductos().length; i++) {
            System.out.println("Cajera " + this.getId() + " escaneando producto " + (i + 1) +
                    " durante " + cliente.getProductos()[i] + " segundos");
            try {
                Thread.sleep(cliente.getProductos()[i] * 1000); // Simulando el tiempo de escaneo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cajera " + this.getId() + " cobro completado en " +
                cliente.calcularTiempoTotal() + " segundos");
    }
}

public class Main {
    public static void main(String[] args) {
        int[] productosCliente1 = {1, 3, 5};
        int[] productosCliente2 = {2, 4, 6};

        Cliente cliente1 = new Cliente(productosCliente1);
        Cliente cliente2 = new Cliente(productosCliente2);

        // Crear dos cajeras y asignarles los clientes
        Cajera cajera1 = new Cajera(cliente1);
        Cajera cajera2 = new Cajera(cliente2);

        // Iniciar los hilos de las cajeras para procesar los clientes simultáneamente
        cajera1.start();
        cajera2.start();

        try {
            // Esperar a que ambos hilos terminen antes de continuar
            cajera1.join();
            cajera2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Proceso de cobro de clientes completado");
    }
}*/
