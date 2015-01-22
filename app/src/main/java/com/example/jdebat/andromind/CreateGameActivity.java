package com.example.jdebat.andromind;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jdebat.andromind.classes.ServerThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class CreateGameActivity extends ActionBarActivity {

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothServerSocket bss;
    private ArrayList<BluetoothSocket> clients = new ArrayList<BluetoothSocket>();
    private String nom = "AndroMind";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //activBluetooth();
        activVisibility();
    }

    protected void activVisibility () {
        Intent discoverableIntent = new
                Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3600);
        startActivityForResult(discoverableIntent, 3600);
    }

    protected void activBluetooth () {
        int REQUEST_ENABLE_BT = 10;

        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                activVisibility();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(resultCode);
        if (resultCode == -1) {
            //activVisibility();
        }

        if (resultCode == 3600) {
            ServerThread st = new ServerThread(1); // clients.size()
            st.run();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
