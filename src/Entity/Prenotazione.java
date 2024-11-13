package Entity;

import java.time.LocalDate;
import java.sql.Date;

public class Prenotazione {

    private int id;
    private int idOspite;
    private int idCamera;
    private Date dataCheckIn;
    private Date dataChekOut;

    // Costruttore

    public Prenotazione(int id, int idOspite, int idCamera, Date dataCheckIn, Date dataChekOut) {
        this.id = id;
        this.idOspite = idOspite;
        this.idCamera = idCamera;
        this.dataCheckIn = dataCheckIn;
        this.dataChekOut = dataChekOut;
    }


    // Costruttore senza id
    public Prenotazione(int idOspite, int idCamera, Date dataCheckIn, Date dataChekOut) {
        this.idOspite = idOspite;
        this.idCamera = idCamera;
        this.dataCheckIn = dataCheckIn;
        this.dataChekOut = dataChekOut;
    }


    // Getter e Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOspite() {
        return idOspite;
    }

    public void setIdOspite(int idOspite) {
        this.idOspite = idOspite;
    }

    public int getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(int idCamera) {
        this.idCamera = idCamera;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataChekOut() {
        return dataChekOut;
    }

    public void setDataChekOut(Date dataChekOut) {
        this.dataChekOut = dataChekOut;
    }
}
