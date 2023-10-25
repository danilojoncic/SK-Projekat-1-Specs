package model;

import java.util.Date;

public class VremeVazenja {

    private Date vaziOd;
    private Date vaziDo;

    public VremeVazenja(Date vaziOd, Date vaziDo) {
        this.vaziOd = vaziOd;
        this.vaziDo = vaziDo;
    }

    public Date getVaziOd() {
        return vaziOd;
    }

    public void setVaziOd(Date vaziOd) {
        this.vaziOd = vaziOd;
    }

    public Date getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(Date vaziDo) {
        this.vaziDo = vaziDo;
    }

    @Override
    public String toString() {
        return "Ovaj raspored vazi od " + vaziOd + " do " + vaziDo;
    }
}
