import java.sql.*;

public class Avion implements Transport {
    private String marqueAvion;
    private String modeleAvion;
    private int vitesseAvion;
    private int vitesseMaxAvion;
    private double altitudeAvion;
    private double altitudeMaxAvion;
    private double porteeAvion;
    private Connection con;

    public Avion(String marque, String modele, int vit, int maxvit, double alt, double altMax, double portee, Connection c) {
        this.marqueAvion = marque;
        this.modeleAvion = modele;
        this.vitesseAvion = vit;
        this.vitesseMaxAvion = maxvit;
        this.altitudeAvion = alt;
        this.altitudeMaxAvion = altMax;
        this.porteeAvion = portee;
        this.con = c;
    }

    // Getters & Setters

    @Override
    public String getMarque() {
        return this.marqueAvion;
    }

    @Override
    public String getModele() {
        return this.modeleAvion;
    }

    @Override
    public int getVitesse() {
        return this.vitesseAvion;
    }

    @Override
    public int getVitesseMax() {
        return this.vitesseMaxAvion;
    }

    @Override
    public void setMarque(String marque) {
        this.marqueAvion = marque;
    }

    @Override
    public void setModele(String modele) {
        this.modeleAvion = modele;
    }

    @Override
    public void setVitesse(int vitesse) {
        this.vitesseAvion = vitesse;
    }

    @Override
    public void setVitesseMax(int maxvit) {
        this.vitesseMaxAvion = maxvit;
    }

    public double getAltitudeAvion() {
        return this.altitudeAvion;
    }

    public double getAltitudeMaxAvion() {
        return this.altitudeMaxAvion;
    }

    public double getPorteeAvion() {
        return this.porteeAvion;
    }

    public void setAltitudeAvion(double altitude) {
        this.altitudeAvion = altitude;
    }

    public void setAltitudeMaxAvion(double altitudeMax) {
        this.altitudeMaxAvion = altitudeMax;
    }

    public void setPorteeAvion(double portee) {
        this.porteeAvion = portee;
    }

    // Fonctions & Procédures autres

    public void selectAvion(int id) {
        try {
            String query = "SELECT * FROM avion WHERE id_avion = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String marque = rs.getString("marque_avion");
                String modele = rs.getString("modele_avion");
                int vitesse = rs.getInt("vitesse_avion");
                int vitesseMax = rs.getInt("vitesse_max_avion");
                double altitude = rs.getDouble("altitude_avion");
                double altitudeMax = rs.getDouble("altitude_max_avion");
                double portee = rs.getDouble("portee_avion");

                System.out.println("Marque: " + marque + ", Modèle: " + modele + ", Vitesse: " + vitesse + ", Vitesse max: " + vitesseMax + ", Altitude: " + altitude + ", Altitude max: " + altitudeMax + ", Portée: " + portee);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void selectAllAvions() {
        try {
            String query = "SELECT * FROM avion";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID: - Marque: - Modèle: - Vitesse: - Vitesse max: - Altitude: - Altitude max: - Portée:");
            while (rs.next()) {
                int id = rs.getInt("id_avion");
                String marque = rs.getString("marque_avion");
                String modele = rs.getString("modele_avion");
                int vitesse = rs.getInt("vitesse_avion");
                int vitesseMax = rs.getInt("vitesse_max_avion");
                double altitude = rs.getDouble("altitude_avion");
                double altitudeMax = rs.getDouble("altitude_max_avion");
                double portee = rs.getDouble("portee_avion");

                System.out.println(id + ", " + marque + ", " + modele + ", " + vitesse + ", " + vitesseMax + ", " + altitude + ", " + altitudeMax + ", " + portee);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteAvion(int id) {
        try {
            String query = "DELETE FROM avion WHERE id_avion = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la suppression des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertAvion() {
        try {
            String query = "INSERT INTO avion (marque_avion, modele_avion, vitesse_avion, vitesse_max_avion, altitude_avion, altitude_max_avion, portee_avion) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.marqueAvion);
            pstmt.setString(2, this.modeleAvion);
            pstmt.setInt(3, this.vitesseAvion);
            pstmt.setInt(4, this.vitesseMaxAvion);
            pstmt.setDouble(5, this.altitudeAvion);
            pstmt.setDouble(6, this.altitudeMaxAvion);
            pstmt.setDouble(7, this.porteeAvion);
            pstmt.executeUpdate();
            System.out.print("Insertion en base.");
        } catch (SQLException e) {
            System.out.println("Erreur quant à l'insertion des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateAvion(int id, String marque, String modele, Integer vitesse, Integer vmax, Double altitude, Double altitudeMax, Double portee) {
        try {
            String query = "UPDATE avion SET marque_avion = ?," +
                    "modele_avion = ?," +
                    "vitesse_avion = ?," +
                    "vitesse_max_avion = ?," +
                    "altitude_avion = ?," +
                    "altitude_max_avion = ?," +
                    "portee_avion = ? " +
                    "WHERE id_avion = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, marque);
            pstmt.setString(2, modele);
            pstmt.setInt(3, vitesse);
            pstmt.setInt(4, vmax);
            pstmt.setDouble(5, altitude);
            pstmt.setDouble(6, altitudeMax);
            pstmt.setDouble(7, portee);
            pstmt.setInt(8, id);
            pstmt.executeUpdate();
            System.out.print("Mise à jour.");
        } catch (SQLException e) {
            System.out.println("Erreur quant à la mise à jour des données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
