package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Service_history extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
        ListView mlistview=(ListView)findViewById(R.id.listView);

        Service trial=new Service("28-01-2020","29","Moulding");
        ArrayList<Service>servlist=new ArrayList<>();
        servlist.add(trial);
        ServiceListAdapter adapter=new ServiceListAdapter(this,R.layout.adapter_view_layout,servlist);
        mlistview.setAdapter(adapter);
    }
}
