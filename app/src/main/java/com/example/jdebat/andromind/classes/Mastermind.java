package com.example.jdebat.andromind.classes;

/**
 * Created by mathieu on 22/01/2015.
 */
public class Mastermind {

    private int nbCoupPossible = 10;

    private static String[] codeGagnant;

    public Mastermind(String[] codeGagnant) {

        this.codeGagnant= codeGagnant;
    }

    public int nombrePiontMalPlace (String[] codeTest) {
        int res = 0;

        String[] str = codeGagnant;

        for(int i = 0; i <4; i++) {
            ColorEnum test = ColorEnum.getColorEnum(codeTest[i]);
            switch(test) {
                case BLANC :
                    traitementNbBonneCouleur(str, ColorEnum.BLANC, res);
                    break;
                case BLUE:
                    traitementNbBonneCouleur(str, ColorEnum.BLUE, res);
                    break;
                case FUSHIA:
                    traitementNbBonneCouleur(str,ColorEnum.FUSHIA, res);
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

    public void traitementNbBonneCouleur(String[] code, ColorEnum aTester, int res) {

        for(int i=0; i<code.length;i++) {
            if(code[i].compareTo(aTester.toString()) == 0) {
                res ++;
                code[i] = "-1";
                i = code.length;
            }
        }

    }

    public int nombrePiontBienPlace (String[] codeTest){
        int res = 0;

        for(int i =0; i<4;i++) {
            if(codeGagnant[i].compareTo(codeTest[i]) == 0) {
                res ++;
            }
        }
        return res;
    }
}
