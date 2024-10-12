import java.sql.*;

public class TPSQLConnector {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp1-java", "root", "");
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
            Transport transport2 = factory.creerTransport(
                    "avion",
                    con,
                    "Boeing",
                    "737",
                    840,
                    945,
                    null,
                    null,
                    null,
                    null,
                    10000.00,
                    12500.00,
                    6570.00

            );
            Transport transport3 = factory.creerTransport(
                    "bateau",
                    con,
                    null,
                    "Belem",
                    20,
                    28,
                    null,
                    null,
                    4.90,
                    20,
                    null,
                    null,
                    null
            );
            if(transport instanceof Voiture) {
                Voiture voiture = (Voiture) transport;
                voiture.selectAllVoitures();
            }
            if (transport2 instanceof Avion) {
                Avion avion = (Avion) transport2;
                avion.selectAllAvions();
            }
            if (transport3 instanceof Bateau) {
                Bateau bateau = (Bateau) transport3;
                bateau.selectAllBateaux();
            }
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}