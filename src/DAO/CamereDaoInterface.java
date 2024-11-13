package DAO;
import Entity.Camere;
import java.util.List;

public interface CamereDaoInterface {

    void aggiungiCamera(Camere camera);

    Camere leggiCamera(int idCamera);

    List<Camere> getTutteLeCamere();

    void aggiornaCamera(Camere camera);

    void eliminaCamera(int idCamera);

    public interface CameraDAOInterface {
        void aggiungiCamera(Camere camera);
        Camere leggiCamera(int idCamera);
        List<Camere> getTutteLeCamere();
        void aggiornaCamera(Camere camera);
        void eliminaCamera(int idCamera);
    }

}
