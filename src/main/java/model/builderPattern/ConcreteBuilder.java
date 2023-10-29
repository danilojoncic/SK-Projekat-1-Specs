//package model.builderPattern;
//
//import model.raspored.*;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class ConcreteBuilder{
//    Raspored raspored;
//
//    public void reset(){
//        raspored = new Raspored();
//    }
//    public void postaviVremeVazenje(VremeVazenja vremeVazenja){
//        raspored.setVremeVazenja(vremeVazenja);
//    }
//
//
//    public void postaviTimeline(){
//        raspored.setTimeline(raspored.generisiVremena());
//    }
//
//    public void postaviProstorije(HashSet<Prostorija> prostorije){
//        raspored.setProstorije(prostorije);
//    }
//
//    public void postaviTermine(List<Termin> termini){
//        raspored.setTermini(termini);
//    }
//
//    public void postaviPredmete(HashSet<Predmet> predmeti){
//        raspored.setPredmeti(predmeti);
//    }
//
//    public void postaviKolekcijeParova(HashMap<Termin,Predmet> kolekcijeParova){
//        raspored.setKolekcijaParova(kolekcijeParova);
//    }
//    public Raspored getRaspored(){
//       //raspored = this.reset();
//       return raspored;
//    }
//}
