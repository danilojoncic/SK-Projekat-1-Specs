package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Raspored {

    List<String> timeline;
    VremeVazenja vremeVazenja;
    HashSet<Prostorija> prostorije;
    List<Termin> termini;
    HashSet<Predmet> predmeti;

    HashMap<Termin,Predmet> kolekcijaParova;



    public Raspored(VremeVazenja vremeVazenja, HashSet<Prostorija> prostorije, List<Termin> termini, HashSet<Predmet> predmeti) {
        this.timeline = generisiVremena();
        this.vremeVazenja = vremeVazenja;
        this.prostorije = prostorije;
        this.termini = termini;
        this.predmeti = predmeti;
    }

    public List<String> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<String> timeline) {
        this.timeline = timeline;
    }

    public VremeVazenja getVremeVazenja() {
        return vremeVazenja;
    }

    public void setVremeVazenja(VremeVazenja vremeVazenja) {
        this.vremeVazenja = vremeVazenja;
    }

    public HashSet<Prostorija> getProstorije() {
        return prostorije;
    }

    public void setProstorije(HashSet<Prostorija> prostorije) {
        this.prostorije = prostorije;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    public HashSet<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(HashSet<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public List<String> generisiVremena() {
        List<String> vremena = new ArrayList<>();
        String s;
        for (int i = 9; i <= 21; i++) {
            if (i < 10)
                s = "0"+i+":00h";
             else
                s = i + ":00h";
            vremena.add(s);
        }

        return vremena;
    }
}
