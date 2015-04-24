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
    btnMultiply = (Button) findViewById(R.id.btnMultyply);
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

    private ActionType lastAction;

    public void buttonClick(View v) {

        switch (v.getId()){
            case R.id.btnAdd :
            case R.id.btnDivide :
            case R.id.btnSubstract  :
            case R.id.btnMultyply : {

                operationType = (OperationType) v.getTag();

                if (!actionCommands.containsKey(Symbol.OPERATION)) {

                    if (!actionCommands.containsKey(Symbol.FIRST_NUMBER)) {
                        actionCommands.put(Symbol.FIRST_NUMBER, textForResult.getText());
                    }

                    actionCommands.put(Symbol.OPERATION, operationType);
                } else if (!actionCommands.containsKey(Symbol.SECOND_NUMBER)) {
                    actionCommands.put(Symbol.SECOND_NUMBER, textForResult.getText());
                    doAction();
                    actionCommands.put(Symbol.OPERATION, operationType);
                    actionCommands.remove(Symbol.SECOND_NUMBER);
                }
                break;
            }
            //удаление всего
            case R.id.btnClear : {
                textForResult.setText("0");
                actionCommands.clear();
                break;
            }
            //результат при нажатии равно
            case R.id.btnQually : {
                if (actionCommands.containsKey(Symbol.FIRST_NUMBER) && actionCommands.containsKey(Symbol.OPERATION)) {
                    actionCommands.put(Symbol.SECOND_NUMBER, textForResult.getText());
                    doAction();

                    actionCommands.put(Symbol.OPERATION, operationType);
                    actionCommands.remove(Symbol.SECOND_NUMBER);
                }
                break;
            }
            //точка
            case R.id.btnDot : {
                if (actionCommands.containsKey(Symbol.FIRST_NUMBER)
                    && getDouble(textForResult.getText().toString()) == getDouble(actionCommands
                        .get(Symbol.FIRST_NUMBER).toString())) {
                    textForResult.setText("0" + v.getContentDescription().toString());
                }

                if (!textForResult.getText().toString().contains(",")) {
                    textForResult.setText(textForResult.getText() + ",");
                }
                break;
            }

            //удаление последнего символа
            case R.id.btnDelete : {
                textForResult.setText(textForResult.getText().delete(
                        textForResult.getText().length() - 1,
                        textForResult.getText().length()));

                if (textForResult.getText().toString().trim().length() == 0) {
                    textForResult.setText("0");
                }
                break;
            }

            default : {

                if (textForResult.getText().toString().equals("0") || (actionCommands.containsKey(Symbol.FIRST_NUMBER)
                        && getDouble(textForResult.getText()) == getDouble(actionCommands.get(Symbol.FIRST_NUMBER)))) {
                        textForResult.setText(v.getContentDescription().toString());
                } else {
                    textForResult.setText(textForResult.getText() + v.getContentDescription().toString());
                }
            }
        }
    }

    private double getDouble (Object value) {
        double result = 0;

        try {
            result = Double.valueOf(value.toString().replace(',', '.')).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }

        return result;
    }


    private void doAction () {
        OperationType operationTypeDoAction = (OperationType) actionCommands.get(Symbol.OPERATION);


        double result = doDoubleAction(operationTypeDoAction, getDouble(actionCommands.get(Symbol.FIRST_NUMBER)),
               getDouble(actionCommands.get(Symbol.SECOND_NUMBER)));


        if (result % 1 == 0) {
            textForResult.setText(String.valueOf((int)result));
        } else {
            textForResult.setText(String.valueOf(result));
        }

        actionCommands.put(Symbol.FIRST_NUMBER, result);
    }


    private Double doDoubleAction (OperationType operationType, double a, double b) {

        switch (operationType) {
            case ADD : {
                return CalcOperations.add(a, b);
            }

            case DIVIDE : {
                return CalcOperations.divide(a, b);
            }

            case MULTIPLY : {
                return CalcOperations.multiply(a, b);
            }

            case SUBSTRACT : {
                return CalcOperations.substract(a, b);
            }
        }
        return null;
    }

}
