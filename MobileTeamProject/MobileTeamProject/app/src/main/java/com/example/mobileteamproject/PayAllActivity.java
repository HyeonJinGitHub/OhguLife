package com.example.mobileteamproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayAllActivity extends AppCompatActivity {
    Button button1, button2;
    TextView textView1,textView2,textView3;
    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_all_layout);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");

        textView1 = (TextView)findViewById(R.id.pay_all_text1);
        textView2 = (TextView)findViewById(R.id.pay_all_text2);
        textView3 = (TextView)findViewById(R.id.pay_all_text3);
        button1 = (Button)findViewById(R.id.pay_all_input_back_button);
        button2 = (Button)findViewById(R.id.pay_all_input_next_button);

        textView1.setTypeface(myFont);
        textView2.setTypeface(myFont);
        textView3.setTypeface(myFont);

        editText1 = (EditText)findViewById(R.id.edit_pay_all_price);
        editText2 = (EditText)findViewById(R.id.edit_pay_all_number);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String price = editText1.getText().toString();
                String number = editText2.getText().toString();
                String result;
                if(price.getBytes().length <= 0 || number.getBytes().length <= 0) {
                    Toast.makeText(v.getContext(), "값을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                Integer priceResult = Integer.parseInt(price);
                Integer numberResult = Integer.parseInt(number);

                if(numberResult <= 0) {
                    Toast.makeText(v.getContext(), "인원수를 1명 이상으로 설정해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    result = Integer.toString(priceResult/numberResult);

                Intent intent = new Intent(PayAllActivity.this,PayAllResultActivity.class);
                intent.putExtra("PRICE",result);
               startActivity(intent);
            }
        });
    }
}
