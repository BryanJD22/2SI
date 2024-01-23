public class Cajera extends Thread {
    private Cliente cliente;
    private int cajeraId;

    public Cajera(int cajeraId, Cliente cliente) {
        this.cajeraId = cajeraId;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("La cajera Cajera " + cajeraId + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE Cliente " +
                cliente.getId_cliente() + " EN EL TIEMPO: 0seg");

        int tiempoTotal = 0;

        for (int i = 0; i < cliente.getcarroCompra().length; i++) {
            int tiempoProducto = cliente.getcarroCompra()[i];
            tiempoTotal += tiempoProducto;

            System.out.println("Procesado el producto " + (i + 1) + " del cliente Cliente " +
                    cliente.getId_cliente() + "->Tiempo: " + tiempoTotal + "seg");

            try {
                Thread.sleep(tiempoProducto * 1000); // Simulando el tiempo de escaneo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La cajera Cajera " + cajeraId + " HA TERMINADO DE PROCESAR Cliente " +
                cliente.getId_cliente() + " EN EL TIEMPO: " + tiempoTotal + "seg");

    }

}
