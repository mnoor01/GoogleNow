package com.example.c4q.hw12googlenow.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.c4q.hw12googlenow.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BBCFragment extends Fragment {
    private View rootview;


    public BBCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview=inflater.inflate(R.layout.fragment_bbc, container, false);



        // Inflate the layout for this fragment
        return rootview;
    }

}
