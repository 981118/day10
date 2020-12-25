package com.example.day10.fargmnet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day10.R;
import com.youth.banner.Banner;

import java.util.ArrayList;


public class BlankFragment extends Fragment {


    private View view;
    private RecyclerView rcv;
    private ArrayList<Integer> integers;
    private MyRcvAdapter myRcvAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        integers.add(R.drawable.tu2);
        integers.add(R.drawable.tu5);
        integers.add(R.drawable.tu2);
        myRcvAdapter.notifyDataSetChanged();
    }

    private void initView() {
        rcv = view.findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        integers = new ArrayList<>();
        myRcvAdapter = new MyRcvAdapter(integers,getContext());
        rcv.setAdapter(myRcvAdapter);
    }


}