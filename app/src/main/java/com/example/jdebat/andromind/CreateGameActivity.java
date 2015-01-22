package com.example.jdebat.andromind;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jdebat.andromind.classes.ServerThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class CreateGameActivity extends ActionBarActivity {

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothServerSocket bss;
    private String nom = "AndroMind";
    private int nbJoueur;

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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(resultCode);
        if (resultCode == -1) {
            //activVisibility();
        }

        if (resultCode == 3600) {
            Button b = (Button) findViewById(R.id.button2);
            b.setClickable(true);
        }
    }

    public void lancer (View view) {
        EditText e = (EditText) findViewById(R.id.editText);
        nbJoueur = Integer.parseInt(e.getText().toString());

        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(this);
        mAlertDialog.setTitle("Connexion ..");
        mAlertDialog.setIcon(R.drawable.ic_menu_android);
        mAlertDialog.setMessage("Attente des autres joueurs");
        mAlertDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ServerThread st = new ServerThread(nbJoueur-1);
                        st.run();
                    }
                }
        );
        mAlertDialog.show();
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
