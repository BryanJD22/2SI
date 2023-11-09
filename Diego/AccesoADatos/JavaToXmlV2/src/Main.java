import model.Exportación;
import model.Importación;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        Exportación.DBtoXML("particulares");

        Importación.XMLtoDB("articulos","articulos.xml");

    }

}