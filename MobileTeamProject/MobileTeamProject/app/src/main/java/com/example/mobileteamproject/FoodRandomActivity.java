package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodRandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_random_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        TextView textView1 = (TextView)findViewById(R.id.food_random_text1);
        TextView textView2 = (TextView)findViewById(R.id.food_random_text2);

        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);

        Button button = (Button)findViewById(R.id.button_food_random_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodRandomActivity.this,FoodRandomResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
