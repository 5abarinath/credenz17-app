package com.pisb.credenz17;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
    TextView tv_name[] = new TextView[8];//, tv_regist[], tv_college, tv_events, tv_amount, tv_date, tv_year;
    TextView tv_regist[] = new TextView[8];
    TextView tv_college[] = new TextView[8];
    TextView tv_events[] = new TextView[8];
    TextView tv_amount[] = new TextView[8];
    TextView tv_date[] = new TextView[8];
    TextView tv_year[] = new TextView[8];

    final String eventList[] = {"B-Plan", "Clash", "Contraption", "Cretronix", "Croodle", "Mad Talks", "Network Treasure Hunt", "Paper Presentation", "Pixelate", "Quiz", "Reverse Coding", "Roboliga", "Software Development", "Wall Street", "Web Weaver", "Xodia"};

    CardView receipt[] = new CardView[8];

    SharedPreferences sharedPref_receipt;

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

        tv_regist[0] = (TextView) view.findViewById(R.id.tv_regist);
        tv_regist[1] = (TextView) view.findViewById(R.id.tv_regist2);
        tv_regist[2] = (TextView) view.findViewById(R.id.tv_regist3);
        tv_regist[3] = (TextView) view.findViewById(R.id.tv_regist4);
        tv_regist[4] = (TextView) view.findViewById(R.id.tv_regist5);
        tv_regist[5] = (TextView) view.findViewById(R.id.tv_regist6);
        tv_regist[6] = (TextView) view.findViewById(R.id.tv_regist7);
        tv_regist[7] = (TextView) view.findViewById(R.id.tv_regist8);

        tv_name[0] = (TextView) view.findViewById(R.id.tv_name);
        tv_name[1] = (TextView) view.findViewById(R.id.tv_name2);
        tv_name[2] = (TextView) view.findViewById(R.id.tv_name3);
        tv_name[3] = (TextView) view.findViewById(R.id.tv_name4);
        tv_name[4] = (TextView) view.findViewById(R.id.tv_name5);
        tv_name[5] = (TextView) view.findViewById(R.id.tv_name6);
        tv_name[6] = (TextView) view.findViewById(R.id.tv_name7);
        tv_name[7] = (TextView) view.findViewById(R.id.tv_name8);

        tv_college[0] = (TextView) view.findViewById(R.id.tv_college);
        tv_college[1] = (TextView) view.findViewById(R.id.tv_college2);
        tv_college[2] = (TextView) view.findViewById(R.id.tv_college3);
        tv_college[3] = (TextView) view.findViewById(R.id.tv_college4);
        tv_college[4] = (TextView) view.findViewById(R.id.tv_college5);
        tv_college[5] = (TextView) view.findViewById(R.id.tv_college6);
        tv_college[6] = (TextView) view.findViewById(R.id.tv_college7);
        tv_college[7] = (TextView) view.findViewById(R.id.tv_college8);

        tv_year[0] = (TextView) view.findViewById(R.id.tv_year);
        tv_year[1] = (TextView) view.findViewById(R.id.tv_year2);
        tv_year[2] = (TextView) view.findViewById(R.id.tv_year3);
        tv_year[3] = (TextView) view.findViewById(R.id.tv_year4);
        tv_year[4] = (TextView) view.findViewById(R.id.tv_year5);
        tv_year[5] = (TextView) view.findViewById(R.id.tv_year6);
        tv_year[6] = (TextView) view.findViewById(R.id.tv_year7);
        tv_year[7] = (TextView) view.findViewById(R.id.tv_year8);

        tv_events[0] = (TextView) view.findViewById(R.id.tv_events);
        tv_events[1] = (TextView) view.findViewById(R.id.tv_events2);
        tv_events[2] = (TextView) view.findViewById(R.id.tv_events3);
        tv_events[3] = (TextView) view.findViewById(R.id.tv_events4);
        tv_events[4] = (TextView) view.findViewById(R.id.tv_events5);
        tv_events[5] = (TextView) view.findViewById(R.id.tv_events6);
        tv_events[6] = (TextView) view.findViewById(R.id.tv_events7);
        tv_events[7] = (TextView) view.findViewById(R.id.tv_events8);

        tv_amount[0] = (TextView) view.findViewById(R.id.tv_amount);
        tv_amount[1] = (TextView) view.findViewById(R.id.tv_amount2);
        tv_amount[2] = (TextView) view.findViewById(R.id.tv_amount3);
        tv_amount[3] = (TextView) view.findViewById(R.id.tv_amount4);
        tv_amount[4] = (TextView) view.findViewById(R.id.tv_amount5);
        tv_amount[5] = (TextView) view.findViewById(R.id.tv_amount6);
        tv_amount[6] = (TextView) view.findViewById(R.id.tv_amount7);
        tv_amount[7] = (TextView) view.findViewById(R.id.tv_amount8);

        tv_date[0] = (TextView) view.findViewById(R.id.tv_date);
        tv_date[1] = (TextView) view.findViewById(R.id.tv_date2);
        tv_date[2] = (TextView) view.findViewById(R.id.tv_date3);
        tv_date[3] = (TextView) view.findViewById(R.id.tv_date4);
        tv_date[4] = (TextView) view.findViewById(R.id.tv_date5);
        tv_date[5] = (TextView) view.findViewById(R.id.tv_date6);
        tv_date[6] = (TextView) view.findViewById(R.id.tv_date7);
        tv_date[7] = (TextView) view.findViewById(R.id.tv_date8);

        receipt[0]=(CardView) view.findViewById(R.id.card_view);
        receipt[1]=(CardView) view.findViewById(R.id.card_view2);
        receipt[2]=(CardView) view.findViewById(R.id.card_view3);
        receipt[3]=(CardView) view.findViewById(R.id.card_view4);
        receipt[4]=(CardView) view.findViewById(R.id.card_view5);
        receipt[5]=(CardView) view.findViewById(R.id.card_view6);
        receipt[6]=(CardView) view.findViewById(R.id.card_view7);
        receipt[7]=(CardView) view.findViewById(R.id.card_view8);


        SharedPreferences sharedPref_receiptCount = this.getActivity().getSharedPreferences(getString(R.string.no_of_receipts), Context.MODE_PRIVATE);
        int receipt_count = sharedPref_receiptCount.getInt("count",-1);

        String op = "" + receipt_count;
