package com.example.mobileteamproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class SaveActivity extends AppCompatActivity {
    String gettitle;
    TextView title,text;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        Intent intent=getIntent();
        gettitle=intent.getStringExtra("TITLE");
        Toast.makeText(getApplicationContext(),gettitle+"",Toast.LENGTH_LONG).show();
        text=findViewById(R.id.note);
        title=findViewById(R.id.title);
        editText=findViewById(R.id.e_search);
        Button button=findViewById(R.id.search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis=openFileInput(editText.getText().toString());
                    Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();
                    byte[] buffer=new byte[fis.available()];
                    fis.read(buffer);
                    title.setText(gettitle);
                    text.setText(new String(buffer));
                    fis.close();
                }catch (IOException e){
                    Toast.makeText(getApplicationContext(),editText.getText().toString()+"는 존재하지 않습니다!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
