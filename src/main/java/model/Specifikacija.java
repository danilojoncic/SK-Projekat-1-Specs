package model;

import model.boljeRijesenje.Raspored;

import java.util.Scanner;

/**
 * klasa Specifiakcija predstavlja interfejs preko kojeg se mogu izvrsavati metode iz implementacija
 * primarna svhra ovog interfejsa jeste rad nad genericnim rasporedima i hardkodovanim implementacijama
 */
public interface Specifikacija {
    Scanner sc = new Scanner(System.in);


    /**
     * metoda stampaj stampa sadrzaj rasporeda
     * @params nista
     */
    void stampaj();

    /**
     * exportujRaspored ekspotuje raspored u tipa koji korisnik odluci preko stringa tip
     * @param filename moze biti koje god
     * @param type moze biti json,pdf,csv
     */
    void exportujRaspored(String filename,String type);

    /**
     * radi pretragu po rasporedu sa vratiFiltrirano metodom kojom provjerava sample koji je vracen
     * @param uslovPretrage string po kome se poziva metoda vratiFiltrirano
     */
    void pretraziRaspred(String uslovPretrage);
    /**
     * sacuvajRaspored vrsi metodu refresh nad bilo koji novonastalim promijenama nad rasporedom
     * fakticki restrukturira ga sve sa listama i hashMapama
     */
    void sacuvajRaspored();

    /**
     * Ucitava fajl i pravi Raspored objekat i u njemu stavlja sve podatke
     * @param filename ime fajla koji otvaramo i citamo
     * @return vraca instancu Rasporeda koja je napravljena na osnovu ucitanog fajla
     */
    Raspored ucitajRaspored(String filename);


}
