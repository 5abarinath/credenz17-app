package com.pisb.credenz17;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_addReceipt extends AppCompatActivity {

    Button qrBtn, btn_getReceipt;
    private IntentIntegrator qrScan;
    TextView tv;
    ProgressDialog pDialog;
    int regID;
    String mobile;
    EditText ET_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receipt);

        this.setTitle("Add Receipt");
        qrBtn = (Button) findViewById(R.id.btn_QR);
        btn_getReceipt = (Button) findViewById(R.id.btn_getReceipt);
//        tv = (TextView) findViewById(R.id.shitty_tv);
        qrScan = new IntentIntegrator(this);
        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrScan.initiateScan();
            }
        });

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        ET_reg = (EditText) findViewById(R.id.EditText);

        btn_getReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ET_reg.getText().toString().length() == 0)
                    Toast.makeText(activity_addReceipt.this, "Please enter registration id",Toast.LENGTH_SHORT).show();
                else {
                    regID = Integer.parseInt(ET_reg.getText().toString());
                    createDialog();
                }
            }
        });
    }

    public void createDialog(){
        final EditText input1 = new EditText(this);
        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
        TableLayout.LayoutParams params = new TableLayout.LayoutParams();
        params.setMargins(5, 5, 5, 5);
        input1.setLayoutParams(params);

        new AlertDialog.Builder(this)
                .setTitle("Verifiction")
                .setMessage("Please enter your registered mobile number.")
                .setView(input1)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mobile = input1.getText().toString();
//                        mobile = "9405296837";
//                        Toast.makeText(activity_addReceipt.this,"LOL KAPPA123",Toast.LENGTH_SHORT).show();
                        //TODO retrofit
                        sendData();
                    }
                })
                .show();
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
                String verify = result.getContents();


                if(!(verify.substring(0,2).equals("@&")))
                    Toast.makeText(activity_addReceipt.this,"Invalid QR Code",Toast.LENGTH_SHORT).show();
                else {
                    String lul[] = new String[8];
                    lul = verify.substring(2,verify.length()).split(";");
                    String kappa = "Name = " + lul[0] + "Email = " + lul[1] + "Phone = " + lul[2] + "College = " + lul[3] + "Volunteer = " + lul[4] + "Date = " + lul[5] + "Events = " + lul[6] + "Regist = " + lul[7];
                    //                tv.setText(kappa);

                    //TODO: Return value to fragment_receipts

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("name1", lul[0]);
                    returnIntent.putExtra("name2", lul[1]);
                    returnIntent.putExtra("name3", lul[2]);
                    returnIntent.putExtra("name4", lul[3]);
                    returnIntent.putExtra("email", lul[4]);
                    //                returnIntent.putExtra("phone",lul[5]);
                    returnIntent.putExtra("college", lul[6]);
                    returnIntent.putExtra("volunteer", lul[7]);
                    returnIntent.putExtra("events", lul[8]);
                    returnIntent.putExtra("amount", lul[9]);
                    returnIntent.putExtra("year", lul[10]);
                    returnIntent.putExtra("regist", lul[11]);
                    returnIntent.putExtra("date", lul[12]);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void sendData()
    {
        pDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://credenz.info/phpfiles/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<Receipt> call = service.verifyParticipant(regID, mobile);

        call.enqueue(new Callback<Receipt>() {
            @Override
            public void onResponse(Call<Receipt> call, Response<Receipt> response) {
                Receipt receipt = response.body();
                int verified = receipt.getVerified();

                if(verified == 1){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("name1",receipt.getName1());
                    returnIntent.putExtra("name2",receipt.getName2());
                    returnIntent.putExtra("name3",receipt.getName3());
                    returnIntent.putExtra("name4",receipt.getName4());
                    returnIntent.putExtra("email",receipt.getEmail());
//                    returnIntent.putExtra("phone",receipt.getRegID());
                    returnIntent.putExtra("college",receipt.getCollege());
                    returnIntent.putExtra("volunteer",receipt.getVolunteer());
                    returnIntent.putExtra("events", receipt.getEventCode());
                    returnIntent.putExtra("amount",receipt.getTotalAmount());
                    returnIntent.putExtra("year",receipt.getJuniorFlag());
                    returnIntent.putExtra("regist",receipt.getRegID());
//                    Toast.makeText(activity_addReceipt.this,regID,Toast.LENGTH_LONG);
                    returnIntent.putExtra("date",receipt.getDate());
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
//                    Toast.makeText(activity_addReceipt.this, regID, Toast.LENGTH_SHORT).show();

                }
                else{
//                    Log.d("TAG", "ERROR");
                    Toast.makeText(activity_addReceipt.this,"The registration ID does not match with the mobile number",Toast.LENGTH_LONG).show();
                }
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Receipt> call, Throwable t) {
//                Log.d("TAG", "Failure to connect");
                Toast.makeText(activity_addReceipt.this,"Please check your Internet connection",Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });
    }

}
