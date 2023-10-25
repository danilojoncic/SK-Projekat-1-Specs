package org.example;

import model.Raspored;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> vremena = new ArrayList<>();
        String s;
        for (int i = 9; i <= 21; i++) {
            if (i < 10) {
                s = "0"+i+":00h";
            } else
                s = i + ":00h";
            vremena.add(s);
        }

        for (String s1 : vremena) {
            System.out.println(s1);

        }
    }





}