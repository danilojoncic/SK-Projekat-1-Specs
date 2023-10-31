package model.boljeRijesenje;

import java.awt.dnd.DragSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Raspored {


    private Date datumDoKadaVazi;

    private List<HashMap<String,List<Dogadjaj>>> bozePomozi; // svaka kolona jedog reda ce u jednom trenutku biti kljuc a za vrednost kljuca ce biti lista ostalih kolona u redu
    private List<Dogadjaj> dogadjaji; // lista svih dogadjaja
    private Dogadjaj header; // header je imena kolona za gui


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

    public List<Dogadjaj> vratiFiltrirano(String filter){
        //to do za sve cak i krajeve rijeci
        for (HashMap<String, List<Dogadjaj>> stringListHashMap : bozePomozi) {
            if (stringListHashMap.get(filter) != null){
                System.out.println("Pronasao");
                return stringListHashMap.get(filter);
            }
        }
        System.out.println("Nije pronasao");
        return null;
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



}

