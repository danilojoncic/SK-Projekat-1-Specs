package model.builderPattern;

import model.raspored.Raspored;

public class ConcreteBuilder extends Builder{
    Raspored raspored;
    public Raspored getRaspored(){
       raspored = this.reset();
       return raspored;
    }
}
