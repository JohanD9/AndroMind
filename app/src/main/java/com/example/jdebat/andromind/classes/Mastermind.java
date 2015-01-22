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
                case BLANC :
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case BLUE:
                    if(traitementNbBonneCouleur(str, test))
                        res ++;
                    break;
                case FUSHIA:
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
            System.out.println("On entre dans la boucle");
            if(code[i] == aTester.getValue()) {
                System.out.println("On est dans le if");
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
