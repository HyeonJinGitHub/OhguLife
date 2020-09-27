package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodRecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_recommend_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        TextView textView1 = (TextView)findViewById(R.id.text_recommend1);
        TextView textView2 = (TextView)findViewById(R.id.text_recommend2);

        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        ImageView schoolMeal = (ImageView)findViewById(R.id.school_meal);
        ImageView famousRestaurant = (ImageView)findViewById(R.id.famous_restaurant);

        schoolMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodRecommendActivity.this,SchoolMealActivity.class);
                startActivity(intent);
            }
        });
        famousRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodRecommendActivity.this,FamousRestaurantActivity.class);
                startActivity(intent);
            }
        });
    }
}
