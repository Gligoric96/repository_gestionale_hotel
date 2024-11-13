package Entity;

import java.time.LocalDate;

public class Prenotazione {

    private int id;
    private int idOspite;
    private int idCamera;
    private LocalDate dataCheckIn;
    private LocalDate dataChekOut;

    // Costruttore

    public Prenotazione(int id, int idOspite, int idCamera, LocalDate dataCheckIn, LocalDate dataChekOut) {
        this.id = id;
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

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataChekOut() {
        return dataChekOut;
    }

    public void setDataChekOut(LocalDate dataChekOut) {
        this.dataChekOut = dataChekOut;
    }
}
