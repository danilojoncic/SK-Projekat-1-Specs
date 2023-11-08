package model.boljeRijesenje;

import java.awt.dnd.DragSource;
import java.time.LocalDate;
import java.util.*;

public class Raspored {


    private Date datumDoKadaVazi;
    private Date datumOdKadaVazi;

    private List<HashMap<String,List<Dogadjaj>>> bozePomozi; // svaka kolona jedog reda ce u jednom trenutku biti kljuc a za vrednost kljuca ce biti lista ostalih kolona u redu
    private List<Dogadjaj> dogadjaji; // lista svih dogadjaja
    private Dogadjaj header; // header je imena kolona za gui


    public Raspored(){

    }

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





    public Date getDatumOdKadaVazi() {
        return datumOdKadaVazi;
    }

    public void setDatumOdKadaVazi(Date datumOdKadaVazi) {
        this.datumOdKadaVazi = datumOdKadaVazi;
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
//        if(noviDogadjaji.isEmpty()){
//            return this;
//        }
        this.setDogadjaji(noviDogadjaji);
        List<HashMap<String, List<Dogadjaj>>> listaHmapi = new ArrayList<>();
        for (int i = 0; i < noviDogadjaji.get(0).stavkeDogadjaja.size(); i++) {
            listaHmapi.add(new HashMap<String, List<Dogadjaj>>());
        }
        String currentString;
        HashMap<String, List<Dogadjaj>> hashMap;
        for (Dogadjaj dogadjaj : this.dogadjaji) {
            for (int i = 0; i < dogadjaj.stavkeDogadjaja.size(); i++) {
                currentString = dogadjaj.stavkeDogadjaja.get(i); // Get the string
                hashMap = listaHmapi.get(i);
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


    public void dodajPoljeUDogadjaj(int index,String novoPolje){
        //dodamo polje za datum, na listi stringova jednog dogadjaja, zatim pozovemo refresh sto nam vrati hashMape ponovo
        //povezane
        this.dogadjaji.get(index).stavkeDogadjaja.add(novoPolje);
        //refresh ce korisnik sam da unese na sami kraj da se ne bi gubilo vrijeme
    }



    public boolean idiNaUvidUPonedeljak(Dogadjaj dogadjaj,List<Integer> mojaListaIndeksa){
        List<Dogadjaj> tempFilter;
        Raspored joker = this;
        for(int i = 0; i < mojaListaIndeksa.size();i++){
            System.out.println("Pre ovoga");
            tempFilter = vratiFiltrirano(dogadjaj.stavkeDogadjaja.get(mojaListaIndeksa.get(i)));
            System.out.println("Posle ovoga");
            if(tempFilter.isEmpty())
                return true;
            joker.refresh(tempFilter);
            System.out.println("Posle refresha " + i);
            //this.odstampajRaspored();
        }
        System.out.println("Velicina dogadjaja: " + dogadjaji.size());
        if(joker.dogadjaji.size() == 0){
            System.out.println("u ifu");
            return true;
        }else{
            System.out.println("NE MOZE MICO!");
            return false;
        }
    }


    public void odstampajRaspored(){
        System.out.println( "Linija " + this.dogadjaji.size());
        for (Dogadjaj dogadjaj : this.dogadjaji) {
            System.out.println( "Linija " + dogadjaj.toString());
        }
    }

    public Raspored kloniraj(Raspored raspored){
        Raspored raspored1 = new Raspored();
        raspored1.setHeader(raspored.getHeader());
        raspored1.setDogadjaji(raspored.getDogadjaji());
        raspored1.setBozePomozi(raspored.getBozePomozi());
        return raspored1;

    }










}

