package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PayAllResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_all_result_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");

        TextView textView1 = (TextView)findViewById(R.id.pay_all_result_text1);
        TextView textView2 = (TextView)findViewById(R.id.pay_all_result_text2);
        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        Button button = (Button)findViewById(R.id.pay_all_result_back_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        textView1.setText(intent.getStringExtra("PRICE") + "원");
    }
}
