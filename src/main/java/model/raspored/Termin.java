package model.raspored;

public class Termin {

    private String vremeOd;
    private String vremeDo;
    private int trajanje;

    private Dan dan;

    public Termin(String vremeOd, String vremeDo, int trajanje, Dan dan) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.trajanje = trajanje;
        this.dan = dan;
    }

    public Dan getDan() {
        return dan;
    }

    public void setDan(Dan dan) {
        this.dan = dan;
    }

    public String getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(String vremeOd) {
        this.vremeOd = vremeOd;
    }

    public String getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(String vremeDo) {
        this.vremeDo = vremeDo;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }
}
