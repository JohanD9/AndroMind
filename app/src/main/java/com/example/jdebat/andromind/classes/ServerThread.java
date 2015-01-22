package com.example.jdebat.andromind.classes;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by CLASTRIER on 22/01/2015.
 */

public class ServerThread extends Thread {
    private final BluetoothServerSocket mmServerSocket;
    private int nbJoueur;

    public ServerThread(int nbJoueur) {
        // Use a temporary object that is later assigned to mmServerSocket,
        // because mmServerSocket is final
        this.nbJoueur = nbJoueur;
        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID is the app's UUID string, also used by the client code
            tmp = BluetoothAdapter.getDefaultAdapter().listenUsingRfcommWithServiceRecord("AndroMind", UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
        } catch (IOException e) { }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        int cpt = 0;
        // Keep listening until exception occurs or a socket is returned
        while (cpt != nbJoueur) {
            try {
                System.out.println("WAIT");
                socket = mmServerSocket.accept();
                System.out.println("OK");

            } catch (IOException e) {
                break;
            }
            // If a connection was accepted
            if (socket != null) {
                // Do work to manage the connection (in a separate thread)
                //manageConnectedSocket(socket);
                //mmServerSocket.close();
                //break;
            }
            cpt++;
        }
    }

    /** Will cancel the listening socket, and cause the thread to finish */
    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
}