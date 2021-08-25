package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g6one.R;
import com.example.g6one.activity.XiangqingActivity;


public class VideoFragment extends Fragment {
    private Button xinxi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_video, container, false);
        xinxi = (Button) inflate.findViewById(R.id.xinxi);
        xinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                startActivity(intent);
            }
        });

        return inflate;
    }
}