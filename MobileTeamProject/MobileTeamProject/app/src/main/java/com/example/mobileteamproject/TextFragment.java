package com.example.mobileteamproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * A simple {@link Fragment} subclass.
 */

public class TextFragment extends Fragment {
    EditText title,text;
    TextView count;
    View view;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_text, container, false);
        title=view.findViewById(R.id.title);
        text=view.findViewById(R.id.text);
        count=view.findViewById(R.id.inputCount);

        Button save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos=view.getContext().openFileOutput(title.getText().toString(), Context.MODE_PRIVATE);
                    fos.write(text.getText().toString().getBytes());
                    fos.close();
                    Intent intent=new Intent(getActivity(),SaveActivity.class);
                    intent.putExtra("TITLE",title.getText().toString());
                    startActivity(intent);
                }catch (IOException e){}
            }
        });



        text.addTextChangedListener(new TextWatcher(){
            String beforeText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after){
                beforeText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count){

            }

            @Override

            public void afterTextChanged(Editable editable){
                int length = showBytes();
                if(length >400)
                    text.setText(beforeText);
            }

        });

        showBytes();

        return view;
    }
    private int showBytes(){
        try{
            int length = text.getText().toString().getBytes("EUC-KR").length;
            count.setText(length + " /400 바이트");
            return length;
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return -1;
    }
}