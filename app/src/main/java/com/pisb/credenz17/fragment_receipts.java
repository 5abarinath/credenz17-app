package com.pisb.credenz17;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sabari on 3/7/17.
 */

public class fragment_receipts extends Fragment {

    View view;
    FloatingActionButton fab;
    TextView tv_name, tv_regist, tv_college, tv_events, tv_amount, tv_date, tv_year;

    final String eventList[] = {"B-Plan", "Clash", "Contraption", "Cretronix", "Croodle", "Mad Talks", "Network Treasure Hunt", "Paper Presentation", "Pixelate", "Quiz", "Reverse Coding", "Roboliga", "Software Development", "Wall Street", "Web Weaver", "Xodia"};

    CardView receipt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_receipts, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("My Receipts");

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_addReceipt.class);
                startActivityForResult(intent, 1);
            }
        });


        tv_regist = (TextView) view.findViewById(R.id.tv_regist);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_college = (TextView) view.findViewById(R.id.tv_college);
        tv_year = (TextView) view.findViewById(R.id.tv_year);
        tv_events = (TextView) view.findViewById(R.id.tv_events);
        tv_amount = (TextView) view.findViewById(R.id.tv_amount);
        tv_date = (TextView) view.findViewById(R.id.tv_date);

        receipt=(CardView) view.findViewById(R.id.card_view);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String name1 = data.getStringExtra("name1");
                String name2 = data.getStringExtra("name2");
                String name3 = data.getStringExtra("name3");
                String name4 = data.getStringExtra("name4");
                String email = data.getStringExtra("email");
//                String phone = data.getStringExtra("phone");
                String college = data.getStringExtra("college");
                String volunteer = data.getStringExtra("volunteer");
                String date = data.getStringExtra("date");
                String events = data.getStringExtra("events");
                String regist = data.getStringExtra("regist");
                int year = Integer.parseInt(data.getStringExtra("year"));
                String amount = data.getStringExtra("amount");

                tv_regist.setText("Registration Id: " + regist);
                tv_name.setText(name1);
                if(name2.length() != 0)
                    tv_name.append("\n"+name2);
                if(name3.length() != 0)
                    tv_name.append("\n"+name3);
                if(name4.length() != 0)
                    tv_name.append("\n"+name4);
                tv_college.setText(college);
                tv_amount.setText("Total Amount: " + amount);
                tv_date.setText(date);

                if(year==0)
                    tv_year.setText("Junior Category");
                else
                    tv_year.setText("Senior Category");

                for(int i=0; i<=15; i++){
                    int temp_int = (int)events.charAt(i);
                    if(temp_int!=48)
                        tv_events.append(eventList[i]+"\n");
                }
                receipt.setVisibility(View.VISIBLE);
            }
        }
    }
}
