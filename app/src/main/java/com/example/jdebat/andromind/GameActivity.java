package com.example.jdebat.andromind;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
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
    private TableRow mTr0;
    private TableRow mTr1;
    private TableRow mTr2;
    private TableRow mTr3;
    private TableRow mTr4;
    private TableRow mTr5;
    private TableRow mTr6;
    private TableRow mTr7;
    private TableRow mTr8;
    private TableRow mTr9;

    private int nbEssai = 10;
    private int nbCaseRemplie = 0;

    private TableLayout mTableJeu;

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
        mTableColor.getChildAt(0).setBackgroundColor(ColorEnum.ROUGE.getValue());
        mTableColor.getChildAt(1).setBackgroundColor(ColorEnum.BLUE.getValue());
        mTableColor.getChildAt(2).setBackgroundColor(ColorEnum.JAUNE.getValue());
        mTableColor.getChildAt(3).setBackgroundColor(ColorEnum.VERT.getValue());
        mTableColor.getChildAt(4).setBackgroundColor(ColorEnum.ORANGE.getValue());
        mTableColor.getChildAt(5).setBackgroundColor(ColorEnum.GRIS.getValue());
        mTableColor.getChildAt(6).setBackgroundColor(ColorEnum.VIOLET.getValue());
        mTableColor.getChildAt(7).setBackgroundColor(ColorEnum.MARRON.getValue());

        mTableColor.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.ROUGE.getValue());
            }
        });

        mTableColor.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.BLUE.getValue());
            }
        });

        mTableColor.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.JAUNE.getValue());
            }
        });

        mTableColor.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.VERT.getValue());
            }
        });

        mTableColor.getChildAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.ORANGE.getValue());
            }
        });

        mTableColor.getChildAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.GRIS.getValue());
            }
        });

        mTableColor.getChildAt(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.VIOLET.getValue());
            }
        });

        mTableColor.getChildAt(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCouleurToCurrentRow(ColorEnum.MARRON.getValue());
            }
        });

        mTableJeu = (TableLayout) findViewById(R.id.tableLayout_jeu);
        mTr0 = (TableRow) mTableJeu.getChildAt(0);
        mTr1 = (TableRow) mTableJeu.getChildAt(1);
        mTr2 = (TableRow) mTableJeu.getChildAt(2);
        mTr3 = (TableRow) mTableJeu.getChildAt(3);
        mTr4 = (TableRow) mTableJeu.getChildAt(4);
        mTr5 = (TableRow) mTableJeu.getChildAt(5);
        mTr6 = (TableRow) mTableJeu.getChildAt(6);
        mTr7 = (TableRow) mTableJeu.getChildAt(7);
        mTr8 = (TableRow) mTableJeu.getChildAt(8);
        mTr9 = (TableRow) mTableJeu.getChildAt(9);

        mTableJeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    public void setCouleurToCurrentRow(int color) {
        if (nbEssai > 0) {
            if (nbCaseRemplie < 4) {
                TableRow row = (TableRow) mTableJeu.getChildAt(nbEssai-1);
                row.getChildAt(nbCaseRemplie).setBackgroundColor(color);
                nbCaseRemplie++;
            } else {
                nbEssai--;
                nbCaseRemplie = 0;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_game, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exit_game_menu, menu);
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

        switch (item.getItemId()) {
            case R.id.exit_game:
                System.exit(RESULT_OK);
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
