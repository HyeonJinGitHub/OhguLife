package com.example.mobileteamproject;

import android.content.Intent;
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

public class PayAloneResultActivity extends AppCompatActivity {
    int number;
    boolean flag = false;
    boolean start = true;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_alone_result_layout);
        ImageView imageView1 = (ImageView)findViewById(R.id.button_pay_alone_restart);
        ImageView imageView2 = (ImageView)findViewById(R.id.button_pay_alone_stop);
        textView = (TextView)findViewById(R.id.pay_alone_name_text);
        TextView textView1 = (TextView)findViewById(R.id.pay_alone_result_text1);
        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        textView.setTypeface(myFont);
        textView1.setTypeface(myFont);

        Intent intent = getIntent();
        number = intent.getIntExtra("NUMBER",0);

        final Vector<String> vector = new Vector<>();
        for(int i=0;i<number;i++)
        {
            vector.add(intent.getStringExtra("NAME"+i));
        }

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                if(start == false)
                {
                    return;
                }

                Integer selectedNameNumber = random.nextInt(vector.size());
                String selectedName = vector.get(selectedNameNumber);
                textView.setText(selectedName);

                handler.postDelayed(this,100);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
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
                            Random random = new Random();
                            if(flag == false)
                            {
                                flag = true;
                                start = false;
                                return;
                            }
                            Integer selectedNameNumber = random.nextInt(vector.size());
                            String selectedName = vector.get(selectedNameNumber);
                            textView.setText(selectedName);

                            handler.postDelayed(this,100);
                        }
                    });
                }
            }
        });
        Button button = (Button)findViewById(R.id.pay_alone_result_back_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
