import DAO.CameraDaoImpl;
import Entity.Camera;

public class Main {
    public static void main(String[] args) {


        HotelApp hotelApp = new HotelApp();
        CameraDaoImpl camera = new CameraDaoImpl();



        hotelApp.avvioProgramma();
    }

}