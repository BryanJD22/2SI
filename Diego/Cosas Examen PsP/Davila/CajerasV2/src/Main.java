// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int[] productosCliente1 = {2, 2, 1, 5, 2, 3};
        int[] productosCliente2 = {3, 1, 3, 1, 2, 1};
        //Creamos los clientes, le asiganmos la id y 1 array de productos
        Cliente cliente1 = new Cliente(1, productosCliente1);
        Cliente cliente2 = new Cliente(2, productosCliente2);

        //asignamos la id y 1 cliente por cajera
        Cajera cajera1 = new Cajera(1, cliente1);
        Cajera cajera2 = new Cajera(2, cliente2);

        // Iniciamos los hilos de las cajeras para cobrar los clientes a la vez
        cajera1.start();
        cajera2.start();

        try {
            // El join se utiliza para esperar a que los 2 hilos terminen y el main espera a que los clientes
            cajera1.join();
            cajera2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Proceso de cobro de clientes completado");
    }
}