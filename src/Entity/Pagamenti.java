package Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamenti {
    private int id;
    private int idPrenotazione;
    private BigDecimal importo;
    private LocalDate dataPagamento;

    // Costruttore

    public Pagamenti(int id, int idPrenotazione, BigDecimal importo, LocalDate dataPagamento) {
        this.id = id;
        this.idPrenotazione = idPrenotazione;
        this.importo = importo;
        this.dataPagamento = dataPagamento;
    }

    // Getter e Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
