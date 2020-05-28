package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scan_cam_read extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView ScannerView;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_cam_read);
        ScannerView=(ZXingScannerView)findViewById(R.id.zxscan1);
        txtResult=(TextView)findViewById(R.id.txt_result1);
        //request permission
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                ScannerView.setResultHandler(Scan_cam_read.this);
                ScannerView.startCamera();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(Scan_cam_read.this,"Permission denied",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

            }
        })
                .check();

    }
    protected void onDestroy(){
        ScannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result result) {
        txtResult.setText(result.getText());
        String data=txtResult.getText().toString();

        Intent intent=new Intent(this,Retrieve_layout.class);
        intent.putExtra("abc1",data);
        startActivity(intent);



        //Scan_result_admin.resultview.setText(txtResult.getText());

        //onBackPressed();

    }
}
