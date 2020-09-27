package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DutchPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dutch_pay_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");

        TextView textView1 = (TextView)findViewById(R.id.dutch_text1);
        TextView textView2 = (TextView)findViewById(R.id.dutch_text2);
        TextView textView3 = (TextView)findViewById(R.id.dutch_text);
        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        textView3.setTypeface(myFont);
        ImageView imageView1 = (ImageView)findViewById(R.id.pay_alone);
        ImageView imageView2 = (ImageView)findViewById(R.id.pay_all);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DutchPayActivity.this,PayAloneActivity.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DutchPayActivity.this,PayAllActivity.class);
                startActivity(intent);
            }
        });
    }
}
