package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Scan_cam_read_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TextView a,b,c,d,e;
        Button btn,btn1,btn2;
        DatabaseReference reff;
        final TextView Display;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_cam_read_admin);
        Display=(TextView)findViewById(R.id.editText15);
        Bundle bn=getIntent().getExtras();
        String name=bn.getString("abc2");
        Display.setText(String.valueOf(name));

        b=(TextView)findViewById(R.id.editText16);
        c=(TextView)findViewById(R.id.editText17);
        d=(TextView)findViewById(R.id.editText18);
        e=(EditText)findViewById(R.id.editText20);
        reff= FirebaseDatabase.getInstance().getReference().child("Equipments").child(Display.getText().toString());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String pname=dataSnapshot.child("Equipment Name").getValue().toString();
                String cat=dataSnapshot.child("Equipment Catgory").getValue().toString();
                String doi=dataSnapshot.child("Date of installation").getValue().toString();
                String quan=dataSnapshot.child("Quantity").getValue().toString();
                b.setText(pname);
                c.setText(cat);
                d.setText(doi);
                e.setText(quan);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
      btn=(Button)findViewById(R.id.button14);
      btn1=(Button)findViewById(R.id.button15);
      btn2=(Button)findViewById(R.id.button16);
      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(Scan_cam_read_admin.this,Service_final.class);

              intent.putExtra("abc3",Display.getText().toString());
              startActivity(intent);

          }
      });
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              DatabaseReference reff=FirebaseDatabase.getInstance().getReference().child("Equipments").child(Display.getText().toString());
              reff.child("EquipmentID").setValue(Display.getText().toString());
              reff.child("Equipment Name").setValue(b.getText().toString());
              reff.child("Equipment Catgory").setValue(c.getText().toString());
              reff.child("Date of installation").setValue(d.getText().toString());
              reff.child("Quantity").setValue(e.getText().toString());
              Toast.makeText(Scan_cam_read_admin.this,"Database Successfully Updated!!",Toast.LENGTH_SHORT).show();
          }
      });

      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              DatabaseReference reff=FirebaseDatabase.getInstance().getReference("Equipments").child(Display.getText().toString());
              reff.removeValue();
              Toast.makeText(Scan_cam_read_admin.this,"Product deleted from inventory!!",Toast.LENGTH_SHORT).show();
          }
      });

    }
}
