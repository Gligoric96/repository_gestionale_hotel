import DAO.*;
import Entity.Camera;
import Entity.Ospite;
import Entity.Prenotazione;

import java.util.ArrayList;
import java.sql.Date;

public class GestioneHotelApp {

    private CameraDaoInterface cameraDaoInterface = new CameraDaoImpl();
    private OspiteDaoInterface ospiteDaoInteface = new OspiteDaoImpl();
    private PagamentoDaoInterface pagamentoDaoInteface = new PagamentoDaoImpl();
    private PrenotazioneDaoInterface prenotazioneDaoInterface = new PrenotazioneDaoImpl();


    public void prenotaUnaCamera(Ospite ospite, int cameraId, Date checkIn, Date checkOut) {

        ospiteDaoInteface.createOspite(ospite);

        Camera camera = cameraDaoInterface.leggiCamera(cameraId);

        if(camera.getStato().equals("Disponibile")) {

            prenotazioneDaoInterface.aggiungiPrenotazione(new Prenotazione(ospite.getIdOspite(), camera.getId(), checkIn, checkOut));

            cameraDaoInterface.aggiornaCamera(camera, "Non disponibile");

            System.out.println("Camera prenotata con successo!");

        } else {
            System.out.println("La camera selezionata non è disponibile.");
        }
    }

    public void rimuoviCamera(int idCamera){
        cameraDaoInterface.eliminaCamera(idCamera);
        System.out.println("Camera eliminata correttamente!");
    }



    // Visualizza camere Disponibili/Non Disponibili
    public void visualizzaLeCamereDisponibili() {

        ArrayList<Camera> camereDisponibili = cameraDaoInterface.getTutteLeCamere();

        for (Camera camera : camereDisponibili) {
            if (camera.getStato().equals("Disponibile")) {
                System.out.println("Camera disponibile: " + camera.getId() + ", Numero: " + camera.getNumeroCamera() +
                        ", Tipologia: " + camera.getTipologia() + ", Prezzo: " + camera.getPrezzo());
            }
        }
    }

    public void visualizzaLeCamereNonDisponibili() {

        ArrayList<Camera> camereDisponibili = cameraDaoInterface.getTutteLeCamere();

        for (Camera camera : camereDisponibili) {
            if (camera.getStato().equals("Non disponibile")) {
                System.out.println("Camera non disponibile: " + camera.getId() + ", Numero: " + camera.getNumeroCamera() +
                        ", Tipologia: " + camera.getTipologia() + ", Prezzo: " + camera.getPrezzo());
            }
        }
    }

    public void visualizzaTutteCamere(){
        ArrayList<Camera> camereTutte = cameraDaoInterface.getTutteLeCamere();
        for(Camera c : camereTutte){
            System.out.println("ID " + c.getId() + " NUMERO " + c.getNumeroCamera() + " TIPOLOGIA " +  c.getTipologia() + " PREZZO " + c.getPrezzo() + "STATO " + c.getStato());
        }
    }

















}
