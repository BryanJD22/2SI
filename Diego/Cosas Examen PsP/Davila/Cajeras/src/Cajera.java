public class Cajera {
    int id_cajera;

    long initialTime;

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public Cajera(int id_cajera) {
        this.id_cajera = id_cajera;
    }

    public long procesarCompra(Cliente cliente, long initialTime) {

        System.out.println("La cajera " + getId_cajera() + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +
                cliente.getId_cliente() + " EN EL TIEMPO: " + (System.currentTimeMillis() - initialTime) / 1000 + "seg");

        int[] productos = cliente.getcarroCompra();
        long tiempo = 0;

        for (int i = 0; i < productos.length; i++) {

            tiempo += productos[i];

            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + cliente.getId_cliente() +

                    "->Tiempo: " + tiempo + "seg");

            try {

                Thread.sleep(productos[i] * 1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println("La cajera " + getId_cajera() + " HA TERMINADO DE PROCESAR " + cliente.getId_cliente() +

                " EN EL TIEMPO: " + (System.currentTimeMillis() - initialTime) / 1000 + "seg");

        return tiempo;

    }




    public int getId_cajera() {
        return id_cajera;
    }

    public void setId_cajera(int id_cajera) {
        this.id_cajera = id_cajera;
    }
}
