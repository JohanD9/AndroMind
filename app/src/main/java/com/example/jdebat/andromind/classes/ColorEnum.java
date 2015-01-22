package com.example.jdebat.andromind.classes;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ColorEnum {
    ROUGE ("0xFF0000"),
    BLUE("0x0000FF"),
    JAUNE("0xFFFF00"),
    VERT("0x008000"),
    ORANGE("0xFFA500"),
    BLANC("0xFFFFFF"),
    VIOLET("0xD02090"),
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

    public static ColorEnum getColorEnum(String value) {
        switch (value){
            case "0xFF0000" : return ROUGE;
            case "0x0000FF" : return BLUE;
            case "0xFFFF00" : return JAUNE;
            case "0x008000" : return VERT;
            case "0xFFA500" : return ORANGE;
            case "0xFFFFFF" : return BLANC;
            case "0xD02090" : return VIOLET;
            case "0xFF00FF" : return FUSHIA;
            default: return null;
        }
    }
}
