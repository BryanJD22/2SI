package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Exportación {


    public static void DBtoXML(String nombre_tabla) throws IOException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/juguetes";
        String username = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement st = conn.createStatement();

        /*EXPORTACIÓNNNNNN*/

        ResultSet rs = st.executeQuery("SELECT * FROM "+nombre_tabla);

        File file = new File(nombre_tabla+".xml");
        FileWriter writer = new FileWriter(file);
        PrintWriter pw = new PrintWriter(writer);
        // Escribir la cabecera del archivo XML
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<"+nombre_tabla+">");

        while (rs.next()) {
            // Escribir cada fila según el nombre de la tabla
            if (nombre_tabla.equals("articulos")) {
                pw.println("    <articulo PK=id_articulo>");
                pw.println("        <id_articulo>" + rs.getInt(1) + "</id_articulo>");
                pw.println("        <nombre>" + rs.getString(2) + "</nombre>");
                pw.println("        <descripcion>" + rs.getString(3) + "</descripcion>");
                pw.println("        <stock>" + rs.getInt(4) + "</stock>");
                pw.println("        <precio_unitario>" + rs.getDouble(5) + "</precio_unitario>");
                pw.println("    </articulo>");
            } else if (nombre_tabla.equals("empresas")) {
                pw.println("    <empresa PK=id_empresa>");
                pw.println("        <id_empresa>" + rs.getInt(1) + "</id_empresa>");
                pw.println("        <nombre>" + rs.getString(2) + "</nombre>");
                pw.println("        <CIF>" + rs.getString(3) + "</CIF>");
                pw.println("        <CP>" + rs.getString(4) + "</CP>");
                pw.println("        <telefono>" + rs.getString(5) + "</telefono>");
                pw.println("        <nombre_contacto_empresa>" + rs.getString(6) + "</nombre_contacto_empresa>");
                pw.println("    </empresa>");
            } else if (nombre_tabla.equals("usuarios")) {
                pw.println("    <usuario PK=id>");
                pw.println("        <id>" + rs.getInt(1) + "</id>");
                pw.println("        <nombre>" + rs.getString(2) + "</nombre>");
                pw.println("        <DNI>" + rs.getString(3) + "</DNI>");
                pw.println("        <telefono>" + rs.getString(4) + "</telefono>");
                pw.println("        <correo>" + rs.getString(5) + "</correo>");
                pw.println("        <direccion>" + rs.getString(6) + "</direccion>");
                pw.println("    </usuario>");
            } else if (nombre_tabla.equals("particulares")) {
                pw.println("    <particular PK=id_particular>");
                pw.println("        <id_particular>" + rs.getInt(1) + "</id_particular>");
                pw.println("        <nombre>" + rs.getString(2) + "</nombre>");
                pw.println("        <direccion>" + rs.getString(3) + "</direccion>");
                pw.println("        <telefono>" + rs.getString(4) + "</telefono>");
                pw.println("    </particular>");
            }
        }


        // Cerrar la etiqueta de cierre del elemento principal
        pw.println("</"+nombre_tabla+">");

        // Cerrar el archivo
        pw.close();

        System.out.println("Exportación exitosa a "+nombre_tabla+".xml");


    }

}
