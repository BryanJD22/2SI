import java.sql.*;


public class Main {

    public static void main(String[] args) {
        String RDS_INSTANCE_HOSTNAME = "orcl.cw3oempcra8i.us-east-1.rds.amazonaws.com";
        String RDS_INSTANCE_PORT = "1521";
        String JDBC_URL = "jdbc:oracle:thin:@" + RDS_INSTANCE_HOSTNAME + ":" + RDS_INSTANCE_PORT + ":orcl";

        try {
            Connection connection= DriverManager.getConnection(JDBC_URL,"admin","12341234");
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM DUAL");
            while (rs.next()) {
                String id = rs.getString(1);
                System.out.println(id); //Should print "X"
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
        // TODO Auto-generated catch block e.printStackTrace();
        }


    }
}