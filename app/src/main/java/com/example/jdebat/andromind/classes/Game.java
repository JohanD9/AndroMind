package com.example.jdebat.andromind.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jdebat on 22/01/15.
 */
public class Game implements Parcelable {

    private String serverPlayer;
    private String clientsPlayer[] = new String[100];

    private int nbJoueurs;
    private boolean bluetoothGame;

    private String codeGagnant[] = new String[4];

    public Game(int nbJoueurs, boolean bluetoothGame) {
        this.nbJoueurs = nbJoueurs;
        this.bluetoothGame = bluetoothGame;
    }

    public void setServerPlayer(String serverPlayer) {
        this.serverPlayer = serverPlayer;
    }


    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public void setCodeGagnant(String value1, String value2, String value3, String value4) {
        this.codeGagnant[0] = value1;
        this.codeGagnant[1] = value2;
        this.codeGagnant[2] = value3;
        this.codeGagnant[3] = value4;
    }

    public void setBluetoothGame(boolean bluetoothGame) {
        this.bluetoothGame = bluetoothGame;
    }

    public String getServerPlayer() {

        return serverPlayer;
    }

    public void setClientsPlayer(String[] clientsPlayer) {
        this.clientsPlayer = clientsPlayer;
    }

    public String[] getClientsPlayer() {

        return clientsPlayer;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public boolean isBluetoothGame() {
        return bluetoothGame;
    }

    public String[] getCodeGagnant() {
        return codeGagnant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(serverPlayer);
        dest.writeString(String.valueOf(nbJoueurs));
        dest.writeString(String.valueOf(bluetoothGame));
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public Game(Parcel in) {
        this.serverPlayer = in.readString();
        this.nbJoueurs = Integer.parseInt(in.readString());
        this.bluetoothGame = Boolean.parseBoolean(in.readString());
    }
}
