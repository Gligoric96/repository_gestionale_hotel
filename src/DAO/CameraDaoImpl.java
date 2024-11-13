package DAO;

import DB.DatabaseConnection;
import Entity.Camera;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CameraDaoImpl implements CameraDaoInterface {

    @Override
    public void popolaTabellaCamere() {
        String insertCamere = "INSERT INTO camere (numero_camera, tipologia, prezzo, stato) VALUES " +
                "(1, 'Camera Singola', 35, 'Disponibile'), " +
                "(2, 'Camera Doppia', 50, 'Disponibile'), " +
                "(3, 'Camera Tripla', 70, 'Disponibile'), " +
                "(4, 'Camera Matrimoniale con Vasca Idromassaggio', 100, 'Disponibile')";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            int rows = statement.executeUpdate(insertCamere);
            System.out.println(rows + " righe inserite.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aggiungiCamera(Camera camera) {
        String insertCamera = "INSERT INTO camere (numero_camera, tipologia, prezzo, stato) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertCamera)) {

            preparedStatement.setInt(1, camera.getNumeroCamera());
            preparedStatement.setString(2, camera.getTipologia());
            preparedStatement.setBigDecimal(3, camera.getPrezzo());
            preparedStatement.setString(4, camera.getStato());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Camera leggiCamera(int idCamera) {
        String selectCameraById = "SELECT * FROM camere WHERE id_camera = ?";
        Camera camera = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectCameraById)) {

            preparedStatement.setInt(1, idCamera);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id_camera");
                int numeroCamera = resultSet.getInt("numero_camera");
                String tipologia = resultSet.getString("tipologia");
                BigDecimal prezzo = resultSet.getBigDecimal("prezzo");
                String stato = resultSet.getString("stato");

                camera = new Camera(id, numeroCamera, tipologia, prezzo, stato);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return camera;
    }

    @Override
    public ArrayList<Camera> getTutteLeCamere() {
        String selectAllCamere = "SELECT * FROM camere";
        ArrayList<Camera> camere = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAllCamere)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_camera");
                int numeroCamera = resultSet.getInt("numero_camera");
                String tipologia = resultSet.getString("tipologia");
                BigDecimal prezzo = resultSet.getBigDecimal("prezzo");
                String stato = resultSet.getString("stato");

                camere.add(new Camera(id, numeroCamera, tipologia, prezzo, stato));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return camere;
    }

    @Override
    public void aggiornaCamera(Camera camera, String stato) {
        String updateStatoCamera = "UPDATE camere SET stato = ? WHERE id_camera = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateStatoCamera)) {

            preparedStatement.setString(1, stato);
            preparedStatement.setInt(2, camera.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaCamera(int idCamera) {
        String deleteCamera = "DELETE FROM camere WHERE id_camera = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteCamera)) {

            preparedStatement.setInt(1, idCamera);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

