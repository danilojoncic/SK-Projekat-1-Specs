//import model.builderPattern.ConcreteBuilder;
//import model.builderPattern.Director;
//import model.raspored.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class TestBuildera {
//
//
//    static Director director;
//
//    @Test
//    public void testirajListuRaspored(){
//        director = new Director(new ConcreteBuilder(),1);
//        Assertions.assertNotNull(director);
//
//        Prostorija prostorija1 = new Prostorija(1,1,new StanjeProstorije(10,true,true));
//        Prostorija prostorija2 = new Prostorija(2,2,new StanjeProstorije(10,true,true));
//        Prostorija prostorija3 = new Prostorija(3,3,new StanjeProstorije(10,true,true));
//        HashSet<Prostorija> prostorijas = new HashSet<>();
//        prostorijas.add(prostorija1);
//        prostorijas.add(prostorija2);
//        prostorijas.add(prostorija3);
//        director.setProstorije(prostorijas);
//        Assertions.assertNotNull(director.getProstorije());
//
//
//        List<Termin> termini = new ArrayList<>();
//        Termin termin1 = new Termin("danas","sutra",24, Dan.SREDA);
//        Termin termin2 = new Termin("12:00","13:00",1, Dan.SREDA);
//        Termin termin3 = new Termin("09:00","13:00",4, Dan.SREDA);
//        termini.add(termin1);
//        termini.add(termin2);
//        termini.add(termin3);
//        director.setTermini(termini);
//        Assertions.assertNotNull(director.getTermini());
//
//
//        Predmet predmet1 = new Predmet("SK","Surla",6);
//        Predmet predmet2 = new Predmet("Skript","Iga",6);
//        Predmet predmet3 = new Predmet("Testiranje","Jefimija",6);
//        HashMap<Termin,Predmet> kolekcija = new HashMap<>();
//        kolekcija.put(termin1,predmet1);
//        kolekcija.put(termin2,predmet2);
//        kolekcija.put(termin3,predmet3);
//        director.setKolekcijaParova(kolekcija);
//        Assertions.assertNotNull(director.getKolekcijaParova());
//
//        Raspored raspored = director.napraviListuRaspored(new ConcreteBuilder());
//        Assertions.assertNotNull(raspored);
//
//        for (Termin termin: raspored.getKolekcijaParova().keySet()) {
//            System.out.println("Termin od " + termin.getVremeOd() + " do " + termin.getVremeDo() + " je "
//                    + raspored.getKolekcijaParova().get(termin).getIme() + " i drzi ga " +
//                    raspored.getKolekcijaParova().get(termin).getProfesor());
//        }
//
//
//        //direktor je nakacen na goi, kada se tekst polja ispune te informacije se salju setterima na direkotova lokalna polja
//        //kada izaberemo koji tip rasporeda zelimo da pravimo mi onda instanciramo sve te objekte za direktora
//        //nakon instanciranja direktor njih salje bilderu koji pravi raspored
//    }
//}
