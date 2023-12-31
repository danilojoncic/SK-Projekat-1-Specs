package model.boljeRijesenje;

import java.awt.dnd.DragSource;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Raspored {


    private Date datumDoKadaVazi;
    private Date datumOdKadaVazi;

    //inace ovo ce da povezuje ucionicu kao string sa objektom osobine koji povezujemo na njega
    private HashMap<String,Osobine> tabLimundo;

    //neko polje koje ima povezano sa sobom timeline sa nekim terminima

    /**
     * slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay predstavlja HashMap strukturu u koju cuvamo slobodne termine
     * za svaku ucionicu po principu [Par (Dan + ucionica), lista termina]
     *
     * */
    private HashMap<Par,List<String>> slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay = new HashMap<>();
    //RAF5 -> 11:15-13:00
    //900,915,100,1015;
    //komponente 11:15-13:00



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
    /**
     * vratiFiltritano() sluzi da vrati dogadjaje koji se poklapaju sa onim sto korisnik trazi
     * "Filtrira" tj. vraca dogadjaje u vidu liste dogadjaja na osnovu parametra koji korisnik prosledjuje
     *
     *@param filter string koji korisnik prosledjuje kao parametar za filtriranje
     *
     * */

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

    /**
     * refresh() metoda uzima novu listu dogadjaja i na osnovu nje "osvezava" raspored tako sto
     * obnavlja listu dogadjaja i hes mape potrebne za dalju manipulaciju njima
     *
     *@param noviDogadjaji je najaktuelnija lista dogadjaja koja se prosledjuje rasporedu
     *
     * */

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
//            System.out.println("Pre ovoga");
            tempFilter = vratiFiltrirano(dogadjaj.stavkeDogadjaja.get(mojaListaIndeksa.get(i)));
//            System.out.println("Posle ovoga");
            if(tempFilter.isEmpty())
                return true;
            joker.refresh(tempFilter);
//            System.out.println("Posle refresha " + i);
            //this.odstampajRaspored();
        }
        System.out.println("Velicina dogadjaja: " + dogadjaji.size());
        if(joker.dogadjaji.size() == 0){
//            System.out.println("u ifu");
            return true;
        }else{
//            System.out.println("NE MOZE MICO!");
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


    public HashMap<String, Osobine> getTabLimundo() {
        return tabLimundo;
    }

    public void setTabLimundo(HashMap<String, Osobine> tabLimundo) {
        this.tabLimundo = tabLimundo;
    }

    public HashMap<Par, List<String>> getSlobodniTerminiZaGledanjeGospodaraPrstenovaBluRay() {
        return slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay;
    }

    public void setSlobodniTerminiZaGledanjeGospodaraPrstenovaBluRay(HashMap<Par, List<String>> slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay) {
        this.slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay = slobodniTerminiZaGledanjeGospodaraPrstenovaBluRay;
    }



    private void izbaciZauzete(int pocetak, int kraj){
        //to do
        //ovo je header sa kolonom za termine
        String split[] = (this.dogadjaji.get(0).stavkeDogadjaja.get(5).split("\\-"));
        String start = split[0];
        String end = split[1]; //11:15 - 13:00
        //sada treba da prodjem kroz ostatak hashMape parova i da gledam da li se poklapa
        //zatim treba da timeline tog para da apdejtujem
        //prije brisanja iz te liste ja cu da pitam da li se on zapravo sadrzi u listu
        //u slucaju da se sazdri onda cu da obrisem
        //u slucaju da ne , ova metoda treba da da neku naznaku da je doslo do greske
        //ovo je sve dodatna provjere dodavanja termina
    }

    public void metniSveURaspored(int indexDan, int indeksUcionice){
        this.setSlobodniTerminiZaGledanjeGospodaraPrstenovaBluRay(initGospodarPrstenova(indexDan,indeksUcionice));
    }

    private HashMap<Par,List<String>> initGospodarPrstenova(int danIndeks,int ucionicaIndeks){
        HashMap<Par,List<String>> mapa = new HashMap<>();
        for(Dogadjaj dogadjaj : this.dogadjaji){
            ArrayList<String> stringovi = new ArrayList<>();
            Par par = new Par(dogadjaj.stavkeDogadjaja.get(danIndeks),dogadjaj.stavkeDogadjaja.get(ucionicaIndeks));
            mapa.put(par,initListaTermina(stringovi));
            //ovime su svi parovi dan-ucionica ubaceni sa svojim timeLinom koji je full sto znaci nijedan nije zauzet
            //mi njih zauzimamo sa metodom izbaciZauzete
        }
        return mapa;
    }


    private List<String> initListaTermina(List<String> lista){
        for(int i = 9; i < 22; i++){
            if(i < 10){
                lista.add("0"+i+":00");
                lista.add("0"+i+":15");
                continue;
            }
            lista.add(i+":00");
            lista.add(i+":15");
        }
        return lista;
    }
    private void fillContents(List<String> input,int index){
        input.add("Termin");
        input.add("Dan");
        input.add("Učionica");
        if(index != 0){
            input.add("Predmet");
        }
    }


    public void nejmarUPetercu(int index) {
        if(index == 0){
            List<Integer> zaBrisanje = new ArrayList<>();
            for (int i = 0; i <this.getHeader().getStavkeDogadjaja().size(); i++) {
                String columnHeader = this.getHeader().getStavkeDogadjaja().get(i);
                if (!columnHeader.equals("Termin") && !columnHeader.equals("Dan") && !columnHeader.equals("Učionica")) {
                    zaBrisanje.add(i);
                }
            }
            for (int i = zaBrisanje.size() - 1; i >= 0; i--) {
                int columnIndex = zaBrisanje.get(i);
                this.getHeader().getStavkeDogadjaja().remove(columnIndex);
            }
            for (int i = 0; i < this.getDogadjaji().size(); i++) {
                List<String> row = this.getDogadjaji().get(i).getStavkeDogadjaja();
                for (int j = zaBrisanje.size() - 1; j >= 0; j--) {
                    int columnIndex = zaBrisanje.get(j);
                    row.remove(columnIndex);
                }
            }
        }else{
            List<Integer> zaBrisanje = new ArrayList<>();
            for (int i = 0; i <this.getHeader().getStavkeDogadjaja().size(); i++) {
                String columnHeader = this.getHeader().getStavkeDogadjaja().get(i);
                if (!columnHeader.equals("Termin") && !columnHeader.equals("Dan") && !columnHeader.equals("Učionica") && !columnHeader.equals("Predmet")) {
                    zaBrisanje.add(i);
                }
            }
            for (int i = zaBrisanje.size() - 1; i >= 0; i--) {
                int columnIndex = zaBrisanje.get(i);
                this.getHeader().getStavkeDogadjaja().remove(columnIndex);
            }
            for (int i = 0; i < this.getDogadjaji().size(); i++) {
                List<String> row = this.getDogadjaji().get(i).getStavkeDogadjaja();
                for (int j = zaBrisanje.size() - 1; j >= 0; j--) {
                    int columnIndex = zaBrisanje.get(j);
                    row.remove(columnIndex);
                }
            }
        }
        //ovo jednostavno mora na ovaj nacin, nema sanse da se koristi obrisiKolonu jer to pravi problem

        this.refresh(this.getDogadjaji());
    }
}

