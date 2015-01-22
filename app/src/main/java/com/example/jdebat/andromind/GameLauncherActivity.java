package com.example.jdebat.andromind;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jdebat.andromind.classes.ColorEnum;
import com.example.jdebat.andromind.classes.Game;


public class GameLauncherActivity extends ActionBarActivity {

    private TextView mLogin;
    private Button mButtonPlaySolo;
    private Button mbuttonJoinGame;
    private Button mbuttonCreateGame;

    private String login;

    private Game myGame;
    private String codeGagnant[] = new String[4];

    private static final String LOGIN = "login";
    private static final String CLIENTS = "clients";
    private static final String REPONSE = "reponse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_launcher);

        // Récupération des infos
        Intent homeActivity = getIntent();
        login = homeActivity.getExtras().getString(LOGIN);

        mLogin = (TextView) findViewById(R.id.textViewLogin);
        mButtonPlaySolo = (Button) findViewById(R.id.buttonPlaySolo);
        mbuttonJoinGame = (Button) findViewById(R.id.buttonJoinGame);
        mbuttonCreateGame = (Button) findViewById(R.id.buttonCreateGame);

        mLogin.setText("Votre nom : " + login);

        // Ajout des listeners
        mButtonPlaySolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myGame = new Game(1, false);

                myGame.setCodeGagnant(ColorEnum.randomColor().toString(), ColorEnum.randomColor().toString(), ColorEnum.randomColor().toString(), ColorEnum.randomColor().toString());
                Intent i = new Intent(getBaseContext(), GameActivity.class);
                i.putExtra(LOGIN, login);
                startActivity(i);
            }
        });

        mbuttonJoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SelectDeviceToConnectActivity.class);
                i.putExtra(LOGIN, login);
                startActivity(i);
            }
        });

        mbuttonCreateGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CreateGameActivity.class);
                i.putExtra(LOGIN, login);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_game_launcher, menu);
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
