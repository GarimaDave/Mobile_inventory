package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Worker_dashboard extends AppCompatActivity {
    private Button logout;
    private Button scan;
    private Button add,stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_dashboard);
        logout=findViewById(R.id.button11);

        scan=(Button)findViewById(R.id.button4);
        stat=(Button)findViewById(R.id.button19);
        //add=(Button)findViewById(R.id.button5);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(Worker_dashboard.this,"Logged out",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Worker_dashboard.this,MainActivity.class));
                startActivity(new Intent(getApplicationContext(),Scan_cam_read.class));
            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Worker_dashboard.this,graph.class);
                startActivity(intent);
            }
        });








        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Worker_dashboard.this,"Logged out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Worker_dashboard.this,MainActivity.class));
            }
        });

    }
}
