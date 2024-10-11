import java.sql.*;

public class Voiture implements Transport{
    private String marqueVoiture;
    private String modeleVoiture;
    private int vitesseVoiture;
    private int vitesseMaxVoiture;
    private String immatriculationVoiture;
    private double cylindreeVoiture;
    private Connection con;

    public Voiture(String marque, String modele, int vit, int maxvit, String immat, double cyl, Connection c) {
        this.marqueVoiture = marque;
        this.modeleVoiture = modele;
        this.vitesseVoiture = vit;
        this.vitesseMaxVoiture = maxvit;
        this.immatriculationVoiture = immat;
        this.cylindreeVoiture = cyl;
        this.con = c;
    }

    // Getters & Setters

    // Templates Interface Transport

    @Override
    public String getMarque() {
        return this.marqueVoiture;
    }

    @Override
    public String getModele() {
        return this.modeleVoiture;
    }

    @Override
    public int getVitesse() {
        return this.vitesseVoiture;
    }

    @Override
    public int getVitesseMax() {
        return this.vitesseMaxVoiture;
    }

    @Override
    public void setMarque(String marque) {
        this.marqueVoiture = marque;
    }

    @Override
    public void setModele(String modele) {
        this.modeleVoiture = modele;
    }

    @Override
    public void setVitesse(int vitesse) {
        this.vitesseVoiture = vitesse;
    }

    @Override
    public void setVitesseMax(int maxvit) {
        this.vitesseMaxVoiture = maxvit;
    }

    // Classe Voiture

    public String getImmatriculationVoiture() {
        return this.immatriculationVoiture;
    }

    public double getCylindreeVoiture() {
        return this.cylindreeVoiture;
    }

    // Fonctions & Procédures autres

    public void selectVoiture(int id) {
        try {
            String query = "SELECT * FROM voiture WHERE id_voiture = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String marque = rs.getString("marque_voiture");
                String modele = rs.getString("modele_voiture");
                int vitesse = rs.getInt("vitesse_voiture");
                int vitesseMax = rs.getInt("vitesse_max_voiture");
                String immat = rs.getString("num_immat_voiture");
                double cylindree = rs.getDouble("cylindree_voiture");

                System.out.println("Marque: " + marque + ", Modèle: " + modele + ", Vitesse: " + vitesse + ", Vitesse max: " + vitesseMax + ", Immat: " + immat + ", Cylindrée: " + cylindree);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void selectAllVoitures() {
        try {
            String query = "SELECT * FROM voiture";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID: - Marque: - Modèle: - Vitesse: - Vitesse max: - Immat.: - Cylindrée:");
            while (rs.next()) {
                int id = rs.getInt("id_voiture");
                String marque = rs.getString("marque_voiture");
                String modele = rs.getString("modele_voiture");
                int vitesse = rs.getInt("vitesse_voiture");
                int vitesseMax = rs.getInt("vitesse_max_voiture");
                String immat = rs.getString("num_immat_voiture");
                double cylindree = rs.getDouble("cylindree_voiture");

                System.out.println(id + ", " + marque + ", " + modele + ", " + vitesse + ", " + vitesseMax + ", " + immat + ", " + cylindree);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la recherche des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteVoiture(int id) {
        try {
            String query = "DELETE FROM voiture WHERE id_voiture = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,  id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la suppression des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertVoiture() {
        try {
            String query = "INSERT INTO voiture (marque_voiture, modele_voiture, vitesse_voiture, vitesse_max_voiture, num_immat_voiture, cylindree_voiture) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.marqueVoiture);
            pstmt.setString(2, this.modeleVoiture);
            pstmt.setInt(3, this.vitesseVoiture);
            pstmt.setInt(4, this.vitesseMaxVoiture);
            pstmt.setString(5, this.immatriculationVoiture);
            pstmt.setDouble(6, this.cylindreeVoiture);
            pstmt.executeUpdate();
            System.out.print("Insertion en base.");
            // con.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à l'insertion des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateVoiture(int id, String marque, String modele, Integer vitesse, Integer vmax, String immat, Double cylindree) {
        try {
            String query = "UPDATE voiture SET marque_voiture = ?," +
                    "modele_voiture = ?," +
                    "vitesse_voiture = ?," +
                    "vitesse_max_voiture = ?," +
                    "num_immat_voiture = ?," +
                    "cylindree_voiture = ? " +
                    "WHERE id_voiture = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, marque);
            pstmt.setString(2, modele);
            pstmt.setInt(3, vitesse);
            pstmt.setInt(4, vmax);
            pstmt.setString(5, immat);
            pstmt.setDouble(6, cylindree);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            System.out.print("Mise à jour.");
            // con.close();
        } catch (SQLException e) {
            System.out.println("Erreur quant à la mise à jour des données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
