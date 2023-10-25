package model;

public class Prostorija {
    private int sprat;
    private int prostorijaID;
    private StanjeProstorije stanjeProstorije;

    public Prostorija(int sprat, int prostorijaID, StanjeProstorije stanjeProstorije) {
        this.sprat = sprat;
        this.prostorijaID = prostorijaID;
        this.stanjeProstorije = stanjeProstorije;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public int getProstorijaID() {
        return prostorijaID;
    }

    public void setProstorijaID(int prostorijaID) {
        this.prostorijaID = prostorijaID;
    }

    public StanjeProstorije getStanjeProstorije() {
        return stanjeProstorije;
    }

    public void setStanjeProstorije(StanjeProstorije stanjeProstorije) {
        this.stanjeProstorije = stanjeProstorije;
    }


    @Override
    public String toString() {
        return "ID: " + prostorijaID + "  Sprat: " + sprat + " ";
    }
}
