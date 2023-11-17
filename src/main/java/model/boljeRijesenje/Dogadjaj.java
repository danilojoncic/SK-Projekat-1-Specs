package model.boljeRijesenje;

import java.util.List;

public class Dogadjaj {
    /**
     * Dogadjaj nam predstavlja jedno desavanje u rasporedu i mozemo ga zamisliti kao jedan
     * red rasporeda. Stavke dogadjaja su svi unosi u kolonama za taj red (npr. ucionica, dan, termin, profesor)
     *
     * */
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

    public boolean isClone(Dogadjaj clone){
        for(int i = 0; i < this.getStavkeDogadjaja().size();i++){
            if(!this.getStavkeDogadjaja().get(i).equals(clone.getStavkeDogadjaja().get(i))){
                return false;
            }
        }
        return true;
    }








}
