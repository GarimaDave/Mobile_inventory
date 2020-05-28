package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Service_final extends AppCompatActivity {
    ArrayList<String>myarraylist=new ArrayList<>();
    ListView myListView;
    DatabaseReference myFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_final);
        Bundle bn=getIntent().getExtras();
        final String name=bn.getString("abc3");
        ListView myListView=(ListView)findViewById(R.id.special);
        final ArrayAdapter<String> myarrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myarraylist);
        myListView.setAdapter(myarrayadapter);

        myFirebase= FirebaseDatabase.getInstance().getReference("Service History");
        /*myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        String myChildValues=dataSnapshot.getValue(String.class);
                        myarraylist.add(myChildValues);
                        myarrayadapter.notifyDataSetChanged();

                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
       myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String key = snapshot.getKey();
                    if (key.equals(name)) {
                        for (DataSnapshot innersnapshot : snapshot.getChildren()) {


                            String myChildValues = innersnapshot.getValue(String.class);
                            myarraylist.add(myChildValues);
                            myarrayadapter.notifyDataSetChanged();


                        }
                    }
                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myarrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
