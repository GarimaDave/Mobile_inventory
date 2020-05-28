package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static Button button_sbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
        DatabaseReference reff=FirebaseDatabase.getInstance().getReference().child("Equipments").child("1027");
        reff.child("Date of installation").setValue("25-07-2003");
        reff.child("Quantity").setValue("1");
        reff.child("Equipment Name").setValue("Auxiliary power-unit");
        reff.child("Equipment Catgory").setValue("Power plant");
        reff.child("EquipmentID").setValue("1027");

    }
    public void OnClickButtonListener(){
        button_sbm=(Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(MainActivity.this,Admin_Login_new.class);
                        startActivity(intent);
                    }
                }

        );

        button_sbm=(Button)findViewById(R.id.button2);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(".Worker_login");
                        startActivity(intent);
                    }
                }

        );

        button_sbm=(Button)findViewById(R.id.button3);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(".Main2Activity");
                        startActivity(intent);
                    }
                }

        );
    }
}
