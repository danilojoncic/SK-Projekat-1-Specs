package model.boljeRijesenje;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Datumi {

    private static Datumi instance;
    private Map<LocalDate, DayOfWeek> mapaDatumaIDana;

    private Datumi(){
        init();
    }

    private void init(){
            mapaDatumaIDana = new HashMap<>();
            for(int godina = 2023; godina <= 2024; godina++) {
                for(int mesec = 1; mesec <= 12; mesec++) {
                    for(int dan = 1; dan <= LocalDate.of(godina, mesec, 1).lengthOfMonth(); dan++) {
                        LocalDate trenutniDatum = LocalDate.of(godina, mesec, dan);
                        DayOfWeek danUNedelji = trenutniDatum.getDayOfWeek();
                        mapaDatumaIDana.put(trenutniDatum, danUNedelji);
                    }
                }
            }

        }

        public static Datumi getInstance(){
            if(instance == null)
                instance = new Datumi();
            return instance;
        }






}


