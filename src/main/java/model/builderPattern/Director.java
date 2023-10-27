//package model.builderPattern;
//
//import model.raspored.*;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class Director {
//
//    List<String> timeline;
//    VremeVazenja vremeVazenja;
//    HashSet<Prostorija> prostorije;
//    List<Termin> termini;
//    HashSet<Predmet> predmeti;
//    Raspored raspored;
//    HashMap<Termin,Predmet> kolekcijaParova;
////    ConcreteBuilder concreteBuilder;
//
//    public Director(ConcreteBuilder concreteBuilder,int oznakaImplemtacije) {
//        this.concreteBuilder = concreteBuilder;
//        if(oznakaImplemtacije == 1){
//            napraviListuRaspored(concreteBuilder);
//        }else{
//            napraviNedeljniRaspored(concreteBuilder);
//        }
//    }
//
//    public Raspored napraviListuRaspored(ConcreteBuilder concreteBuilder){
//        concreteBuilder.reset();
//        concreteBuilder.postaviProstorije(prostorije);
//        concreteBuilder.postaviTermine(termini);
//        concreteBuilder.postaviKolekcijeParova(kolekcijaParova);
//        raspored = concreteBuilder.getRaspored();
//        return raspored;
//    }
//
//    public Raspored napraviNedeljniRaspored(ConcreteBuilder concreteBuilder){
//        concreteBuilder.reset();
//        concreteBuilder.postaviTimeline();
//        concreteBuilder.postaviVremeVazenje(vremeVazenja);
//        concreteBuilder.postaviTermine(termini);
//        concreteBuilder.postaviKolekcijeParova(kolekcijaParova);
//        concreteBuilder.postaviProstorije(prostorije);
//        concreteBuilder.postaviPredmete(predmeti);
//        raspored = concreteBuilder.getRaspored();
//        return raspored;
//    }
//
//
//    ///VRLO BITNO DA BI OVO FUNKCIONISALO MORAJU SE SETERI POZVATI JER SU
//    //POLJA OVE KLASE NE INICIJALIZOVANA,INICIJALIZACIJA SE OSTAVLJA KORISNIKU
//
//    public void setTimeline(List<String> timeline) {
//        this.timeline = timeline;
//    }
//
//    public void setVremeVazenja(VremeVazenja vremeVazenja) {
//        this.vremeVazenja = vremeVazenja;
//    }
//
//    public void setProstorije(HashSet<Prostorija> prostorije) {
//        this.prostorije = prostorije;
//    }
//
//    public void setTermini(List<Termin> termini) {
//        this.termini = termini;
//    }
//
//    public void setPredmeti(HashSet<Predmet> predmeti) {
//        this.predmeti = predmeti;
//    }
//
//    public void setKolekcijaParova(HashMap<Termin, Predmet> kolekcijaParova) {
//        this.kolekcijaParova = kolekcijaParova;
//    }
//
//    public List<String> getTimeline() {
//        return timeline;
//    }
//
//    public VremeVazenja getVremeVazenja() {
//        return vremeVazenja;
//    }
//
//    public HashSet<Prostorija> getProstorije() {
//        return prostorije;
//    }
//
//    public List<Termin> getTermini() {
//        return termini;
//    }
//
//    public HashSet<Predmet> getPredmeti() {
//        return predmeti;
//    }
//
//    public HashMap<Termin, Predmet> getKolekcijaParova() {
//        return kolekcijaParova;
//    }
//}
