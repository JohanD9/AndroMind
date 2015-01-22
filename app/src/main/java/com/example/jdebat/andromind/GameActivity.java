package com.example.jdebat.andromind;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdebat.andromind.classes.ColorEnum;
import com.example.jdebat.andromind.classes.Game;
import com.example.jdebat.andromind.classes.Mastermind;


public class GameActivity extends ActionBarActivity {

    private Context context = this;

    private String login;

    private Game myGame;
    private int codeGagnant[] = new int[4];

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

    private Button mButtonSend;
    private Button mButtonClear;

    private TextView mBp;
    private TextView mMp;

    private int nbEssai = 10;
    private int nbCaseRemplie = 0;

    private TableLayout mTableJeu;

    private Mastermind mastermind;

    int codeTest[] = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle b=this.getIntent().getExtras();
        codeGagnant = b.getIntArray(CODE_GAGNANTS);
        login = b.getString(LOGIN);

        mastermind = new Mastermind(codeGagnant);

        for (int i = 0; i <4; i++)
        {
            Log.i("Game", String.valueOf(codeGagnant[i]));
        }

        mBp = (TextView) findViewById(R.id.textViewBp);
        mMp = (TextView) findViewById(R.id.textViewMp);

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

        mButtonClear = (Button) findViewById(R.id.buttonClearLigne);
        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row = (TableRow) mTableJeu.getChildAt(nbEssai-1);
                row.getChildAt(0).setBackgroundColor(0xFFFFFFFF);
                row.getChildAt(1).setBackgroundColor(0xFFFFFFFF);
                row.getChildAt(2).setBackgroundColor(0xFFFFFFFF);
                row.getChildAt(3).setBackgroundColor(0xFFFFFFFF);
                nbCaseRemplie = 0;
                mButtonSend.setBackgroundColor(0xFF666666);
                mButtonSend.setTextColor(0xFFEEEEEE);
            }
        });

        mButtonSend = (Button) findViewById(R.id.buttonValiderLigne);
        mButtonSend.setBackgroundColor(0xFF666666);
        mButtonSend.setTextColor(0xFFEEEEEE);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nbCaseRemplie < 4 ) {
                    Toast.makeText(context, "Remplissez toutes les cases de la ligne", Toast.LENGTH_LONG).show();
                } else {

                    int bp = mastermind.nombrePiontBienPlace(codeTest);
                    if (bp == 4) {
                        Toast.makeText(context, "WIN", Toast.LENGTH_LONG).show();
                    } else {
                        int mp = mastermind.nombrePiontMalPlace(codeTest);
                        mp = mp - bp;
                        mBp.setText(String.valueOf(bp));
                        mMp.setText(String.valueOf(mp));
                        Log.i("bp", String.valueOf(bp));
                        Log.i("mp", String.valueOf(mp));
                        nbEssai--;
                        nbCaseRemplie = 0;
                    }



                }
                Log.i("test", String.valueOf(nbEssai));
            }
        });
    }


    public void setCouleurToCurrentRow(int color) {
        if (nbEssai > 0) {
            if (nbCaseRemplie < 4) {
                TableRow row = (TableRow) mTableJeu.getChildAt(nbEssai - 1);
                row.getChildAt(nbCaseRemplie).setBackgroundColor(color);
                codeTest[nbCaseRemplie] = color;
                nbCaseRemplie++;
                if (nbCaseRemplie == 4) {
                    mButtonSend.setEnabled(true);
                    mButtonSend.setClickable(true);
                    mButtonSend.setBackgroundColor(0xFFFF8400);
                    mButtonSend.setTextColor(0xFF222222);
                    ;
                }
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
