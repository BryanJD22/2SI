import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bj";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            /*EXPORTACIÓNNNNNN*/

            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            File file = new File("usuarios.xml"); // Nombre del archivo XML de salida
            FileWriter writer = new FileWriter(file);
            PrintWriter pw = new PrintWriter(writer);

            // Escribir la cabecera del archivo XML
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<usuarios>");

            while (rs.next()) {
                // Escribir cada fila como un elemento de usuario
                pw.println("    <usuario>");
                pw.println("        <id>" + rs.getInt(1) + "</id>");
                pw.println("        <nombre>" + rs.getString(2) + "</nombre>");
                pw.println("        <DNI>" + rs.getString(3) + "</DNI>");
                pw.println("        <telefono>" + rs.getString(4) + "</telefono>");
                pw.println("        <correo>" + rs.getString(5) + "</correo>");
                pw.println("        <direccion>" + rs.getString(6) + "</direccion>");
                pw.println("    </usuario>");
            }

            // Cerrar la etiqueta de cierre del elemento principal
            pw.println("</usuarios>");

            // Cerrar el archivo
            pw.close();

            System.out.println("Exportación exitosa a usuarios.xml");

            /*FINNNN EXPORTACIÓNNNNNN*/

            /*LEERRRR ARCHICOS XML*/
            try {
                File archivo = new File("usuarios.xml");
                FileReader reader = new FileReader(archivo);
                BufferedReader buffer = new BufferedReader(reader);
                String linea;
                while ((linea = buffer.readLine()) != null) {
                    System.out.println(linea);
                }
                buffer.close();
                System.out.println("Lectura hecho de lokosss");
            } catch (Exception e) {
                e.printStackTrace();
            }

            /*FINNNN  LEERRRR ARCHICOS XML*/


            /*IMPORTACIÓNNNNNNN*/
            /*
            try {

                // Ruta al archivo XML que deseas importar
                String xmlFilePath = "usuarios.xml";

                File xmlFile = new File(xmlFilePath);

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(xmlFile);

                NodeList nodeList = document.getElementsByTagName("usuario");

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String dni = element.getElementsByTagName("DNI").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                    String correo = element.getElementsByTagName("correo").item(0).getTextContent();
                    String direccion = element.getElementsByTagName("direccion").item(0).getTextContent();

                    // Insertar los datos en la base de datos
                    String insertQuery = "INSERT INTO usuarios (id, nombre, DNI, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, dni);
                    preparedStatement.setString(4, telefono);
                    preparedStatement.setString(5, correo);
                    preparedStatement.setString(6, direccion);
                    preparedStatement.executeUpdate();
                }

                conn.close();

                System.out.println("Importación hecha de lokossss");

            } catch (Exception e) {
                e.printStackTrace();
            }*/
            /*FIN DE IMPORTACIÓNNNNN*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


  /*    esto escribe bien la base de datos
        try {
                    BufferedReader br = new BufferedReader(new FileReader("usuarios.xml"));
                    String line;
                    while ((line = br.readLine()) != null) {
                    if (line.contains("<id>")) {
                    System.out.print("id:" + line.replaceAll("<[^>]*>", "") + " ");
                    } else if (line.contains("<nombre>")) {
                    System.out.print("nombre:" + line.replaceAll("<[^>]*>", " ") + " ");
                    } else if (line.contains("<DNI>")) {
                    System.out.print("DNI:" + line.replaceAll("<[^>]*>", " ") + " ");
                    } else if (line.contains("<telefono>")) {
                    System.out.print("telefono:" + line.replaceAll("<[^>]*>", " ") + " ");
                    } else if (line.contains("<correo>")) {
                    System.out.print("correo:" + line.replaceAll("<[^>]*>", " ") + " ");
                    } else if (line.contains("<direccion>")) {
                    System.out.println("direccion:" + line.replaceAll("<[^>]*>", " "));
                    }
                    }
                    br.close();
                    } catch (IOException e) {
                    e.printStackTrace();
                    }*/

/*public class EscribirFichero
{
    public static void main(String[] args)
    {
        File fichero = null;
        FileWriter writer = null;
        PrintWriter pw = null;
        try
        {
            fichero = new File("C:\\directorioArchivo\\archivo.txt");
            writer = new FileWriter(fichero);
            pw = new PrintWriter(writer);
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}*/