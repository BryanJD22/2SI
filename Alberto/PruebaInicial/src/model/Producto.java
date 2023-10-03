package model;

public class Producto {

    //    ProductoID INTEGER PRIMARY KEY,
    //    Codigo VARCHAR(5),
    //    Nombre VARCHAR(100),
    //    PrecioUnitario DECIMAL(10, 2),
    //    ProveedorID INTEGER REFERENCES Proveedor(ProveedorID)

    private int ProductoID;
    private String Codigo;
    private String Nombre;
    private float PrecioUnitario;
    private int ProveedorID;


    public Producto() {

    }

    public Producto(int productoID, String codigo, String nombre, float precioUnitario, int proveedorID) {
        ProductoID = productoID;
        Codigo = codigo;
        Nombre = nombre;
        PrecioUnitario = precioUnitario;
        ProveedorID = proveedorID;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int productoID) {
        ProductoID = productoID;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        PrecioUnitario = precioUnitario;
    }

    public int getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(int proveedorID) {
        ProveedorID = proveedorID;
    }
}
