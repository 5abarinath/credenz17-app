package com.pisb.credenz17;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sabari on 3/7/17.
 */

public class fragment_ping extends Fragment {

    View view;
    TextView ping;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ping, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("P.I.N.G.");
        ping = (TextView) view.findViewById(R.id.pingdrivelink);
        ping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent driveLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/folderview?id=0B7xgORAS7QdbMVF1RmRWcjNOVkk"));
                startActivity(driveLink);
            }
        });
    }
}
