package com.dico.fit2fit;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class recording extends Fragment {
    MainActivity mainActivity;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    Button go_to_workout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recording, container, false);

        //fragment_main.xml에 접근하기위해서는 rootView. 으로 접근해야한다
        //버튼1 초기화
        ImageButton button1 = rootView.findViewById(R.id.plus_btn);

        //버튼1 기능 추가
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onFragmentChange(1);
            }
        });

        //ViewGroup은 View에 속하므로 View가 리턴 타입이어도 ViewGroup을 리턴할 수 있다.
        return rootView;
    }


}