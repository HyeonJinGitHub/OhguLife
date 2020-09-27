package com.example.mobileteamproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


import org.w3c.dom.Text;



public class CalculateActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        editText1.setInputType(InputType.TYPE_NULL);
        editText1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                editText1.setInputType(InputType.TYPE_NULL);
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(editText1.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });
        editText2.setInputType(InputType.TYPE_NULL);
        editText2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                editText2.setInputType(InputType.TYPE_NULL);
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(editText2.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });
        editText3.setInputType(InputType.TYPE_NULL);
        editText3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                editText3.setInputType(InputType.TYPE_NULL);
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(editText3.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });
    }

    public void numberClicked(View v) {
        switch (v.getId()) {
            case R.id.button0:
                if (editText1.hasFocus()) editText1.append("0");
                else editText2.append("0");
                break;
            case R.id.button1:
                if (editText1.hasFocus()) editText1.append("1");
                else editText2.append("1");
                break;
            case R.id.button2:
                if (editText1.hasFocus()) editText1.append("2");
                else editText2.append("2");
                break;
            case R.id.button3:
                if (editText1.hasFocus()) editText1.append("3");
                else editText2.append("3");
                break;
            case R.id.button4:
                if (editText1.hasFocus()) editText1.append("4");
                else editText2.append("4");
                break;
            case R.id.button5:
                if (editText1.hasFocus()) editText1.append("5");
                else editText2.append("5");
                break;
            case R.id.button6:
                if (editText1.hasFocus()) editText1.append("6");
                else editText2.append("6");
                break;
            case R.id.button7:
                if (editText1.hasFocus()) editText1.append("7");
                else editText2.append("7");
                break;
            case R.id.button8:
                if (editText1.hasFocus()) editText1.append("8");
                else editText2.append("8");
                break;
            case R.id.button9:
                if (editText1.hasFocus()) editText1.append("9");
                else editText2.append("9");
                break;

        }

    }

    public void onClicked(View v) {
        int num1;
        int num2;
        int result;
        switch (v.getId()) {
            case R.id.plus:
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());
                result = num1 + num2;
                editText3.setText("" + result);
                break;
            case R.id.minus:
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());
                result = num1 - num2;
                editText3.setText("" + result);
                break;
            case R.id.multiply:
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());
                result = num1 * num2;
                editText3.setText("" + result);
                break;
            case R.id.divide:
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());
                if(num2 == 0)
                {
                    Toast.makeText(getApplicationContext(),"0이 아닌 숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                editText3.setText("" + result);
                break;
            case R.id.modular:
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());
                if(num2 == 0)
                {
                    Toast.makeText(getApplicationContext(),"0이 아닌 숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 % num2;
                editText3.setText("" + result);
                break;
            case R.id.init:
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                break;
        }
    }

}
