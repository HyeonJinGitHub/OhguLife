package com.example.mobileteamproject;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Vector;

public class FoodRandomResultActivity extends AppCompatActivity {
    boolean flag = false;
    TextView textView1,textView2,textView3;
    Random random;
    Vector<SchoolFood> selectFood;
    boolean start = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_random_result_layout);


        ImageView imageView = (ImageView)findViewById(R.id.button_random_ok);
        ImageView imageView1 = (ImageView)findViewById(R.id.button_random_restart);
        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");

         textView1 = (TextView)findViewById(R.id.food_random_restaurant_name_text);
         textView2 = (TextView)findViewById(R.id.food_random_food_name_text);
         textView3 = (TextView)findViewById(R.id.food_random_price_text);

        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        textView3.setTypeface(myFont);

        int i=0;

        final SchoolFood[] kpuFoodMenu = new SchoolFood[100];

        for(int j=0; j<100; j++)
            kpuFoodMenu[j] = null;

        kpuFoodMenu[i++] = new SchoolFood("학식", "한식", "밥", "썬푸드", 3800);
        kpuFoodMenu[i++] = new SchoolFood("소고기비빔밥", "한식", "밥", "썬푸드", 5000);
        kpuFoodMenu[i++] = new SchoolFood("안동찜닭", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("두부김치정식", "한식", "밥", "썬푸드", 5000);
        kpuFoodMenu[i++] = new SchoolFood("연탄불고기", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("매콤돈불고기", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("뚝불고기", "한식", "밥", "썬푸드", 5000);
        kpuFoodMenu[i++] = new SchoolFood("부대찌개", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("차돌순두부", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("김치찌개", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("갈비탕", "한식", "밥", "썬푸드", 5000);
        kpuFoodMenu[i++] = new SchoolFood("철판불고기쌈밥", "한식", "밥", "썬푸드", 5000);
        kpuFoodMenu[i++] = new SchoolFood("차돌된장찌개", "한식", "밥", "썬푸드", 4500);
        kpuFoodMenu[i++] = new SchoolFood("소고기미역국\n정식", "한식", "밥", "썬푸드", 4500);

        kpuFoodMenu[i++] = new SchoolFood("신포닭강정덮밥", "양식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("모듬컵밥", "한식", "밥", "우쿠야", 3500);
        kpuFoodMenu[i++] = new SchoolFood("갈릭양파\n돈까스", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("양푼이비빔밥", "한식", "밥", "우쿠야", 4000);
        kpuFoodMenu[i++] = new SchoolFood("부타동", "일식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("해물야끼우동", "일식", "면", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("돈김치짜글이", "한식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("매콤철판돈까스", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("미야자끼치킨까스", "양식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("참치회덮밥", "한식", "밥", "우쿠야", 4000);
        kpuFoodMenu[i++] = new SchoolFood("냉모밀", "일식", "면", "우쿠야", 4000);
        kpuFoodMenu[i++] = new SchoolFood("비빔모밀", "일식", "면", "우쿠야", 4000);
        kpuFoodMenu[i++] = new SchoolFood("돈카츠벤또", "일식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("꼬치어묵우동", "일식", "면", "우쿠야", 4000);
        kpuFoodMenu[i++] = new SchoolFood("다꼬야기\n치킨덮밥", "일식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("돈까스김치나베", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("파채돈까스", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("고구마\n치즈돈까스", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("치즈돈까스", "양식", "밥", "우쿠야", 5000);
        kpuFoodMenu[i++] = new SchoolFood("김치알돌솥밥", "일식", "밥", "우쿠야", 4500);
        kpuFoodMenu[i++] = new SchoolFood("파채돈까스", "양식", "밥", "우쿠야", 5000);

        kpuFoodMenu[i++] = new SchoolFood("양념감자오믈렛", "양식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("갈릭함박\n스테이크\n오믈렛", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("양념치킨\n오믈렛", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("불닭오믈렛", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("소고기필라프", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("돈도리볶음밥", "양식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("소금구이덮밥", "한식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("삼겹살\n강된장비빔밥", "한식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("매콤\n소금구이덮밥", "한식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("초계막국수", "한식", "면", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("초계비빔국수", "한식", "면", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("우삼겹\n숙주덮밥", "일식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("데리야끼\n치킨덮밥", "일식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("고기국수", "한식", "면", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("제육장비빔밥", "한식", "밥", "한스델리", 4000);
        kpuFoodMenu[i++] = new SchoolFood("치즈오븐치킨\n라이스", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("불닭치즈도리아", "양식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("모듬수제비", "한식", "밥", "한스델리", 4500);
        kpuFoodMenu[i++] = new SchoolFood("육회비빔밥", "한식", "밥", "한스델리", 5000);
        kpuFoodMenu[i++] = new SchoolFood("삼겹살김치볶음밥", "한식", "밥", "한스델리", 4500);

        kpuFoodMenu[i++] = new SchoolFood("짜장밥", "중식", "밥", "몸에존짜장", 3000);
        kpuFoodMenu[i++] = new SchoolFood("짬뽕밥", "중식", "밥", "몸에존짜장", 3500);
        kpuFoodMenu[i++] = new SchoolFood("볶음밥", "중식", "밥", "몸에존짜장", 3500);
        kpuFoodMenu[i++] = new SchoolFood("탕짜면", "중식", "밥", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("탕볶밥", "중식", "밥", "몸에존짜장", 4900);
        kpuFoodMenu[i++] = new SchoolFood("탕짬면", "중식", "밥", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("뚝배기 짬뽕밥", "중식", "밥", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("철판 불고기\n짜장덮밥", "중식", "밥", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("짜장면", "중식", "면", "몸에존짜장", 2900);
        kpuFoodMenu[i++] = new SchoolFood("짬뽕", "중식", "면", "몸에존짜장", 3500);
        kpuFoodMenu[i++] = new SchoolFood("콩국수", "한식", "면", "몸에존짜장", 4000);
        kpuFoodMenu[i++] = new SchoolFood("볶음해물짜장", "중식", "면", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("볶음해물짬뽕", "중식", "면", "몸에존짜장", 4500);
        kpuFoodMenu[i++] = new SchoolFood("찹쌀탕수육(소)", "중식", "요리", "몸에존짜장", 10000);
        kpuFoodMenu[i++] = new SchoolFood("찹쌀탕수육(대)", "중식", "요리", "몸에존짜장", 15000);
        kpuFoodMenu[i++] = new SchoolFood("깐풍기(소)", "중식", "요리", "몸에존짜장", 10000);
        kpuFoodMenu[i++] = new SchoolFood("깐풍기(대)", "중식", "요리", "몸에존짜장", 15000);

        kpuFoodMenu[i++] = new SchoolFood("철판\n참치김치덮밥", "한식", "밥", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("돌솥닭갈비", "한식", "밥", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("돌솥제육덮밥", "한식", "밥", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("닭갈비덮밥", "한식", "밥", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("철판\n쭈꾸미삼겹덮밥", "한식", "밥", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("치즈베이컨\n김치볶음밥", "양식", "밥", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("돼지고기\n차슈덮밥", "한식", "밥", "김밥천국", 5000);
        kpuFoodMenu[i++] = new SchoolFood("소불고기\n치즈볶음밥", "한식", "밥", "김밥천국", 5000);
        kpuFoodMenu[i++] = new SchoolFood("돼지주물럭", "한식", "밥", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("목살스테이크\n덮밥", "양식", "밥", "김밥천국", 5000);
        kpuFoodMenu[i++] = new SchoolFood("고기쫄면", "한식", "면", "김밥천국", 4500);
        kpuFoodMenu[i++] = new SchoolFood("햄치즈순두부", "한식", "밥", "김밥천국", 5000);
        kpuFoodMenu[i++] = new SchoolFood("순두부찌개", "한식", "밥", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("물냉면", "한식", "면", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("비빔냉면", "한식", "면", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("냉쫄면", "한식", "면", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("짜장떢볶이", "한식", "요리", "김밥천국", 3500);
        kpuFoodMenu[i++] = new SchoolFood("야채김밥", "한식", "밥", "김밥천국", 1800);
        kpuFoodMenu[i++] = new SchoolFood("참치김밥", "한식", "밥", "김밥천국", 2400);
        kpuFoodMenu[i++] = new SchoolFood("라면", "한식", "면", "김밥천국", 2400);
        kpuFoodMenu[i++] = new SchoolFood("떡만두라면", "한식", "면", "김밥천국", 3500);
        kpuFoodMenu[i++] = new SchoolFood("모듬떡볶이", "한식", "요리", "김밥천국", 4000);
        kpuFoodMenu[i++] = new SchoolFood("라볶이", "한식", "요리", "김밥천국", 3000);

        int itemCount = i-1;
        selectFood = new Vector<>();

        for(int j=0;j<=itemCount;j++)
        {
            selectFood.add(kpuFoodMenu[j]);
        }
        random = new Random();

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                if(start == false)
                {
                    return;
                }

                Integer selectedFoodNumber = random.nextInt(selectFood.size());
                SchoolFood selectedFood = selectFood.get(selectedFoodNumber);
                String selectedFoodName = selectedFood.getFoodName();
                String selectedFoodRestaurant = selectedFood.getRestaurantName();
                String selectedFoodPrice = selectedFood.getPrice().toString();

                textView1.setText(selectedFoodName);
                textView2.setText(selectedFoodRestaurant);
                textView3.setText(selectedFoodPrice+"원");
                handler.postDelayed(this,100);

            }
        });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(start==true)
                    {
                        start = false;
                        flag = false;
                    }

                }
            });
            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        flag = true;
                    if (start==false)
                    {
                        start = true;
                        final Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(flag == false)
                                {
                                    flag = true;
                                    start = false;
                                    return;
                                }
                                Integer selectedFoodNumber = random.nextInt(selectFood.size());
                                SchoolFood selectedFood = selectFood.get(selectedFoodNumber);
                                String selectedFoodName = selectedFood.getFoodName();
                                String selectedFoodRestaurant = selectedFood.getRestaurantName();
                                String selectedFoodPrice = selectedFood.getPrice().toString();

                                textView1.setText(selectedFoodName);
                                textView2.setText(selectedFoodRestaurant);
                                textView3.setText(selectedFoodPrice+"원");
                                handler.postDelayed(this,100);
                            }
                        });
                    }
                }
            });
        Button button = (Button)findViewById(R.id.food_random_back_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
