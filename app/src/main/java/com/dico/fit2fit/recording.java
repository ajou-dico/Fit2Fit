package com.dico.fit2fit;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.WriteResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
=======


>>>>>>> 71d10eed672fc63d93a5693e9e8ac623569a9c8d
public class  recording extends Fragment {
    MainActivity mainActivity;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    String burpee, crunch, jumpinjack, legrasie, lunge, plank, pushup, situp, squat;
    String goalDate;
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

        ImageButton button1 = rootView.findViewById(R.id.plus_btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onFragmentChange(1);
                //setdateInfo();
                //setExInfo();
            }
        });
        CalendarView cal = rootView.findViewById(R.id.rec_cal);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String month;
                if (i1+1 < 10) {
                    month = "0" + String.valueOf(i1+1);
                } else {
                    month = String.valueOf(i1+1);
                }
                goalDate = (String.valueOf(i) + "/" + month + "/" + String.valueOf(i2));
            }
        });

        //ViewGroup은 View에 속하므로 View가 리턴 타입이어도 ViewGroup을 리턴할 수 있다.
        return rootView;
    }

<<<<<<< HEAD
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
=======
    protected void setdateInfo() {
        DocumentReference DR = db.collection("Users").document();
        Map<String, Object> data = new HashMap<>();
        date dayInf = new date(goalDate);
        data.put("dateExercise", dayInf);
        DR.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }
    protected void setExInfo() {
        DocumentReference DR = db.collection("Users").document(user.getUid());

        Map<String, Object> work_data = new HashMap<>();
        worklist workInf = new worklist(burpee, crunch, jumpinjack, legrasie, lunge, plank, pushup, situp, squat);
        work_data.put(goalDate, workInf);

        DR.update(work_data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }

    private static final String TAG = "Tag";
>>>>>>> 71d10eed672fc63d93a5693e9e8ac623569a9c8d
}
