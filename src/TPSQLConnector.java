import java.sql.*;

public class TPSQLConnector {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp1-java", "root", "rootpassword");
            TransportFactory factory = new TransportFactory();
            Transport transport = factory.creerTransport(
                    "voiture",
                    con,
                    "Pagani",
                    "Huayra",
                    250,
                    380,
                    "HD-069-PH",
                    12.0,
                    null,
                    null,
                    null,
                    null,
                    null);
            if(transport instanceof Voiture) {
                Voiture voiture = (Voiture) transport;
                voiture.selectAllVoitures();
            }
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}