package com.example.jdebat.andromind.classes;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ColorEnum {
    ROUGE ("#FF0000"),
    BLUE("#0000FF"),
    JAUNE("#FFFF00"),
    VERT("#008000"),
    ORANGE("#FFA500"),
    BLANC("#FFFFFF"),
    VIOLET("#D02090"),
    FUSHIA("0xFF00FF");

    private String name = "";

    //Constructeur
    ColorEnum(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    private static final List<ColorEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static ColorEnum randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
