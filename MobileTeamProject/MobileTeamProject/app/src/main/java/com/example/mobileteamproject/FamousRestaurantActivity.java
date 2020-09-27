package com.example.mobileteamproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class FamousRestaurantActivity extends AppCompatActivity {
    ListView restaurantListView;
    Restaurant[] restaurantLIst = new Restaurant[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.famous_restaurant_layout);

        int i=0;

        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_01, "스시오야봉", "스시계 오야봉"
                , "geo:0,0?q=416, Mayu-ro, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314314541");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_02, "쇼군의 막부", "이자카야에서 편안한 밤을"
                , "geo:0,0?q=187, Jungsimsangga-ro, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314326673");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_03, "엉터리 생고기", "무한리필 고기 맛집"
                , "geo:0,0?q=10, Jungsimsangga 3-gil, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314343374");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_04, "아웃닭", "치킨계 가성비 갑"
                , "geo:0,0?q=3-6, Jungsimsangga 1-gil, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314999095");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_05, "피자마루", "저렴한 피자부터 프리미엄 피자까지"
                , "geo:0,0?q=193, Jungsimsangga-ro, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314314422");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_06, "미소야", "조용한 분위기의 일본식 돈까스"
                , "geo:0,0?q=24, Mayu-ro 418beon-gil, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314346500");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_07, "청년다방", "이것은 떡볶이인가 커피인가"
                , "geo:0,0?q=12-8, Jungsimsangga 2-gil, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314320032");
        restaurantLIst[i++] = new Restaurant(R.drawable.restaurant_08, "모박사 부대찌개", "훈련소 앞 그때의 그맛"
                , "geo:0,0?q=416,  Mayu-ro, Siheung-si, Gyeonggi-do, Republic of Korea", "tel:0314338094");

        CustomList adapter = new CustomList(FamousRestaurantActivity.this);
        restaurantListView = findViewById(R.id.restaurant_list);
        restaurantListView.setAdapter(adapter);
        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final int menuPosition = position;

                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                Menu menu = popupMenu.getMenu();

                menuInflater.inflate(R.menu.restaurant_option_menu, menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.restaurant_call_menu:
                                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(restaurantLIst[position].getCall()));
                                startActivity(callIntent);
                                break;
                            case R.id.restaurant_location_menu:
                                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(restaurantLIst[menuPosition].location));
                                locationIntent.setClassName("com.google.android.apps.maps",
                                        "com.google.android.maps.MapsActivity");
                                startActivity(locationIntent);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<Restaurant> {
        private final Activity context;
        public CustomList(Activity context) {
            super(context, R.layout.list_item, restaurantLIst);
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list_item, null, true);

            ImageView imageView = rowView.findViewById(R.id.image);
            TextView name = rowView.findViewById(R.id.name);
            TextView explanation = rowView.findViewById(R.id.explanation);
            name.setTextColor(Color.BLACK);
            explanation.setTextColor(Color.BLACK);
            imageView.setImageResource(restaurantLIst[position].getImage());
            name.setText(restaurantLIst[position].getName());
            explanation.setText(restaurantLIst[position].getExplanation());

            return rowView;
        }
    }

}
