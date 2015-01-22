package com.example.jdebat.andromind.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by jdebat on 22/01/15.
 */
public class Game implements Parcelable {

    private String serverPlayer;
    private ArrayList<String> clientsPlayer;

    private int nbJoueurs;

    private String codeGagnant[] = new String[4];


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
