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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class workout extends Fragment {
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    MainActivity activity;
    recording record;
    FirebaseAuth mAuth;
    FirebaseFirestore db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_workout, container, false);
        activity = (MainActivity) getActivity();
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


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
                recording rec = new recording();
                Bundle bundle = new Bundle();

                //bundle 넣고 스위치에 번들별로 각각 다르게 넣고, 레코딩에 번들에 따라 리스트뷰 추가하기
                //그 밑에는 타이머에서 보낸 시간이랑 그거 계산해서 칼로리 표시하기
                switch (view.getId()){
                    case R.id.burpee:
                        bundle.putInt("burpee",1);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.crunch:
                        bundle.putInt("crunch",2);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.jumpingjack:
                        bundle.putInt("jumpinjack",3);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.legraise:
                        bundle.putInt("legraise",4);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.lunge:
                        bundle.putInt("lunge",5);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.plank:
                        bundle.putInt("plank",6);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.pushup:
                        bundle.putInt("pushup",7);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.situp:
                        bundle.putInt("situp",8);
                        rec.setArguments(bundle);
                        startActivity(intent);
                        break;
                    case R.id.squat:
                        bundle.putInt("squat",9);
                        rec.setArguments(bundle);
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

        return rootView;
    }


}