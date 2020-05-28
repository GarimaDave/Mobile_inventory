package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Admin_dashboard extends AppCompatActivity{
    Button scan;
    Button add;
    Button stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        scan=(Button)findViewById(R.id.button6);
        add=(Button)findViewById(R.id.button5);
        stat=(Button)findViewById(R.id.button19);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Admin_dashboard.this,"Entered credentials are wrong",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getApplicationContext(),Scan_cam.class));
                startActivity(new Intent(getApplicationContext(),Scan_cam_update.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(Admin_dashboard.this,"Entered credentials are wrong",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Scan_cam.class));
            }
        });
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_dashboard.this,graph.class);
                startActivity(intent);
            }
        });
    }



}
