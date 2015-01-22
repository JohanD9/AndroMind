package com.example.jdebat.andromind.classes;

import android.util.Log;

/**
 * Created by mathieu on 22/01/2015.
 */
public class Mastermind {

    private int nbCoupPossible = 10;

    private static int[] codeGagnant;

    public Mastermind(int[] codeGagnant) {

        this.codeGagnant= codeGagnant;
    }

    public int nombrePiontMalPlace (int[] codeTest) {
        int res = 0;

        int[] str = new int[4];
        for(int i = 0;i<4;i++){
            str[i] = codeGagnant[i];
        }

        for(int i = 0; i <4; i++) {
            ColorEnum test = ColorEnum.getColorEnum(codeTest[i]);
            Log.i("var", String.valueOf(test));
            switch(test) {
                case GRIS:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case BLUE:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case MARRON:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case JAUNE:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case ORANGE:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case ROUGE:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case VERT:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case VIOLET:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                default:
            }
        }
        return res;
    }

    public boolean traitementNbBonneCouleur(int[] code, ColorEnum aTester) {
        for(int i=0; i<code.length;i++) {
            if(code[i] == aTester.getValue()) {
                code[i] = -1;
                return true;
            }
        }
        return false;
    }

    public int nombrePiontBienPlace (int[] codeTest){
        int res = 0;

        for(int i =0; i<4;i++) {
            if(codeGagnant[i] == codeTest[i]) {
                res ++;
            }
        }
        return res;
    }
}