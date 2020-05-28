package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Retrieve_layout extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         final TextView a,b,c,d;
         Button btn,repair;
         DatabaseReference reff;
         final TextView Display;

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_layout);
        Display=(TextView)findViewById(R.id.textView22);
        Bundle bn=getIntent().getExtras();
        String name=bn.getString("abc1");
        Display.setText(String.valueOf(name));
        b=(TextView)findViewById(R.id.textView23);
        c=(TextView)findViewById(R.id.textView24);
        d=(TextView)findViewById(R.id.textView25);
        repair=(Button)findViewById(R.id.button17);

        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Retrieve_layout.this,repairpage.class);
                intent.putExtra("abc4",Display.getText().toString());

                startActivity(intent);

            }
        });

        reff=FirebaseDatabase.getInstance().getReference().child("Equipments").child(Display.getText().toString());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String pname=dataSnapshot.child("Equipment Name").getValue().toString();
                String cat=dataSnapshot.child("Equipment Catgory").getValue().toString();
                String doi=dataSnapshot.child("Date of installation").getValue().toString();
                String ph="a"+Display.getText().toString();
                ImageView v=(ImageView)findViewById(R.id.imagev);
                b.setText(pname);
                c.setText(cat);
                d.setText(doi);
                Context c=getApplicationContext();
                int id=c.getResources().getIdentifier("drawable/"+ph,null,c.getPackageName());
                v.setImageResource(id);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
