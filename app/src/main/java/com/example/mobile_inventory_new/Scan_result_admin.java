package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Scan_result_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int count=1005;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result_admin);
        Button add1=findViewById(R.id.button13);
        final EditText name1=findViewById(R.id.editText12);
        final EditText category=findViewById(R.id.editText13);
        final EditText date=findViewById(R.id.editText14);
        final EditText quantity=findViewById(R.id.editText19);
        final TextView Display=(TextView)findViewById(R.id.textView2);
        Bundle bn=getIntent().getExtras();
        String name=bn.getString("abc");
        Display.setText(String.valueOf(name));
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reff=FirebaseDatabase.getInstance().getReference().child("Equipments").child(Display.getText().toString());
                reff.child("EquipmentID").setValue(Display.getText().toString());
                reff.child("Equipment Name").setValue(name1.getText().toString());
                reff.child("Equipment Catgory").setValue(category.getText().toString());
                reff.child("Quantity").setValue(quantity.getText().toString());
                reff.child("Date of installation").setValue(date.getText().toString());
                Toast.makeText(Scan_result_admin.this,"Data uploaded in database",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