//        Log.d("TAG", op);

        if(receipt_count == -1){
            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            alert.setTitle("Guidelines");
            alert.setMessage(R.string.help_guidelines);

//                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        //Your action here
//                    }
//                });

            alert.setNegativeButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    });

            alert.show();
        }

        for(int i=0; i<=receipt_count; i++) {
            String receipt_name = "receipt" + i;
            sharedPref_receipt = this.getActivity().getSharedPreferences(receipt_name, Context.MODE_PRIVATE);

            String name1 = sharedPref_receipt.getString("name1","");
            String name2 = sharedPref_receipt.getString("name2","");
            String name3 = sharedPref_receipt.getString("name3","");
            String name4 = sharedPref_receipt.getString("name4","");
            String college = sharedPref_receipt.getString("college","");
            String amount = sharedPref_receipt.getString("amount","");
            String date = sharedPref_receipt.getString("date","");
            String events = sharedPref_receipt.getString("eventCode","");
            String regist = sharedPref_receipt.getString("regID","");
            int year = sharedPref_receipt.getInt("year",-1);

            tv_regist[i].setText(regist);
            tv_name[i].setText(name1);
            if(name2.length() != 0)
                tv_name[i].append("\n"+name2);
            if(name3.length() != 0)
                tv_name[i].append("\n"+name3);
            if(name4.length() != 0)
                tv_name[i].append("\n"+name4);
            tv_college[i].setText(college);
            tv_amount[i].setText("Total Amount: " + amount);
            tv_date[i].setText("Date: " + date);

            if(year==0)
                tv_year[i].setText("Junior");
            else
                tv_year[i].setText("Senior");


            for(int j=0; j<=15; j++){
                int temp_int = (int)events.charAt(j);
                if(temp_int!=48)
                    tv_events[i].append(eventList[j]+"\n");
            }
            receipt[i].setVisibility(View.VISIBLE);
        }

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

                int receiptCount;

                SharedPreferences sharedPref_receiptCount = this.getActivity().getSharedPreferences(getString(R.string.no_of_receipts), Context.MODE_PRIVATE);
                if(receipt[0].getVisibility() == View.GONE){
                    SharedPreferences.Editor editor = sharedPref_receiptCount.edit();
                    editor.putInt("count", 0);
                    editor.apply();
                    receiptCount = 0;
                }
                else {
                    receiptCount = sharedPref_receiptCount.getInt("count", 0);
                    receiptCount++;

                    if(receiptCount>7)
                        receiptCount=0;

                    SharedPreferences.Editor editor = sharedPref_receiptCount.edit();
                    editor.putInt("count", receiptCount);
                    editor.apply();
                }

                String receipt_name = "receipt" + receiptCount;
                sharedPref_receipt = this.getActivity().getSharedPreferences(receipt_name, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref_receipt.edit();
                editor.putString("name1",name1);
                editor.putString("name2",name2);
                editor.putString("name3",name3);
                editor.putString("name4",name4);
                editor.putString("college",college);
                editor.putString("amount",amount);
                editor.putString("date",date);
                editor.putInt("year", year);
                editor.putString("eventCode", events);
                editor.putString("regID",regist);
                editor.apply();

                tv_regist[receiptCount].setText(regist);
                tv_name[receiptCount].setText(name1);
                if(name2.length() != 0)
                    tv_name[receiptCount].append("\n"+name2);
                if(name3.length() != 0)
                    tv_name[receiptCount].append("\n"+name3);
                if(name4.length() != 0)
                    tv_name[receiptCount].append("\n"+name4);
                tv_college[receiptCount].setText(college);
                tv_amount[receiptCount].setText("Total Amount: " + amount);
                tv_date[receiptCount].setText("Date: " + date);

                if(year==0)
                    tv_year[receiptCount].setText("Junior");
                else
                    tv_year[receiptCount].setText("Senior");

                for(int i=0; i<=15; i++){
                    int temp_int = (int)events.charAt(i);
                    if(temp_int!=48)
                        tv_events[receiptCount].append(eventList[i]+"\n");
                }
                receipt[receiptCount].setVisibility(View.VISIBLE);
            }
        }
    }
}
