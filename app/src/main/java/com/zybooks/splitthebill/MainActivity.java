package com.zybooks.splitthebill;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    double Bill;
    int partyNumber;
    double totalCost;
    double tipAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText totalBill = findViewById(R.id.txtTotalBill);
        final EditText partyNum = findViewById(R.id.txtParty);
        final EditText tip = findViewById(R.id.txtTip);
        final TextView result = findViewById(R.id.txtCost);
        Button cost = findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = findViewById(R.id.btnCost);
            @Override
            public void onClick(View v){
                partyNumber = Integer.parseInt(partyNum.getText().toString());
                Bill = Double.parseDouble(totalBill.getText().toString());
                tipAmt = Double.parseDouble(tip.getText().toString());
                totalCost = (Bill+Bill*(tipAmt/100))/partyNumber;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("Cost per person is " + currency.format(totalCost));

            }
        });

    }
}