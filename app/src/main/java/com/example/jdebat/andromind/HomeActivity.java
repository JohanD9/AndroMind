package com.example.jdebat.andromind;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


public class HomeActivity extends ActionBarActivity {

    private ImageButton mImageButtonPlay;
    private EditText mLogin;
    private String login;
    private AlertDialog.Builder mAlertDialog;

    private static final String LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Récupération des infos et setEvents
        mImageButtonPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        mLogin = (EditText) findViewById(R.id.editTextLogin);

        // Mise en place du message d'alerte en cas d'erreur dans la connexion
        mAlertDialog = new AlertDialog.Builder(this);
        mAlertDialog.setTitle("Erreur");
        mAlertDialog.setIcon(R.drawable.ic_menu_android);
        mAlertDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );

        mImageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = mLogin.getText().toString();
                mAlertDialog.setMessage("Votre nom d'utilisateur doit comporter au minimum 4 charactères");
                if (login.length() < 4 || login.isEmpty()) {
                    mAlertDialog.show();
                } else {
                    Intent i = new Intent(getBaseContext(), GameLauncherActivity.class);
                    i.putExtra(LOGIN, login);
                    startActivity(i);
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
