import java.util.ArrayList;

public class Cancion {

    private String titulo;

    private ArrayList<String> letra;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getLetra() {
        return letra;
    }

    public void setLetra(ArrayList<String> letra) {
        this.letra = letra;
    }

    public Cancion(String titulo, ArrayList<String> letra) {
        this.titulo = titulo;
        this.letra = letra;
    }
}
