package com.dico.fit2fit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class  recording extends Fragment {
    MainActivity mainActivity;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    String pickedDate;
    String todayDate;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recording, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        CalendarView calView = rootView.findViewById(R.id.rec_cal);
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String month;
                if (i1+1 < 10) {
                    month = "0" + String.valueOf(i1+1);
                } else {
                    month = String.valueOf(i1+1);
                }
                pickedDate = (String.valueOf(i) + "/" + month + "/" + String.valueOf(i2));
            }
        });

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
        todayDate = format.format(cal.getTime());

        Button addExBtn = rootView.findViewById(R.id.btn_add_exercise);
        addExBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), addExerciseActivity.class);
                intent.putExtra("date", 341);
                startActivity(intent);
            }
        });

        //ViewGroup은 View에 속하므로 View가 리턴 타입이어도 ViewGroup을 리턴할 수 있다.
        return rootView;
    }
//
//    protected void setdateInfo() {
//        DocumentReference DR = db.collection("Users").document();
//        Map<String, Object> data = new HashMap<>();
//        date dayInf = new date(goalDate);
//        data.put("dateExercise", dayInf);
//        DR.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Log.d(TAG, "Success");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w(TAG, "Error adding document", e);
//            }
//        });
//    }
//    protected void setExInfo() {
//        DocumentReference DR = db.collection("Users").document(user.getUid());
//
//        Map<String, Object> work_data = new HashMap<>();
//        worklist workInf = new worklist(burpee, crunch, jumpinjack, legrasie, lunge, plank, pushup, situp, squat);
//        work_data.put(goalDate, workInf);
//
//        DR.update(work_data).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Log.d(TAG, "Success");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w(TAG, "Error adding document", e);
//            }
//        });
//    }
//
//    private static final String TAG = "Tag";
}
