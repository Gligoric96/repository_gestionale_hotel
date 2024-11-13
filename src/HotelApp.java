import Entity.Camera;
import Entity.Ospite;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class HotelApp {

    GestioneHotelApp hotelApp = new GestioneHotelApp();

    public void avvioProgramma() {

        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        GestioneHotelApp gestioneHotelApp = new GestioneHotelApp();

        while (continueProgram) {

            try {

                System.out.println("Scegli un'opzione:");
                System.out.println("1. Prenota una camera");
                System.out.println("2. Rimuovi una camera");
                System.out.println("3. Visualizza camere disponibili");
                System.out.println("4. Visualizza camere prenotate");
                System.out.println("5. Visualizza camere disponibili e non disponibili");
                System.out.println("6. Exit");

                int choise = scanner.nextInt();
                scanner.nextLine();

                // stringa.trim.isEmpty
                // stringa.equalsIgnoreCase

                switch (choise) {
                    case 1:
                        System.out.println("Nome dell'ospite");
                        String nome = scanner.nextLine();
                        System.out.println("Cognome dell'ospite");
                        String cognome = scanner.nextLine();
                        System.out.println("Telefono dell'ospite");
                        String telefono = scanner.nextLine();
                        System.out.println("Email dell'ospite");
                        String email = scanner.nextLine();

                        Ospite ospite = new Ospite(nome, cognome, telefono, email);

                        System.out.println("Queste sono le camere disponibili: ");
                        gestioneHotelApp.visualizzaLeCamereDisponibili();
                        System.out.println("Digita l'id della camera che vuoi prenotare");
                        int cameraId = scanner.nextInt();

                        System.out.println("Data check-in (yyyy-mm-dd)");
                        String dataInput = scanner.nextLine();
                        LocalDate date = LocalDate.parse(dataInput);
                        Date dataCheckIn = java.sql.Date.valueOf(date);

                        System.out.println("Data check-out (yyyy-mm-dd)");
                        String dateInput = scanner.nextLine();
                        LocalDate data = LocalDate.parse(dateInput);
                        Date dataChekOut = java.sql.Date.valueOf(data);

                        gestioneHotelApp.prenotaUnaCamera(ospite, cameraId, dataCheckIn, dataChekOut);
                        break;

                    case 2:
                        System.out.println("Elenco camere:");
                        gestioneHotelApp.visualizzaLeCamereDisponibili();

                        System.out.println("Inserisci l'ID della camera da eliminare:");
                        int idCamera = scanner.nextInt();
                        scanner.nextLine();
                        gestioneHotelApp.rimuoviCamera(idCamera);
                        break;


                    case 3:
                        gestioneHotelApp.visualizzaLeCamereDisponibili();
                        break;

                    case 4:
                        gestioneHotelApp.visualizzaLeCamereNonDisponibili();
                        break;

                    case 5:
                        gestioneHotelApp.visualizzaTutteCamere();
                        break;

                    case 6:
                        continueProgram = false;
                        break;

                    default:
                        System.out.println("Input non valido");
                }

            } catch (InputMismatchException e) {
                System.out.println("L'input non è un numero");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}
