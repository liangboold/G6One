package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.g6one.R;
import com.example.g6one.activity.MainActivityQuerys;


public class HomePageFragment extends Fragment {
    View inflate;
    private EditText query;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_home_page, container, false);
        query = (EditText) inflate.findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivityQuerys.class);
                startActivity(intent);
            }
        });

        return inflate;
    }
}