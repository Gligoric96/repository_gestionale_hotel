package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DatabaseConnection;
import Entity.Ospite;



public class OspiteDaoImpl implements OspiteDaoInterface {

    // Metodo CREATE per inserire un nuovo ospite
    @Override
    public void createOspite(Ospite ospite) {
        String sql = "INSERT INTO ospiti (nome, cognome, telefono, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ospite.getNome());
            preparedStatement.setString(2, ospite.getCognome());
            preparedStatement.setString(3, ospite.getTelefono());
            preparedStatement.setString(4, ospite.getEmail());

            preparedStatement.executeUpdate();
            System.out.println("Ospite inserito con successo.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per recuperare un ospite tramite ID
    @Override
    public Ospite getOspiteById(int id) {
        String sql = "SELECT * FROM ospiti WHERE id_ospite = ?";
        Ospite ospite = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ospite = new Ospite(
                        resultSet.getInt("id_ospite"),
                        resultSet.getString("nome"),
                        resultSet.getString("cognome"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email")
                );
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ospite != null) {
            System.out.println("ID " + ospite.getIdOspite() +
                    "\nNOME " + ospite.getNome() +
                    "\nCOGNOME " + ospite.getCognome() +
                    "\nTELEFONO " + ospite.getTelefono() +
                    "\nMAIL " + ospite.getEmail());
        } else {
            System.out.println("Nessun ospite trovato con l'ID: " + id);
        }

        return ospite;
    }

    // Metodo per eliminare un ospite tramite ID
    @Override
    public void deleteOspite(int id) {
        String sql = "DELETE FROM ospiti WHERE id_ospite = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ospite eliminato con successo.");
            } else {
                System.out.println("Nessun ospite trovato con l'ID specificato: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per aggiornare le informazioni di un ospite
    @Override
    public void updateOspite(Ospite ospite) {
        String sql = "UPDATE ospiti SET nome = ?, cognome = ?, telefono = ?, email = ? WHERE id_ospite = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ospite.getNome());
            preparedStatement.setString(2, ospite.getCognome());
            preparedStatement.setString(3, ospite.getTelefono());
            preparedStatement.setString(4, ospite.getEmail());
            preparedStatement.setInt(5, ospite.getIdOspite());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ospite aggiornato con successo.");
            } else {
                System.out.println("Nessun ospite trovato con l'ID specificato: " + ospite.getIdOspite());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per recuperare tutti gli ospiti
    @Override
    public List<Ospite> getAllOspiti() {
        String sql = "SELECT * FROM ospiti";
        List<Ospite> ospiti = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Ospite ospite = new Ospite(
                        resultSet.getInt("id_ospite"),
                        resultSet.getString("nome"),
                        resultSet.getString("cognome"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email")
                );
                ospiti.add(ospite);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Ospite o : ospiti) {
            System.out.println("ID " + o.getIdOspite() +
                    "\nNOME " + o.getNome() +
                    "\nCOGNOME " + o.getCognome() +
                    "\nTELEFONO " + o.getTelefono() +
                    "\nMAIL " + o.getEmail());
            System.out.println("-------------------");
        }
        return ospiti;
    }
}

