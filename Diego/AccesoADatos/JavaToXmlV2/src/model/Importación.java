package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Importación {
    public static void XMLtoDB(String nombre_tabla, String archivoXML) throws Exception {
        String url = "jdbc:mysql://localhost:3306/juguetes";
        String username = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(archivoXML));

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName(nombre_tabla);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                // Realizar inserción en la base de datos según la tabla
                if (nombre_tabla.equals("articulos")) {
                    int id_articulo = Integer.parseInt(element.getElementsByTagName("id_articulo").item(0).getTextContent());
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = element.getElementsByTagName("descripcion").item(0).getTextContent();
                    int stock = Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent());
                    double precio_unitario = Double.parseDouble(element.getElementsByTagName("precio_unitario").item(0).getTextContent());

                    // Realizar la inserción en la base de datos
                    String sql = "INSERT INTO articulos (id_articulo, nombre, descripcion, stock, precio_unitario) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, id_articulo);
                        preparedStatement.setString(2, nombre);
                        preparedStatement.setString(3, descripcion);
                        preparedStatement.setInt(4, stock);
                        preparedStatement.setDouble(5, precio_unitario);
                        preparedStatement.executeUpdate();
                    }
                } else if (nombre_tabla.equals("empresas")) {
                    int id_empresa = Integer.parseInt(element.getElementsByTagName("id_empresa").item(0).getTextContent());
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String CIF = element.getElementsByTagName("CIF").item(0).getTextContent();
                    String CP = element.getElementsByTagName("CP").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                    String nombre_contacto_empresa = element.getElementsByTagName("nombre_contacto_empresa").item(0).getTextContent();

                    // Realizar la inserción en la base de datos
                    String sql = "INSERT INTO empresa (id_empresa, nombre, CIF, CP, telefono, nombre_contacto_empresa) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, id_empresa);
                        preparedStatement.setString(2, nombre);
                        preparedStatement.setString(3, CIF);
                        preparedStatement.setString(4, CP);
                        preparedStatement.setString(5, telefono);
                        preparedStatement.setString(6, nombre_contacto_empresa);
                        preparedStatement.executeUpdate();
                    }

                } else if (nombre_tabla.equals("usuarios")) {
                    int id_usuario = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String DNI = element.getElementsByTagName("DNI").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                    String correo = element.getElementsByTagName("correo").item(0).getTextContent();
                    String direccion = element.getElementsByTagName("direccion").item(0).getTextContent();

                    // Realizar la inserción en la base de datos
                    String sql = "INSERT INTO usuarios (id, nombre, DNI, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, id_usuario);
                        preparedStatement.setString(2, nombre);
                        preparedStatement.setString(3, DNI);
                        preparedStatement.setString(4, telefono);
                        preparedStatement.setString(5, correo);
                        preparedStatement.setString(6, direccion);
                        preparedStatement.executeUpdate();
                    }
                } else if (nombre_tabla.equals("particulares")) {
                    int id_particular = Integer.parseInt(element.getElementsByTagName("id_particular").item(0).getTextContent());
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String direccion = element.getElementsByTagName("direccion").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();

                    // Realizar la inserción en la base de datos
                    String sql = "INSERT INTO particulares (id_particular, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, id_particular);
                        preparedStatement.setString(2, nombre);
                        preparedStatement.setString(3, direccion);
                        preparedStatement.setString(4, telefono);
                        preparedStatement.executeUpdate();
                    }
                }
            }
        }

        // Cerrar la conexión a la base de datos
        conn.close();

        System.out.println("Importación exitosa desde " + archivoXML + " a " + nombre_tabla);
    }
}