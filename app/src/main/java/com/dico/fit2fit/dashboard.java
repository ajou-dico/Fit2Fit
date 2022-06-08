package com.dico.fit2fit;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class dashboard extends Fragment {
    ImageButton add_f;
    ImageView last_ex;
    ProgressBar pbar;
    TextView Goal_sec,cur_sec, Goal_Kcal, cur_Kcal;

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<FriendItem> mfriendItems;
    private static final String TAG = "Tag";
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard, container, false);

        add_f =rootView.findViewById(R.id.add_f);
        add_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), add_friend.class);
                startActivity(intent);

            }
        });
        Timer timer = new Timer();


        mRecyclerView = rootView.findViewById(R.id.re_view);
        pbar = rootView.findViewById(R.id.p_bar);
        int cur_ex_time = 2;
        pbar.setMax(100);
        pbar.setProgress(cur_ex_time);

        last_ex = rootView.findViewById(R.id.last_ex);
        Goal_sec = rootView.findViewById(R.id.Goal_sec);
        cur_sec = rootView.findViewById(R.id.cur_sec);
        Goal_Kcal = rootView.findViewById(R.id.Goal_Kcal);
        cur_Kcal = rootView.findViewById(R.id.burn_Kcal);

        last_ex.setImageResource(R.drawable.ic_jumpingjack);
        Goal_sec.setText("120분");
        cur_sec.setText(cur_ex_time + "분");
        Goal_Kcal.setText("500 Kcal");
        cur_Kcal.setText("20 Kcal");

        /* initiate adapter */
        mRecyclerAdapter = new MyRecyclerAdapter();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.VERTICAL,false));

        /* adapt data */
        mfriendItems = new ArrayList<>();
        //mfriendItems.add() 친구 추가 후 등록
        mfriendItems.add(new FriendItem("이민준"));
        mfriendItems.add(new FriendItem("서준"));
        mfriendItems.add(new FriendItem("조성민"));
        mfriendItems.add(new FriendItem("김민지"));
        mfriendItems.add(new FriendItem("김승우"));
        mfriendItems.add(new FriendItem("최슬기"));

        mRecyclerAdapter.setFriendList(mfriendItems);

        // Inflate the layout for this fragment
        return rootView;
    }

}