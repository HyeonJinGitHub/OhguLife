package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayAloneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_alone_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");

        TextView textView1 = (TextView)findViewById(R.id.pay_alone_text1);
        TextView textView2 = (TextView)findViewById(R.id.pay_alone_text2);
        TextView textView3 = (TextView)findViewById(R.id.pay_alone_text3);
        TextView textView4 = (TextView)findViewById(R.id.pay_alone_text4);
        TextView textView5 = (TextView)findViewById(R.id.pay_alone_text5);
        TextView textView6 = (TextView)findViewById(R.id.pay_alone_text6);


        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        textView3.setTypeface(myFont);
        textView4.setTypeface(myFont);
        textView5.setTypeface(myFont);
        textView6.setTypeface(myFont);




        Button button1 = (Button)findViewById(R.id.pay_alone_back);
        Button button2 = (Button)findViewById(R.id.pay_alone_next);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(PayAloneActivity.this,PayAloneInputActivity.class);
                    startActivity(intent);

            }
        });
    }
}
