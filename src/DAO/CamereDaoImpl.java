package DAO;
import Entity.Camere;

import java.util.ArrayList;
import java.util.List;


public class CamereDaoImpl implements CamereDaoInterface {

    @Override
    public void aggiungiCamera(Camere camera) {
        // Implementazione JDBC per aggiungere una camera nel database
    }

    @Override
    public Camere leggiCamera(int idCamera) {
        // Implementazione JDBC per leggere una camera dal database
        return null; // Placeholder
    }

    @Override
    public List<Camere> getTutteLeCamere() {
        // Implementazione JDBC per ottenere tutte le camere
        return new ArrayList<>(); // Placeholder
    }

    @Override
    public void aggiornaCamera(Camere camera) {
        // Implementazione JDBC per aggiornare una camera nel database
    }

    @Override
    public void eliminaCamera(int idCamera) {
        // Implementazione JDBC per eliminare una camera dal database
    }
}
