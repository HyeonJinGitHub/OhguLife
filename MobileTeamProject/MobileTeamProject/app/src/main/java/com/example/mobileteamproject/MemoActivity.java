package com.example.mobileteamproject;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        getFragmentManager().beginTransaction().add(R.id.fragment_container,new TextFragment()).commit();

    }
    public void selectedFragment(View view){
        Fragment fr=null;

        switch (view.getId()){
            case R.id.textBtn:
                fr=new TextFragment();
                break;
            case R.id.drawBtn:
                fr=new DrawFragment();
                break;
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,fr).commit();

    }

}
