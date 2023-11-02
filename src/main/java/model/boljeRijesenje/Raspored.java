package model.boljeRijesenje;

import java.awt.dnd.DragSource;
import java.time.LocalDate;
import java.util.*;

public class Raspored {


    private Date datumDoKadaVazi;

    private List<HashMap<String,List<Dogadjaj>>> bozePomozi; // svaka kolona jedog reda ce u jednom trenutku biti kljuc a za vrednost kljuca ce biti lista ostalih kolona u redu
    private List<Dogadjaj> dogadjaji; // lista svih dogadjaja
    private Dogadjaj header; // header je imena kolona za gui

    private LocalDate pocetni;

    private LocalDate krajnji;


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

    public LocalDate getPocetni() {
        return pocetni;
    }

    public void setPocetni(LocalDate pocetni) {
        this.pocetni = pocetni;
    }

    public LocalDate getKrajnji() {
        return krajnji;
    }

    public void setKrajnji(LocalDate krajnji) {
        this.krajnji = krajnji;
    }

    public List<Dogadjaj> vratiFiltrirano(String filter){
        //to do za sve cak i krajeve rijeci
        List<Dogadjaj> uhvacniDogadjaji = new ArrayList<>();
        for (HashMap<String, List<Dogadjaj>> stringListHashMap : bozePomozi) {
            for(String key : stringListHashMap.keySet()){
                if(key.contains(filter)){
                    List<Dogadjaj> keyDogadjaji = stringListHashMap.get(key);
                    uhvacniDogadjaji.addAll(keyDogadjaji);
                }
            }
        }
        return uhvacniDogadjaji;
    }

    public void dodajRedURaspored(Dogadjaj dogadjaj){
        this.dogadjaji.add(dogadjaj);
        this.refresh(this.dogadjaji);
    }

    public List<String> vratiListuOdgovarajuceMape(int index){
        List<String> odgovarajuci = new ArrayList<>();
        for(String s : this.bozePomozi.get(index).keySet()){
            odgovarajuci.add(s);
        }
        return odgovarajuci;
    }



    public Raspored refresh(List<Dogadjaj> noviDogadjaji) {
        this.setDogadjaji(noviDogadjaji);
        List<HashMap<String, List<Dogadjaj>>> listaHmapi = new ArrayList<>();
        for (int i = 0; i < noviDogadjaji.get(0).stavkeDogadjaja.size(); i++) {
            listaHmapi.add(new HashMap<String, List<Dogadjaj>>());
        }
        for (Dogadjaj dogadjaj : this.dogadjaji) {
            for (int i = 0; i < dogadjaj.stavkeDogadjaja.size(); i++) {
                String currentString = dogadjaj.stavkeDogadjaja.get(i); // Get the string
                HashMap<String, List<Dogadjaj>> hashMap = listaHmapi.get(i);
                if (!hashMap.containsKey(currentString)) {
                    hashMap.put(currentString, new ArrayList<>());
                }
                hashMap.get(currentString).add(dogadjaj);
            }
        }
        this.setBozePomozi(listaHmapi);
        return this;
    }


    //kolona predstavlja hashMapu koju brisemo
    public void obrisiKolonu(int index){
        for(Dogadjaj dogadjaj : this.dogadjaji){
            dogadjaj.stavkeDogadjaja.remove(index);
        }
        this.refresh(this.dogadjaji);
    }

    //brise dogadjaj iz ukupne liste dogadjaja
    public void obrisiRed(int index){
        this.dogadjaji.remove(index);
        this.refresh(this.dogadjaji);
    }





}

