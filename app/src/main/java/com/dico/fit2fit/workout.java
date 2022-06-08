package com.dico.fit2fit;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class workout extends Fragment {
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    MainActivity activity;
    recording record;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_workout, container, false);
        activity = (MainActivity) getActivity();

        ImageButton prevbtn = rootView.findViewById(R.id.prev_btn);
        btn1 = rootView.findViewById(R.id.burpee);
        btn2 = rootView.findViewById(R.id.crunch);
        btn3 = rootView.findViewById(R.id.jumpingjack);
        btn4 = rootView.findViewById(R.id.legraise);
        btn5 = rootView.findViewById(R.id.lunge);
        btn6 = rootView.findViewById(R.id.plank);
        btn7 = rootView.findViewById(R.id.pushup);
        btn8 = rootView.findViewById(R.id.squat);
        btn9 = rootView.findViewById(R.id.situp);

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(2);
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Timer.class);

                switch (view.getId()){
                    case R.id.burpee:
                        startActivity(intent);
                        break;
                    case R.id.crunch:
                        startActivity(intent);
                        break;
                    case R.id.jumpingjack:
                        startActivity(intent);
                        break;
                    case R.id.legraise:
                        startActivity(intent);
                        break;
                    case R.id.lunge:
                        startActivity(intent);
                        break;
                    case R.id.plank:
                        startActivity(intent);
                        break;
                    case R.id.pushup:
                        startActivity(intent);
                        break;
                    case R.id.situp:
                        startActivity(intent);
                        break;
                    case R.id.squat:
                        startActivity(intent);
                        break;
                }
            }
        };
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        // Inflate the layout for this fragment
        return rootView;
    }


}