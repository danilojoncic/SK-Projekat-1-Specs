package model;

public class StanjeProstorije {
    private int kapacitet;
    private boolean projektor;
    private boolean grafickaTabla;

    public StanjeProstorije(int kapacitet, boolean projektor, boolean grafickaTabla) {
        this.kapacitet = kapacitet;
        this.projektor = projektor;
        this.grafickaTabla = grafickaTabla;
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

    public boolean isGrafickaTabla() {
        return grafickaTabla;
    }

    public void setGrafickaTabla(boolean grafickaTabla) {
        this.grafickaTabla = grafickaTabla;
    }
}
