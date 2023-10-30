package model.boljeRijesenje;

import java.util.List;

public class Dogadjaj {
    List<String> stavkeDogadjaja; // kolone jednog reda

    public Dogadjaj(List<String> stavkeDogadjaja) {
        this.stavkeDogadjaja = stavkeDogadjaja;
    }

    public List<String> getStavkeDogadjaja() {
        return stavkeDogadjaja;
    }

    public void setStavkeDogadjaja(List<String> stavkeDogadjaja) {
        this.stavkeDogadjaja = stavkeDogadjaja;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stavkeDogadjaja) {
            stringBuilder.append("\""+ s +"\"");
        }
        return stringBuilder.toString();
    }
}
