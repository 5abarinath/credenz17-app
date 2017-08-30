package com.pisb.credenz17;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by sabari on 3/7/17.
 */

public class fragment_events extends Fragment {

    View view;
    CardView card[] = new CardView[18];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        card[0] = (CardView) view.findViewById(R.id.card1);
        card[1] = (CardView) view.findViewById(R.id.card2);
        card[2] = (CardView) view.findViewById(R.id.card3);
        card[3] = (CardView) view.findViewById(R.id.card4);
        card[4] = (CardView) view.findViewById(R.id.card5);
        card[5] = (CardView) view.findViewById(R.id.card6);
        card[6] = (CardView) view.findViewById(R.id.card7);
        card[7] = (CardView) view.findViewById(R.id.card8);
        card[8] = (CardView) view.findViewById(R.id.card9);
        card[9] = (CardView) view.findViewById(R.id.card10);
        card[10] = (CardView) view.findViewById(R.id.card11);
        card[11] = (CardView) view.findViewById(R.id.card12);
        card[12] = (CardView) view.findViewById(R.id.card13);
        card[13] = (CardView) view.findViewById(R.id.card14);
        card[14] = (CardView) view.findViewById(R.id.card15);
        card[15] = (CardView) view.findViewById(R.id.card16);
        card[16] = (CardView) view.findViewById(R.id.card17);
        card[17] = (CardView) view.findViewById(R.id.card18);



        card[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_bplan.class);
                startActivity(intent);
            }
        });

        card[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), activity_wallstreet.class);
                startActivity(intent);
            }
        });

        card[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_clash.class);
                startActivity(intent);
            }
        });

        card[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_contraption.class);
                startActivity(intent);
            }
        });

        card[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_cretronix.class);
                startActivity(intent);
            }
        });

        card[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_croodle.class);
                startActivity(intent);
            }
        });

        card[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_mad.class);
                startActivity(intent);
            }
        });

        card[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_nth.class);
                startActivity(intent);
            }
        });

        card[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_pixelate.class);
                startActivity(intent);
            }
        });

        card[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_quiz.class);
                startActivity(intent);
            }
        });

        card[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_rc.class);
                startActivity(intent);
            }
        });

        card[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_xodia.class);
                startActivity(intent);
            }
        });

        card[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_webweaver.class);
                startActivity(intent);
            }
        });

        card[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_paperppt.class);
                startActivity(intent);
            }
        });

        card[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_roboliga.class);
                startActivity(intent);
            }
        });

        card[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_seminars.class);
                startActivity(intent);
            }
        });

        card[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_workshops.class);
                startActivity(intent);
            }
        });

        card[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), activity_softdev.class);
                startActivity(intent);
            }
        });
        getActivity().setTitle("Events");
    }
}
