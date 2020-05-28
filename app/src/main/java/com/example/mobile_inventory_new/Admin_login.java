package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        LoginButton();
    }
    public void LoginButton(){
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText6);
        login_btn=(Button)findViewById(R.id.button9);
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("admin")&& password.getText().toString().equals(("admin"))){
                            Intent intent=new Intent("android.intent.action.Admin_dashboard");
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Admin_login.this,"Entered credentials are wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                }


        );
    }
}
