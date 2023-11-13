package model.boljeRijesenje;

public class Par {
    private String dan;
    private String ucionica;

    public Par(String dan, String ucionica) {
        this.dan = dan;
        this.ucionica = ucionica;
    }


    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getUcionica() {
        return ucionica;
    }

    public void setUcionica(String ucionica) {
        this.ucionica = ucionica;
    }
}
