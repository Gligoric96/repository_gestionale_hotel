package Entity;

import java.math.BigDecimal;

public class Camera {
    private int id;
    private int numeroCamera;
    private String tipologia;
    private BigDecimal prezzo;
    private String stato;

    // Costruttore
    public Camera(int id, int numeroCamera, String tipologia, BigDecimal prezzo, String stato) {
        this.id = id;
        this.numeroCamera = numeroCamera;
        this.tipologia = tipologia;
        this.prezzo = prezzo;
        this.stato = stato;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCamera() {
        return numeroCamera;
    }

    public void setNumeroCamera(int numeroCamera) {
        this.numeroCamera = numeroCamera;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}

