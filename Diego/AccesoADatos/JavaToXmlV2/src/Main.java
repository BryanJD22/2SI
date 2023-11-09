import model.Exportación;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Hello world!");

        Exportación.DBtoXML("particulares");

    }

}