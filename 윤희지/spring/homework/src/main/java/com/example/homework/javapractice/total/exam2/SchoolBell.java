package com.example.homework.javapractice.total.exam2;

import java.util.ArrayList;
import java.util.List;

public class SchoolBell {

    public static void main(String[] args) {
        String g = Scale.G.getValue();
        String a = Scale.A.getValue();
        String e = Scale.E.getValue();

        List<String> schoolBell = new ArrayList<>();

        schoolBell.add(g);
        schoolBell.add(g);
        schoolBell.add(a);
        schoolBell.add(a);
        schoolBell.add(g);
        schoolBell.add(g);
        schoolBell.add(e);

        System.out.println(schoolBell);
    }
}
