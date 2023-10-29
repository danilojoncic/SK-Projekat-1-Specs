package model.boljeRijesenje;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Raspored {


    private Date datumDoKadaVazi;

    private List<HashMap<String,List<Dogadjaj>>> bozePomozi;
    private List<Dogadjaj> dogadjaji;
    private Dogadjaj header;


    public Raspored(Date date) {
        this.datumDoKadaVazi = date;
        bozePomozi = new ArrayList<HashMap<String,List<Dogadjaj>>>();
        dogadjaji = new ArrayList<>();
    }

    public Dogadjaj getHeader() {
        return header;
    }

    public void setHeader(Dogadjaj header) {
        this.header = header;
    }


    public Date getDatumDoKadaVazi() {
        return datumDoKadaVazi;
    }

    public void setDatumDoKadaVazi(Date datumDoKadaVazi) {
        this.datumDoKadaVazi = datumDoKadaVazi;
    }

    public List<HashMap<String, List<Dogadjaj>>> getBozePomozi() {
        return bozePomozi;
    }

    public void setBozePomozi(List<HashMap<String, List<Dogadjaj>>> bozePomozi) {
        this.bozePomozi = bozePomozi;
    }

    public List<Dogadjaj> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaj> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }
}
