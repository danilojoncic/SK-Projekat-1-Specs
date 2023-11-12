package model.boljeRijesenje;

public class Osobine {
    private int kapacitet;
    private boolean projektor;
    private boolean gtable;


    public Osobine(int kapacitet, boolean projektor, boolean gtable) {
        this.kapacitet = kapacitet;
        this.projektor = projektor;
        this.gtable = gtable;
    }


    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public boolean isProjektor() {
        return projektor;
    }

    public void setProjektor(boolean projektor) {
        this.projektor = projektor;
    }

    public boolean isGtable() {
        return gtable;
    }

    public void setGtable(boolean gtable) {
        this.gtable = gtable;
    }
}
