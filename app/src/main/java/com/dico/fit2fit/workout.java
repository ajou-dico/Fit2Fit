package com.dico.fit2fit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class workout extends Fragment {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.burpee:
                    Intent intent = new Intent(getActivity(), Timer.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}