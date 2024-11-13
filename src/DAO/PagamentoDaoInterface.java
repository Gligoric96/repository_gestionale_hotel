package DAO;

import Entity.Pagamento;
import java.util.List;


public interface PagamentoDaoInterface {
    void aggiungiPagamento(Pagamento pagamento);
    Pagamento leggiPagamento(int idPagamento);
    List<Pagamento> getTuttiIPagamenti();
    void aggiornaPagamento(Pagamento pagamento);
    void eliminaPagamento(int idPagamento);
}
