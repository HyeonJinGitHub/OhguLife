package com.example.mobileteamproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDialog extends Dialog {
    Intent Myintent;
    Context mContext;
    TextView phone;
    Integer[] images = {R.drawable.location_jonghab, R.drawable.location_dom2, R.drawable.location_dom2, R.drawable.location_g,
            R.drawable.location_sanyung, R.drawable.location_a, R.drawable.location_b, R.drawable.location_b, R.drawable.location_c,
            R.drawable.location_e, R.drawable.location_e, R.drawable.location_d, R.drawable.location_d, R.drawable.location_a,
            R.drawable.location_g, R.drawable.location_p, R.drawable.location_c, R.drawable.location_d};
    String[] locations ={"종합관 111호, 128호", "제2기숙사 200호", "제2기숙사 100호", "공학관 G동 116호","산업융합본부 410호","공학관A동 210호",
            "공학관 B동 219호", "공학관 B동 307호","공학관 C동 209호","공학관 E동 3층 309호","공학관 E동 3층 311호", "공학관 D동 208호","공학관 D동 310호",
            "공학관 A동 305호","공학관 G동 314호","공학관 P동 515호","공학관 C동 304호","공학관 D동 215호"};

    public CustomDialog(Context context, Intent intent){
        super(context);
        Myintent = intent;
        mContext = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        Typeface myFont;
        myFont = Typeface.createFromAsset(getContext().getAssets(),"newfont.ttf");

        Button cancel = (Button) findViewById(R.id.cancel_btn);
        Button call = (Button) findViewById(R.id.call_btn);
        phone = (TextView)findViewById(R.id.phone_number);
        ImageView imageView = (ImageView)findViewById(R.id.location_image);
        TextView location = (TextView)findViewById(R.id.location);

        int pos = Myintent.getIntExtra("POSITION", 0);
        final String phone_number = Myintent.getStringExtra("PHONE").trim();

        phone.setText("tel : " + phone_number); // Dial Intent를 보낼 때 tel:010-0000-0000 이 형식으로 보내야 함!
        // phone.setTypeface(myFont);
        imageView.setImageResource(images[pos]);
        location.setText("위치 : " + locations[pos]);
        // location.setTypeface(myFont);

        // cancel.setTypeface(myFont);
        // call.setTypeface(myFont);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.this.dismiss();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone_number));
                mContext.startActivity(callIntent);
            }
        });
        //phone.getText().toString()
    }

}
