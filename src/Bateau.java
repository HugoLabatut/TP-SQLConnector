import java.sql.*;

public class Bateau implements Transport {
    private String marqueBateau;
    private String modeleBateau;
    private int vitesseBateau;
    private int vitesseMaxBateau;
    private double tirantDeauBateau;
    private int nbreVoilesBateau;
    private Connection con;

    public Bateau(String marque, String modele, int vit, int maxvit, double tirantDeau, int nbreVoiles, Connection c) {
        this.marqueBateau = marque;
        this.modeleBateau = modele;
        this.vitesseBateau = vit;
        this.vitesseMaxBateau = maxvit;
        this.tirantDeauBateau = tirantDeau;
        this.nbreVoilesBateau = nbreVoiles;
        this.con = c;
    }

    // Getters & Setters

    @Override
    public String getMarque() {
        return this.marqueBateau;
    }

    @Override
    public String getModele() {
        return this.modeleBateau;
    }

    @Override
    public int getVitesse() {
        return this.vitesseBateau;
    }

    @Override
    public int getVitesseMax() {
        return this.vitesseMaxBateau;
    }

    @Override
    public void setMarque(String marque) {
        this.marqueBateau = marque;
    }

    @Override
    public void setModele(String modele) {
        this.modeleBateau = modele;
    }

    @Override
    public void setVitesse(int vitesse) {
        this.vitesseBateau = vitesse;
    }

    @Override
    public void setVitesseMax(int maxvit) {
        this.vitesseMaxBateau = maxvit;
    }

    public double getTirantDeauBateau() {
        return this.tirantDeauBateau;
    }

    public int getNbreVoilesBateau() {
        return this.nbreVoilesBateau;
    }

    public void setTirantDeauBateau(double tirantDeau) {
        this.tirantDeauBateau = tirantDeau;
    }

    public void setNbreVoilesBateau(int nbreVoiles) {
        this.nbreVoilesBateau = nbreVoiles;
    }

    // Fonctions & Procédures autres

    public void selectBateau(int id) {
        try {
            String query = "SELECT * FROM bateau WHERE id_bateau = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String marque = rs.getString("marque_bateau");
                String modele = rs.getString("modele_bateau");
                int vitesse = rs.getInt("vitesse_bateau");
                int vitesseMax = rs.getInt("vitesse_max_bateau");
                double tirantDeau = rs.getDouble("tirant_deau_bateau");
                int nbreVoiles = rs.getInt("nbre_voiles_bateau");

                System.out.println("Marque: " + marque + ", Modèle: " + modele + ", Vitesse: " + vitesse + ", Vitesse max: " + vitesseMax + ", Tirant d'eau: " + tirantDeau + ", Nombre de voiles: " + nbreVoiles);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void selectAllBateaux() {
        try {
            String query = "SELECT * FROM bateau";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID: - Marque: - Modèle: - Vitesse: - Vitesse max: - Tirant d'eau: - Nombre de voiles:");
            while (rs.next()) {
                int id = rs.getInt("id_bateau");
                String marque = rs.getString("marque_bateau");
                String modele = rs.getString("modele_bateau");
                int vitesse = rs.getInt("vitesse_bateau");
                int vitesseMax = rs.getInt("vitesse_max_bateau");
                double tirantDeau = rs.getDouble("tirant_deau_bateau");
                int nbreVoiles = rs.getInt("nbre_voiles_bateau");

                System.out.println(id + ", " + marque + ", " + modele + ", " + vitesse + ", " + vitesseMax + ", " + tirantDeau + ", " + nbreVoiles);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteBateau(int id) {
        try {
            String query = "DELETE FROM bateau WHERE id_bateau = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la suppression des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertBateau() {
        try {
            String query = "INSERT INTO bateau (marque_bateau, modele_bateau, vitesse_bateau, vitesse_max_bateau, tirant_deau_bateau, nbre_voiles_bateau) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.marqueBateau);
            pstmt.setString(2, this.modeleBateau);
            pstmt.setInt(3, this.vitesseBateau);
            pstmt.setInt(4, this.vitesseMaxBateau);
            pstmt.setDouble(5, this.tirantDeauBateau);
            pstmt.setInt(6, this.nbreVoilesBateau);
            pstmt.executeUpdate();
            System.out.print("Insertion en base.");
        } catch (SQLException e) {
            System.out.println("Erreur quant à l'insertion des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateBateau(int id, String marque, String modele, Integer vitesse, Integer vmax, Double tirantDeau, Integer nbreVoiles) {
        try {
            String query = "UPDATE bateau SET marque_bateau = ?," +
                    "modele_bateau = ?," +
                    "vitesse_bateau = ?," +
                    "vitesse_max_bateau = ?," +
                    "tirant_deau_bateau = ?," +
                    "nbre_voiles_bateau = ? " +
                    "WHERE id_bateau = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, marque);
            pstmt.setString(2, modele);
            pstmt.setInt(3, vitesse);
            pstmt.setInt(4, vmax);
            pstmt.setDouble(5, tirantDeau);
            pstmt.setInt(6, nbreVoiles);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            System.out.print("Mise à jour.");
        } catch (SQLException e) {
            System.out.println("Erreur quant à la mise à jour des données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
