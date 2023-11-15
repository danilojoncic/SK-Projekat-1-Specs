package model;

public interface Specifikacija {

    void stampaj();
    void exportujRaspored(String filename,String type);
    void pretraziRaspred(String uslovPretrage);
    void sacuvajRaspored();
    void ucitajRaspored(String filename);

    //da bi refreshovao potrebne su mi liste dogadjaja
    //a ja nazad vracam raspored
}
