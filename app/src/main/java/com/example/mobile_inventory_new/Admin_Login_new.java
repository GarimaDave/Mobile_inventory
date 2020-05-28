package com.example.mobile_inventory_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Login_new extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login_new);
        LoginButton();
    }

    public void LoginButton(){
        username=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById(R.id.editText9);
        login_btn=(Button)findViewById(R.id.button12);
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("admin")&& password.getText().toString().equals(("admin"))){
                            Intent intent=new Intent(Admin_Login_new.this,Admin_dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Admin_Login_new.this,"Entered credentials are wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                }


        );
    }
}
