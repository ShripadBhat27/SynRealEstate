package com.example.ngosocialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class netbankpay extends AppCompatActivity {

    FirebaseAuth fAuth;
    DatabaseReference databaseUsers,databaseUsers2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netbankpay);
        TextInputEditText amount=findViewById(R.id.AmountNet);
        TextInputEditText usernet=findViewById(R.id.netUser);
        TextInputEditText pass=findViewById(R.id.netPass);
        fAuth= FirebaseAuth.getInstance();
        databaseUsers= FirebaseDatabase.getInstance().getReference("transaction");
        databaseUsers2=FirebaseDatabase.getInstance().getReference("transaction");
        String user,ngo="n2";
        user=fAuth.getUid();
        Button btn=findViewById(R.id.netpay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getText().toString().isEmpty()==true || usernet.getText().toString().isEmpty()==true ||
                        pass.getText().toString().isEmpty()==true
                )
                {
                    Toast.makeText(getApplicationContext(),"Few filed are empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    transaction tra=new transaction(user,ngo,amount.getText().toString());
                    databaseUsers.child(user).push().setValue(tra);
                    databaseUsers.child("shri").push().setValue(tra);
                    Intent j=new Intent(getApplicationContext(),splashAfterTran.class);
                    startActivity(j);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
            }
        });
    }

}