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
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends Fragment {
    ImageButton add_f;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<FriendItem> mfriendItems;

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

        mRecyclerView = rootView.findViewById(R.id.re_view);

        /* initiate adapter */
        mRecyclerAdapter = new MyRecyclerAdapter();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL,false));

        /* adapt data */
        mfriendItems = new ArrayList<>();
        for(int i=1;i<=10;i++){
            if(i%2==0)
                mfriendItems.add(new FriendItem(i+"번째 사람"));
            else
                mfriendItems.add(new FriendItem(i+"번째 사람"));

        }
        mRecyclerAdapter.setFriendList(mfriendItems);

        // Inflate the layout for this fragment
        return rootView;
    }

}