package com.pisb.credenz17;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by sabari on 3/7/17.
 */

public class fragment_home extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
       ImageButton instagram = (ImageButton) view.findViewById(R.id.imageButton1);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/pisbcredenz/"));
                startActivity(browserIntent);

            }
        });
        ImageButton facebook = (ImageButton) view.findViewById(R.id.imageButton2);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/pisbcredenz/"));
                startActivity(browserIntent);

            }
        });

        ImageButton twitter = (ImageButton) view.findViewById(R.id.imageButton3);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/pisbcredenz?s=09"));
                startActivity(browserIntent);

            }
        });

        Button btn = (Button) view.findViewById(R.id.btn_register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent meraEvents = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.meraevents.com/event/credenz2017?ucode=organizer"));
                startActivity(meraEvents);
            }
        });

        ImageView imgView = (ImageView) view.findViewById(R.id.imageView);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.credenz.info"));
                startActivity(website);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Credenz '17");
    }
}
