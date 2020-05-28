package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
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

public class repairpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairpage);
        Bundle bn=getIntent().getExtras();
        final String name=bn.getString("abc4");
        final TextView a,f;
        final EditText b,c,d,e;
        Button btn;
        a=(TextView)findViewById(R.id.textView32);
        f=(TextView)findViewById(R.id.textView36);
        b=(EditText)findViewById(R.id.editText21);
        c=(EditText)findViewById(R.id.editText22);
        btn=(Button)findViewById(R.id.button18);
        a.setText(name);
        DatabaseReference reff;
        reff=FirebaseDatabase.getInstance().getReference().child("Equipments").child(a.getText().toString());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String pquan=dataSnapshot.child("Quantity").getValue().toString();
                f.setText(pquan);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reff= FirebaseDatabase.getInstance().getReference("Service History").child(b.getText().toString()).child(a.getText().toString());
                reff.child("Date").setValue(b.getText().toString());
                reff.child("Service description").setValue(c.getText().toString());
                reff.child("Quantity").setValue(f.getText().toString());
                Toast.makeText(repairpage.this,"Repair details uploaded",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
