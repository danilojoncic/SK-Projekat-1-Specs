package model.raspored;

import model.Dogadjaj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Raspored {

    List<Dogadjaj> dogadjaji = new ArrayList<>();
    HashSet<String> profesori = new HashSet<>();
    HashSet<String> grupe = new HashSet<>();
    HashSet<String> ucionice = new HashSet<>();
    HashSet<String> vreme = new HashSet<>();

    HashSet<String> predmeti = new HashSet<>();

    public HashSet<String> getPredmeti() {
        return predmeti;
    }

    public List<Dogadjaj> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaj> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    public HashSet<String> getProfesori() {
        return profesori;
    }

    public void setProfesori(HashSet<String> profesori) {
        this.profesori = profesori;
    }

    public HashSet<String> getGrupe() {
        return grupe;
    }

    public void setGrupe(HashSet<String> grupe) {
        this.grupe = grupe;
    }

    public HashSet<String> getUcionice() {
        return ucionice;
    }

    public void setUcionice(HashSet<String> ucionice) {
        this.ucionice = ucionice;
    }

    public HashSet<String> getVreme() {
        return vreme;
    }

    public void setVreme(HashSet<String> vreme) {
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dogadjaj dogadjaj : dogadjaji) {
            sb.append(dogadjaj);
            sb.append("\n");

        }
        return sb.toString();
    }
}
