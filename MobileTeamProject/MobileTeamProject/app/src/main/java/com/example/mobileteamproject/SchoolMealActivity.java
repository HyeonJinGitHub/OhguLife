package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class SchoolMealActivity extends AppCompatActivity {
    Button foodSelectButton;
    Spinner foodMinPriceSpinner, foodMaxPriceSpinner, foodCategorySpinner, foodKindsSpinner, foodRestaurantSpinner;
    TextView textView;
    Integer minPrice, maxPrice;
    String category, kinds, restaurant;

    Integer itemCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.school_meal_layout);
        textView = (TextView)findViewById(R.id.text_today_meal);
        TextView textView1, textView2, textView3,textView4;
        textView1 = (TextView)findViewById(R.id.text_meal_price);
        textView2 = (TextView)findViewById(R.id.text_meal_kind);
        textView3 = (TextView)findViewById(R.id.text_meal_category);
        textView4 = (TextView)findViewById(R.id.text_meal_restaurant);
        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        textView.setTypeface(myFont);
        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        textView3.setTypeface(myFont);
        textView4.setTypeface(myFont);
        int i=0;

        final SchoolFood[] kpuFoodMenu = new SchoolFood[500];

        for(int j=0; j<500; j++)
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

        foodMinPriceSpinner = (Spinner)findViewById(R.id.spinner_price_min);
        foodMaxPriceSpinner = (Spinner)findViewById(R.id.spinner_price_max);
        foodKindsSpinner = (Spinner)findViewById(R.id.spinner_food_kind);
        foodCategorySpinner = (Spinner)findViewById(R.id.spinner_food_category);
        foodRestaurantSpinner = (Spinner)findViewById(R.id.spinner_food_restaurant);
        foodSelectButton = (Button)findViewById(R.id.button_schoolMeal_select);

        itemCount = i-1;

        maxPrice = 15000;
        minPrice = 1500;

        foodMinPriceSpinner.setSelection(9);

        foodMinPriceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                minPrice = Integer.parseInt(parent.getItemAtPosition(position).toString());
                if(minPrice > maxPrice) {
                    Toast.makeText(view.getContext(), "최소금액을 다시 설정해주세요.", Toast.LENGTH_SHORT).show();
                    foodMinPriceSpinner.setSelection(8);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                minPrice = 2000;
            }
        });

        foodMaxPriceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maxPrice = Integer.parseInt(parent.getItemAtPosition(position).toString());
                if(maxPrice < minPrice)
                {
                    Toast.makeText(view.getContext(), "최대금액을 다시 설정해주세요.", Toast.LENGTH_SHORT).show();
                    foodMaxPriceSpinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                maxPrice = 6000;
            }
        });

        foodKindsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    kinds = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    kinds = "전체";
            }
        });
        foodRestaurantSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                restaurant = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                restaurant = "전체";
            }
        });
        foodCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    category = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    category = "전체";
            }
        });

        foodSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vector<SchoolFood> selectFood = new Vector<>();

                if(minPrice > maxPrice) {
                    Toast.makeText(v.getContext(), "최대금액을 다시 설정해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i=0; i<itemCount; i++) {
                    if(category.equals("전체") && kinds.equals("전체") && restaurant.equals("전체")){
                        if(kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice)
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(kinds.equals("전체") && category.equals("전체")) {
                        if(kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getRestaurantName().equals(restaurant))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(kinds.equals("전체") && restaurant.equals("전체")) {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getCategory().equals(category))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(category.equals("전체") && restaurant.equals("전체")) {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getKinds().equals(kinds))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(category.equals("전체")) {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getKinds().equals(kinds)
                                && kpuFoodMenu[i].getRestaurantName().equals(restaurant))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(restaurant.equals("전체")) {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getCategory().equals(category)
                                && kpuFoodMenu[i].getKinds().equals(kinds))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else if(kinds.equals("전체")) {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getRestaurantName().equals(restaurant)
                                && kpuFoodMenu[i].getCategory().equals(category))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                    else {
                        if (kpuFoodMenu[i].getPrice() >= minPrice
                                && kpuFoodMenu[i].getPrice() <= maxPrice
                                && kpuFoodMenu[i].getCategory().equals(category)
                                && kpuFoodMenu[i].getKinds().equals(kinds)
                                && kpuFoodMenu[i].getRestaurantName().equals(restaurant))
                            selectFood.add(kpuFoodMenu[i]);
                    }
                }

                if(selectFood.size() == 0) {
                    Toast.makeText(v.getContext(), "조건에 맞는 음식이 없습니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                Random random = new Random();
                Integer selectedFoodNumber = random.nextInt(selectFood.size());

                SchoolFood selectedFood = selectFood.get(selectedFoodNumber);
                String selectedFoodName = selectedFood.getFoodName();
                String selectedFoodRestaurant = selectedFood.getRestaurantName();
                String selectedFoodPrice = selectedFood.getPrice().toString();

                Intent intent = new Intent(SchoolMealActivity.this, SchoolMealResultActivity.class);
                intent.putExtra("selectedMealName", selectedFoodName);
                intent.putExtra("selectedMealRestaurant", selectedFoodRestaurant);
                intent.putExtra("selectedMealPrice", selectedFoodPrice);
                startActivity(intent);
            }
        });


    }
}
