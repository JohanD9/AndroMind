package com.example.jdebat.andromind.classes;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ColorEnum {
    ROUGE (0xFFFF0000),
    BLUE(0xFF0000FF),
    JAUNE(0xFFFFFF00),
    VERT(0xFF008000),
    ORANGE(0xFFFFA500),
    BLANC(0xFFFFFFFF),
    VIOLET(0xFFD02090),
    FUSHIA(0xFFFF00FF);

    private int name;

    //Constructeur
    ColorEnum(int name){
        this.name = name;
    }

    public int getValue(){
        return name;
    }

    private static final List<ColorEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static ColorEnum randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static ColorEnum getColorEnum(int value) {
        switch (value){
            case 0xFFFF0000 : return ROUGE;
            case 0xFF0000FF : return BLUE;
            case 0xFFFFFF00 : return JAUNE;
            case 0xFF008000 : return VERT;
            case 0xFFFFA500 : return ORANGE;
            case 0xFFFFFFFF : return BLANC;
            case 0xFFD02090 : return VIOLET;
            case 0xFFFF00FF : return FUSHIA;
            default: return null;
        }
    }
}
