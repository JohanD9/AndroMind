package com.example.jdebat.andromind.classes;

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

        int[] str = codeGagnant;

        for(int i = 0; i <4; i++) {
            ColorEnum test = ColorEnum.getColorEnum(codeTest[i]);
            switch(test) {
                case GRIS:
                    traitementNbBonneCouleur(str, ColorEnum.GRIS, res);
                    break;
                case BLUE:
                    traitementNbBonneCouleur(str, ColorEnum.BLUE, res);
                    break;
                case MARRON:
                    traitementNbBonneCouleur(str,ColorEnum.MARRON, res);
                    break;
                case JAUNE:
                    traitementNbBonneCouleur(str, ColorEnum.JAUNE, res);
                    break;
                case ORANGE:
                    traitementNbBonneCouleur(str,ColorEnum.ORANGE, res);
                    break;
                case ROUGE:
                    traitementNbBonneCouleur(str,ColorEnum.ROUGE, res);
                    break;
                case VERT:
                    traitementNbBonneCouleur(str,ColorEnum.VERT, res);
                    break;
                case VIOLET:
                    traitementNbBonneCouleur(str,ColorEnum.VIOLET,res);
                    break;
                default:
            }
        }
        return res;
    }

    public void traitementNbBonneCouleur(int[] code, ColorEnum aTester, int res) {

        for(int i=0; i<code.length;i++) {
            if(code[i] == aTester.getValue()) {
                res ++;
                code[i] = -1;
                i = code.length;
            }
        }

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
