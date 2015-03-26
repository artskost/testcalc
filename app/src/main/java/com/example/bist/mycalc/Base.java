package com.example.bist.mycalc;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.EnumMap;
import java.util.Objects;


public class Base extends ActionBarActivity {

    private EditText textForResult;

    private Button btnAdd;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnSubstract;

    private OperationType operationType;

    private EnumMap<Symbol, Object> actionCommands = new EnumMap<Symbol, Object>(Symbol.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



    textForResult = (EditText) findViewById(R.id.textForResult);

    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnDivide = (Button) findViewById(R.id.btnDivide);
    btnMultiply = (Button) findViewById(R.id.btnMulti);
    btnSubstract = (Button) findViewById(R.id.btnSubstract);

    btnAdd.setTag(OperationType.ADD);
    btnDivide.setTag(OperationType.DIVIDE);
    btnMultiply.setTag(OperationType.MULTIPLY);
    btnSubstract.setTag(OperationType.SUBSTRACT);

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


    public void buttonClick(View v) {

        switch (v.getId()){
            case R.id.btnAdd :
            case R.id.btnDivide :
            case R.id.btnSubstract  :
            case R.id.btneQually :
            case R.id.btnClear :
            case R.id.btnDot :
            case R.id.btnMulti : {
                break;
            }


            default : {
                textForResult.setText(textForResult.getText() + v.getContentDescription().toString());
            }


        }


    }
}
