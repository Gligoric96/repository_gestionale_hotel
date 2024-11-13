package DAO;

import DB.DatabaseConnection;
import Entity.Pagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDaoImpl implements PagamentoDaoInterface {




    @Override
    public void aggiungiPagamento(Pagamento pagamento) {
        String query = "INSERT INTO pagamenti (fk_id_prenotazione, importo, data_pagamento) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, pagamento.getIdPrenotazione());
            stmt.setBigDecimal(2, pagamento.getImporto());
            stmt.setDate(3, java.sql.Date.valueOf(pagamento.getDataPagamento()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pagamento leggiPagamento(int idPagamento) {
        String query = "SELECT * FROM pagamenti WHERE id_pagamento = ?";
        Pagamento pagamento = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPagamento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pagamento = new Pagamento(
                        rs.getInt("id_pagamento"),
                        rs.getInt("fk_id_prenotazione"),
                        rs.getBigDecimal("importo"),
                        rs.getDate("data_pagamento").toLocalDate()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pagamento;
    }

    @Override
    public List<Pagamento> getTuttiIPagamenti() {
        String query = "SELECT * FROM pagamenti";
        List<Pagamento> pagamenti = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("id_pagamento"),
                        rs.getInt("fk_id_prenotazione"),
                        rs.getBigDecimal("importo"),
                        rs.getDate("data_pagamento").toLocalDate()
                );
                pagamenti.add(pagamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pagamenti;
    }

    @Override
    public void aggiornaPagamento(Pagamento pagamento) {
        String query = "UPDATE pagamenti SET fk_id_prenotazione = ?, importo = ?, data_pagamento = ? WHERE id_pagamento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, pagamento.getIdPrenotazione());
            stmt.setBigDecimal(2, pagamento.getImporto());
            stmt.setDate(3, java.sql.Date.valueOf(pagamento.getDataPagamento())); // Conversione diretta da LocalDate a java.sql.Date
            stmt.setInt(4, pagamento.getIdPagamento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaPagamento(int idPagamento) {
        String query = "DELETE FROM pagamenti WHERE id_pagamento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPagamento);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

