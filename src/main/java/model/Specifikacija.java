package model;

import model.boljeRijesenje.Raspored;

public interface Specifikacija {

    void stampaj();
    void exportujRaspored(String filename,String type);
    void pretraziRaspred(String uslovPretrage);
    void sacuvajRaspored();
    Raspored ucitajRaspored(String filename);

    //da bi refreshovao potrebne su mi liste dogadjaja
    //a ja nazad vracam raspored
}
