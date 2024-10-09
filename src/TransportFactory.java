import java.sql.Connection;

public class TransportFactory {
    public Transport creerTransport(String type,
                                    Connection con,
                                    String marque,
                                    String modele,
                                    Integer vitesse,
                                    Integer vmax,
                                    String immat,
                                    Double cylindree,
                                    Double tirant_deau,
                                    Integer nbrevoile,
                                    Double altitude,
                                    Double altitudemax,
                                    Double portee) {
        switch(type) {
            case "voiture":
                Voiture voiture = new Voiture(marque, modele, vitesse, vmax, immat, cylindree, con);
                voiture.insertVoiture();
                return voiture;
            default:
                return null;
        }
    }
}
