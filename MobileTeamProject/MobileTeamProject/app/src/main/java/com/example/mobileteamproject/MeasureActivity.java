package com.example.mobileteamproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MeasureActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    int fromposition=0,toposition=0;
    int selectposition=0;
    int id1=R.array.unit_array1;
    int id2=R.array.unit_array2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);

        button=findViewById(R.id.changeBtn);
        //inputvalue=Integer.parseInt(editText1.getText().toString());

        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter0=ArrayAdapter.createFromResource(MeasureActivity.this,R.array.select_array,android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter0);

        final Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
        final Spinner spinner2=(Spinner)findViewById(R.id.spinner2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectposition=position;
                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext(),"길이",Toast.LENGTH_SHORT).show();
                        id1=R.array.unit_array1;
                        id2=R.array.unit_array2;

                        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MeasureActivity.this,id1,android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner1.setAdapter(adapter);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                fromposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });

                        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(MeasureActivity.this,id2,android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(adapter2);
                        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                toposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"무게",Toast.LENGTH_SHORT).show();
                        id1=R.array.weigth_array1;
                        id2=R.array.weigth_array2;

                        adapter=ArrayAdapter.createFromResource(MeasureActivity.this,id1,android.R.layout.simple_spinner_item);
                        spinner1.setAdapter(adapter);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                fromposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });

                        adapter2=ArrayAdapter.createFromResource(MeasureActivity.this,id2,android.R.layout.simple_spinner_item);
                        spinner2.setAdapter(adapter2);
                        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                toposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"온도",Toast.LENGTH_SHORT).show();
                        id1=R.array.temp_array1;
                        id2=R.array.temp_array2;
                        adapter=ArrayAdapter.createFromResource(MeasureActivity.this,id1,android.R.layout.simple_spinner_item);
                        spinner1.setAdapter(adapter);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                fromposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });

                        adapter2=ArrayAdapter.createFromResource(MeasureActivity.this,id2,android.R.layout.simple_spinner_item);
                        spinner2.setAdapter(adapter2);
                        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                toposition=position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
    public void onClicked(View view) {
        switch (selectposition) {
            case 0: {   //길이로 선택됐을때
                switch (fromposition) {
                    case 0:     //km
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1000));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 100000));
                                break;
                            case 3:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1000000));
                                break;
                        }
                        break;
                    case 1: //m
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.001));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 100));
                                break;
                            case 3:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1000));
                                break;
                        }
                        break;
                    case 2:     //cm
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.00001));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.01));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 3:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 10));
                                break;
                        }
                        break;
                    case 3:     //mm
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.000001));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.001));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 0.1));
                                break;
                            case 3:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                        }
                        break;

                }
            }
            break;
            case 1: { //무게
                switch (fromposition) {
                    case 0:     //KG
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *1000));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *1000000));
                                break;
                        }
                        break;
                    case 1:     //g
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *0.001));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *1000));
                                break;
                        }
                        break;
                    case 2:     //mg
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *0.000001));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) *0.001));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                        }
                        break;
                }
            }
            break;
            case 2: { //온도
                switch (fromposition) {
                    case 0:     //C
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 1:
                                editText2.setText(String.valueOf((Integer.parseInt(editText1.getText().toString()) * 9 / 5) + 32));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) + 273.15));
                                break;
                        }
                        break;
                    case 1:     //F
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf((Integer.parseInt(editText1.getText().toString()) - 32) * 5 / 9));
                                break;
                            case 1:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                            case 2:
                                editText2.setText(String.valueOf((Integer.parseInt(editText1.getText().toString()) - 32) * 5 / 9 + 273.15));
                                break;
                        }
                        break;
                    case 2:     //F
                        switch (toposition) {
                            case 0:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) - 273.15));
                                break;
                            case 1:
                                editText2.setText(String.valueOf((Integer.parseInt(editText1.getText().toString()) - 273.15) * 9 / 5 + 32));
                                break;
                            case 2:
                                editText2.setText(String.valueOf(Integer.parseInt(editText1.getText().toString()) * 1));
                                break;
                        }
                        break;
                }
            }
            break;



        }
    }


}
