package com.example.mobileteamproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStudy extends Fragment {


    public FragmentStudy() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        ImageView calculator = (ImageView) view.findViewById(R.id.study_calculator);
        ImageView memo = (ImageView) view.findViewById(R.id.study_memo);
        ImageView measure=(ImageView)view.findViewById(R.id.study_measure);

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculateActivity.class);
                startActivity(intent);
            }
        });
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MeasureActivity.class);
                startActivity(intent);
            }
        });
        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MemoActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
