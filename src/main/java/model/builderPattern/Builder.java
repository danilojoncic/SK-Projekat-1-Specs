package model.builderPattern;

import model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class Builder {
    Raspored raspored;

    public Raspored reset(){
        return new Raspored();
    }
    public void postaviVremeVazenje(VremeVazenja vremeVazenja){
        raspored.setVremeVazenja(vremeVazenja);
    }


    public void postaviTimeline(){
        raspored.setTimeline(raspored.generisiVremena());
    }

    public void postaviProstorije(HashSet<Prostorija> prostorije){
        raspored.setProstorije(prostorije);
    }

    public void postaviTermine(List<Termin> termini){
        raspored.setTermini(termini);
    }

    public void postaviPredmete(HashSet<Predmet> predmeti){
        raspored.setPredmeti(predmeti);
    }

    public void postaviKolekcijeParova(HashMap<Termin,Predmet> kolekcijeParova){
        raspored.setKolekcijaParova(kolekcijeParova);
    }

}
