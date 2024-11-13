package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/gestionale_hotel";
    private static final String username = "root";
    private static final String password = "";
    private static Connection connection = null;


    //Costruttore privato per evitare istanziazioni
    private DatabaseConnection() {};

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }




    // Metodo per connettersi
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver non trovato!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connessione fallita");
            e.printStackTrace();
        }
        return null;
    }




    // Metodo per chiudere la connessione
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connessione chiusa");
            } catch (SQLException e) {
                System.out.println("Errore nella chiamata di chiusura");
                e.printStackTrace();
            }
        }
    }


}
