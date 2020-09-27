package com.example.mobileteamproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class PayAloneInputActivity extends AppCompatActivity {
    EditText[] payInputEdit;
    LinearLayout[] payInputLinearLayout;
    Integer number;
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_alone_input_layout);

        button1 = (Button)findViewById(R.id.pay_alone_input_back_button);
        button2 = (Button)findViewById(R.id.pay_alone_input_next_button);

        payInputLinearLayout = new LinearLayout[10];
        payInputLinearLayout[0] = (LinearLayout)findViewById(R.id.pay_alone_input_layout1);
        payInputLinearLayout[1] = (LinearLayout)findViewById(R.id.pay_alone_input_layout2);
        payInputLinearLayout[2] = (LinearLayout)findViewById(R.id.pay_alone_input_layout3);
        payInputLinearLayout[3] = (LinearLayout)findViewById(R.id.pay_alone_input_layout4);
        payInputLinearLayout[4] = (LinearLayout)findViewById(R.id.pay_alone_input_layout5);
        payInputLinearLayout[5] = (LinearLayout)findViewById(R.id.pay_alone_input_layout6);
        payInputLinearLayout[6] = (LinearLayout)findViewById(R.id.pay_alone_input_layout7);
        payInputLinearLayout[7] = (LinearLayout)findViewById(R.id.pay_alone_input_layout8);
        payInputLinearLayout[8] = (LinearLayout)findViewById(R.id.pay_alone_input_layout9);
        payInputLinearLayout[9] = (LinearLayout)findViewById(R.id.pay_alone_input_layout10);

        payInputEdit = new EditText[10];
        payInputEdit[0] = (EditText)findViewById(R.id.pay_alone_input_name_edit1);
        payInputEdit[1] = (EditText)findViewById(R.id.pay_alone_input_name_edit2);
        payInputEdit[2] = (EditText)findViewById(R.id.pay_alone_input_name_edit3);
        payInputEdit[3] = (EditText)findViewById(R.id.pay_alone_input_name_edit4);
        payInputEdit[4] = (EditText)findViewById(R.id.pay_alone_input_name_edit5);
        payInputEdit[5] = (EditText)findViewById(R.id.pay_alone_input_name_edit6);
        payInputEdit[6] = (EditText)findViewById(R.id.pay_alone_input_name_edit7);
        payInputEdit[7] = (EditText)findViewById(R.id.pay_alone_input_name_edit8);
        payInputEdit[8] = (EditText)findViewById(R.id.pay_alone_input_name_edit9);
        payInputEdit[9] = (EditText)findViewById(R.id.pay_alone_input_name_edit10);

        Spinner spinner = (Spinner)findViewById(R.id.pay_alone_number_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.pay_alone_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("10명"))
                    number = Integer.parseInt(parent.getItemAtPosition(position).toString().substring(0,2));
                else
                    number = Integer.parseInt(parent.getItemAtPosition(position).toString().substring(0,1));
                for(int i=0;i<10;i++)
                {
                    payInputLinearLayout[i].setVisibility(View.INVISIBLE);
                }
                    for(int i=0;i<number;i++)
                    {
                        payInputEdit[i].setText("");
                        payInputLinearLayout[i].setVisibility(View.VISIBLE);
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PayAloneInputActivity.this,PayAloneResultActivity.class);
                intent.putExtra("NUMBER",number);
                for(int i=0; i<number; i++){
                    String name = payInputEdit[i].getText().toString();
                    if(name.getBytes().length <= 0) {
                        Toast.makeText(view.getContext(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    intent.putExtra("NAME"+i,name);
                }

                    startActivity(intent);
            }
        });
    }
}
