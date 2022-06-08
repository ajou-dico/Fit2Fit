package com.dico.fit2fit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class recording extends Fragment {
    long workout_time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recording, container, false);
    }

    public long workout_Time(long t){
        workout_time = t;
        return workout_time;
    }
}