package com.example.bist.mycalc;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Base extends ActionBarActivity  implements View.OnClickListener{
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonPlus;

    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonMinus;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonMulti;

    Button buttonZero;
    Button buttonClear;
    Button buttonEqually;
    Button buttonDivision;

    TextView textViewForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);

        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);

        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);

        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEqually = (Button) findViewById(R.id.buttonEqually);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);

        textViewForResult = (TextView) findViewById(R.id.textViewForResult);

        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);

        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);

        buttonZero.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
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

    @Override
    public void onClick(View v) {

        double firstNumber;
        double secondNumber;
        double result;

        firstNumber = Double.parseDouble(textViewForResult.getText().toString());
        secondNumber = Double.parseDouble(textViewForResult.getText().toString());

        if (TextUtils.isEmpty(textViewForResult.getText().toString())){
            return;
        }

        switch(v.getId()) {
            case R.id.buttonSeven :

        }



    }
}
