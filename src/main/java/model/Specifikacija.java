package model;

public interface Specifikacija {

    void stampaj();
    void kreirajRaspored(String filename,String type);
    void pretraziRaspred();
    void sacuvajRaspored();
    void ucitajRaspored(String filename);

    //da bi refreshovao potrebne su mi liste dogadjaja
    //a ja nazad vracam raspored
}
