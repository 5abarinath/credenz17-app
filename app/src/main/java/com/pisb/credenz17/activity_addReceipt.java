package com.pisb.credenz17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

public class activity_addReceipt extends AppCompatActivity {

    Button qrBtn;
    private IntentIntegrator qrScan;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receipt);

        this.setTitle("Add Receipt");
        qrBtn = (Button) findViewById(R.id.btn_QR);
        tv = (TextView) findViewById(R.id.shitty_tv);
        qrScan = new IntentIntegrator(this);
        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_addReceipt.this, "Started Cam", Toast.LENGTH_SHORT).show();
                qrScan.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(this, "Inside OnActivityResult", Toast.LENGTH_SHORT).show();
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
//            Toast.makeText(this, "Inside OnActivityResult2", Toast.LENGTH_SHORT).show();
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
//                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
//                tv.setText(result.getContents());
                String lul[] = new String[8];
                lul = result.getContents().split(";");
                String kappa = "Name = " + lul[0] + "Email = " + lul[1] + "Phone = " + lul[2] + "College = " + lul[3] + "Volunteer = " + lul[4] + "Date = " + lul[5] + "Events = " + lul[6] + "Regist = " + lul[7];
                tv.setText(kappa);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
