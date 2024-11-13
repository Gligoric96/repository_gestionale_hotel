package DAO;

import Entity.Camera;
import java.util.ArrayList;

public interface CameraDaoInterface {
    void popolaTabellaCamere();
    void aggiungiCamera(Camera camera);
    Camera leggiCamera(int idCamera);
    ArrayList<Camera> getTutteLeCamere();
    void aggiornaCamera(Camera camera, String stato);
    void eliminaCamera(int idCamera);
}

