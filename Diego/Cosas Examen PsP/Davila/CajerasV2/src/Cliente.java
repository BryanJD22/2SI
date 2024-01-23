import java.util.Arrays;

public class Cliente {

    int id_cliente;
    private int[] carroCompra;

    public Cliente(int id_cliente, int[] carroCompra) {
        this.id_cliente = id_cliente;
        this.carroCompra = carroCompra;
    }

    public Cliente(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

    public int[] getcarroCompra() {
        return carroCompra;
    }


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
