package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SchoolMealResultActivity extends AppCompatActivity {
    String selectMealName;
    String selectMealRestaurant;
    String selectMealPrice;
    Button button;
    TextView restaurant_name, food_name, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_meal_result_layout);
        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        Intent intent = getIntent();

        selectMealName = intent.getStringExtra("selectedMealName");
        selectMealRestaurant = intent.getStringExtra("selectedMealRestaurant");
        selectMealPrice = intent.getStringExtra("selectedMealPrice");

        restaurant_name = (TextView)findViewById(R.id.food_result_restaurant_name_text);
        food_name = (TextView)findViewById(R.id.food_result_food_name_text);
        price = (TextView)findViewById(R.id.food_result_price_text);
        button = (Button)findViewById(R.id.food_result_back_button);

        restaurant_name.setTypeface(myFont);
        food_name.setTypeface(myFont);
        price.setTypeface(myFont);

        restaurant_name.setText(selectMealRestaurant);
        food_name.setText(selectMealName);
        price.setText(selectMealPrice+"원");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
