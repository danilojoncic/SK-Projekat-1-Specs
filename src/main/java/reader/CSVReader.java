package reader;

import model.Dogadjaj;
import model.raspored.Predmet;
import model.raspored.Raspored;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {




    public static void main(String[] args) throws IOException {
        String path = "D:\\Racunarski Fakultet Beograd\\Treca Godina\\5. Semestar\\Softverske komponente\\src\\main\\resources\\csv.csv";
        String line = "";
        List<Dogadjaj> dogadjaji = new ArrayList<>();
        int predmet = -1,nastavnik = -1,tip = -1,grupe = -1,dan = -1,ucionica = -1,termin = -1;
        Raspored raspored = new Raspored();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));

            if((line = bf.readLine()) != null){
                String header[] = line.split("\"");
//                System.out.println("HEADER:");
                for (int i = 0; i < header.length; i++){
                    if(header[i].equalsIgnoreCase("predmet"))
                        predmet = i;
                    if(header[i].equalsIgnoreCase("nastavnik"))
                        nastavnik = i;
                    if(header[i].equalsIgnoreCase("tip"))
                        tip = i;
                    if(header[i].equalsIgnoreCase("grupe"))
                        grupe = i;
                    if(header[i].equalsIgnoreCase("dan"))
                        dan = i;
                    if(header[i].equalsIgnoreCase("učionica"))
                        ucionica= i;
                    if(header[i].equalsIgnoreCase("termin"))
                        termin = i;
                }
            }

            while((line = bf.readLine()) != null) {

                String strings[] = line.split("\"");
                raspored.getProfesori().add(strings[nastavnik]);
                raspored.getGrupe().add(strings[grupe]);
                raspored.getVreme().add(strings[termin]);
                raspored.getUcionice().add(strings[ucionica]);
                raspored.getPredmeti().add(strings[predmet]);
                Dogadjaj d = new Dogadjaj(strings[dan], strings[ucionica], strings[nastavnik],strings[predmet],strings[termin],strings[grupe]);
                raspored.getDogadjaji().add(d);



            }

            for (String premdmet : raspored.getProfesori()) {
                System.out.println(premdmet);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }



    }

}
