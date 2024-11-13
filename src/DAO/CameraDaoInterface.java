package DAO;
import Entity.Camera;
import java.util.List;

public interface CameraDaoInterface {

    void aggiungiCamera(Camera camera);

    Camera leggiCamera(int idCamera);

    List<Camera> getTutteLeCamere();

    void aggiornaCamera(Camera camera);

    void eliminaCamera(int idCamera);

    public interface CameraDAOInterface {
        void aggiungiCamera(Camera camera);
        Camera leggiCamera(int idCamera);
        List<Camera> getTutteLeCamere();
        void aggiornaCamera(Camera camera);
        void eliminaCamera(int idCamera);
    }

}
