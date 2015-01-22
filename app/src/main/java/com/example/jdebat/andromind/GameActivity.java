package com.example.jdebat.andromind;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableRow;

import com.example.jdebat.andromind.classes.ColorEnum;
import com.example.jdebat.andromind.classes.Game;


public class GameActivity extends ActionBarActivity {

    private String login;

    private Game myGame;
    private String codeGagnant[] = new String[4];

    private static final String LOGIN = "login";
    private static final String CLIENTS = "clients";
    private static final String REPONSE = "reponse";
    private static final String CODE_GAGNANTS = "reponse";

    private TableRow mTableColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle b=this.getIntent().getExtras();
        codeGagnant = b.getStringArray(CODE_GAGNANTS);
        login = b.getString(LOGIN);

        for (int i = 0; i <4; i++)
        {
            Log.i("Game", codeGagnant[i]);
        }

        mTableColor = (TableRow) findViewById(R.id.tableColor);
        mTableColor.getChildAt(0).setBackgroundColor(Color.BLUE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_game, menu);
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
