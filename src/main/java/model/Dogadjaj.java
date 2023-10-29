package model;

public class Dogadjaj {
    String dan;
    String ucionica;
    String nastavnik;

    String predmet;

    String termin;

    String grupe;


    public Dogadjaj(String dan, String ucionica, String nastavnik, String predmet, String termin, String grupe) {
        this.dan = dan;
        this.ucionica = ucionica;
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.termin = termin;
        this.grupe = grupe;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public void setUcionica(String ucionica) {
        this.ucionica = ucionica;
    }

    public void setNastavnik(String nastavnik) {
        this.nastavnik = nastavnik;
    }

    @Override
    public String toString() {
        return "Dogadjaj : [" + dan + "] [" + nastavnik + "] [" + ucionica + "] [" + predmet + "] [" + termin + "] [" + grupe + "]";
    }
}
