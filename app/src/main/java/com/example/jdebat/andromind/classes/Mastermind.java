package com.example.jdebat.andromind.classes;

/**
 * Created by mathieu on 22/01/2015.
 */
public class Mastermind {

    private int nbCoupPossible = 10;
    private static String[] codeGagnant = new String[4];

    private boolean isBlanc;
    private boolean isBlue;
    private boolean isFushia;
    private boolean isJaune;
    private boolean isOrange;
    private boolean isRouge;
    private boolean isVert;
    private boolean isViolet;

    public Mastermind() {
        for(int i = 0; i <4; i++) {
            codeGagnant[i] = ColorEnum.randomColor().toString();
        }
        isBlanc = false;
        isBlue = false;
        isFushia = false;
        isJaune = false;
        isOrange = false;
        isRouge = false;
        isVert = false;
        isViolet = false;
    }

    public int piontPrésent (String[] couleursJouées) {
        int res = 0;

        for(int i = 0; i <4; i++) {
            ColorEnum test = ColorEnum.valueOf(couleursJouées[i]);
            switch(test) {
                case BLANC :
                    traitementNbBonneCouleur(res,isBlanc);
                    break;
                case BLUE:
                    traitementNbBonneCouleur(res,isBlue);
                    break;
                case FUSHIA:
                    traitementNbBonneCouleur(res,isFushia);
                    break;
                case JAUNE:
                    traitementNbBonneCouleur(res,isJaune);
                    break;
                case ORANGE:
                    traitementNbBonneCouleur(res,isOrange);
                    break;
                case ROUGE:
                    traitementNbBonneCouleur(res,isRouge);
                    break;
                case VERT:
                    traitementNbBonneCouleur(res,isVert);
                    break;
                case VIOLET:
                    traitementNbBonneCouleur(res,isViolet);
                    break;
                default:
            }
        }


        return res;
    }

    public void traitementNbBonneCouleur(int resultat, boolean aTester) {
        if(!aTester) {
            resultat ++;
            aTester = true;
        } else {
            aTester = false;
        }
    }

}
