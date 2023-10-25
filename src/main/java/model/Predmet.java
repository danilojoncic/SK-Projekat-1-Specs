package model;

public class Predmet {

    private String ime;
    private String profesor;
    private String asistent;
    private String demonstrator;
    private boolean izborni;
    private int ESPB;

    public Predmet(String ime, String profesor, int ESPB) {
        this.ime = ime;
        this.profesor = profesor;
        this.ESPB = ESPB;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getAsistent() {
        return asistent;
    }

    public void setAsistent(String asistent) {
        this.asistent = asistent;
    }

    public String getDemonstrator() {
        return demonstrator;
    }

    public void setDemonstrator(String demonstrator) {
        this.demonstrator = demonstrator;
    }

    public boolean isIzborni() {
        return izborni;
    }

    public void setIzborni(boolean izborni) {
        this.izborni = izborni;
    }

    public int getESPB() {
        return ESPB;
    }

    public void setESPB(int ESPB) {
        this.ESPB = ESPB;
    }
}
