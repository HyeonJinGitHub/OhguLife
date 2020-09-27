package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.app.Fragment;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Fragment fr;
    ImageView imageView;
    Bitmap bitmap;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //상단 액티비티 이름 없애주는 코드
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.image_main);
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container,new FragmentFood())
                .commit();
        relativeLayout = (RelativeLayout)findViewById(R.id.fragment_container);
        relativeLayout.setVisibility(View.INVISIBLE);
    }
    public void selectFragment(View view) {
        relativeLayout.setVisibility(View.VISIBLE);
        switch (view.getId()) {
            case R.id.foodButton:
                fr = new FragmentFood();
               bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ohgufood);
                imageView.setImageBitmap(bitmap);
                break;
            case R.id.studyButton:
                fr = new FragmentStudy();
               bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ohgustudy);
                imageView.setImageBitmap(bitmap);
                break;
            case R.id.kpuButton:
                fr = new FragmentKpu();
                bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ohguschool);
                imageView.setImageBitmap(bitmap);
                break;
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,fr)
                .commit();
    }

    public void onClickFood(View view)
    {
        switch (view.getId())
        {
            case R.id.foodRandom:
                Intent intent1 = new Intent(MainActivity.this,FoodRandomActivity.class);
                startActivity(intent1);
                break;
            case R.id.foodRecommend:
                Intent intent2 = new Intent(MainActivity.this,FoodRecommendActivity.class);
                startActivity(intent2);
                break;
            case R.id.foodPay:
                Intent intent3 = new Intent(MainActivity.this,DutchPayActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
