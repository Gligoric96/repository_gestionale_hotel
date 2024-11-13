package DAO;

import DB.DatabaseConnection;
import Entity.Prenotazione;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class PrenotazioneDaoImpl implements PrenotazioneDaoInterface {

    @Override
    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        String query = "INSERT INTO prenotazioni (fk_id_ospite, fk_id_camera, data_check_in, data_check_out) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, prenotazione.getIdOspite());
            stmt.setInt(2, prenotazione.getIdCamera());
            stmt.setDate(3, prenotazione.getDataCheckIn());
            stmt.setDate(4, prenotazione.getDataChekOut());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prenotazione leggiPrenotazione(int idPrenotazione) {
        String query = "SELECT * FROM prenotazioni WHERE id_prenotazione = ?";
        Prenotazione prenotazione = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPrenotazione);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prenotazione = new Prenotazione(
                        rs.getInt("id_prenotazione"),
                        rs.getInt("fk_id_ospite"),
                        rs.getInt("fk_id_camera"),
                        rs.getDate("data_check_in"),
                        rs.getDate("data_check_out")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prenotazione;
    }

    @Override
    public List<Prenotazione> getTutteLePrenotazioni() {
        String query = "SELECT * FROM prenotazioni";
        List<Prenotazione> prenotazioni = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Prenotazione prenotazione = new Prenotazione(
                        rs.getInt("id_prenotazione"),
                        rs.getInt("fk_id_ospite"),
                        rs.getInt("fk_id_camera"),
                        rs.getDate("data_check_in"),
                        rs.getDate("data_check_out")
                );
                prenotazioni.add(prenotazione);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prenotazioni;
    }

    @Override
    public void aggiornaPrenotazione(Prenotazione prenotazione) {
        String query = "UPDATE prenotazioni SET fk_id_ospite = ?, fk_id_camera = ?, data_check_in = ?, data_check_out = ? WHERE id_prenotazione = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, prenotazione.getIdOspite());
            stmt.setInt(2, prenotazione.getIdCamera());
            stmt.setDate(3, prenotazione.getDataCheckIn());
            stmt.setDate(4, prenotazione.getDataChekOut());
            stmt.setInt(5, prenotazione.getIdOspite());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaPrenotazione(int idPrenotazione) {
        String query = "DELETE FROM prenotazioni WHERE id_prenotazione = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPrenotazione);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
