package DAO;
import Entity.Camera;

import java.util.ArrayList;
import java.util.List;


public class CameraDaoImpl implements CameraDaoInterface {

    @Override
    public void aggiungiCamera(Camera camera) {
        // Implementazione JDBC per aggiungere una camera nel database
    }

    @Override
    public Camera leggiCamera(int idCamera) {
        // Implementazione JDBC per leggere una camera dal database
        return null; // Placeholder
    }

    @Override
    public List<Camera> getTutteLeCamere() {
        // Implementazione JDBC per ottenere tutte le camere
        return new ArrayList<>(); // Placeholder
    }

    @Override
    public void aggiornaCamera(Camera camera) {
        // Implementazione JDBC per aggiornare una camera nel database
    }

    @Override
    public void eliminaCamera(int idCamera) {
        // Implementazione JDBC per eliminare una camera dal database
    }
}
