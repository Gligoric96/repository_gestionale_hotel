package DAO;

import Entity.Prenotazione;
import java.util.List;

public interface PrenotazioneDaoInterface {
    void aggiungiPrenotazione(Prenotazione prenotazione);
    Prenotazione leggiPrenotazione(int idPrenotazione);
    List<Prenotazione> getTutteLePrenotazioni();
    void aggiornaPrenotazione(Prenotazione prenotazione);
    void eliminaPrenotazione(int idPrenotazione);
}
