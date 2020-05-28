package com.example.mobile_inventory_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email=findViewById(R.id.editText4);
        password=findViewById(R.id.editText5);
        register=findViewById(R.id.button8);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(Main2Activity.this,"Empty credentials",Toast.LENGTH_SHORT).show();
                } else if(txt_password.length()<6){
                    Toast.makeText(Main2Activity.this,"Password too short",Toast.LENGTH_SHORT).show();

                }
                else{
                    registeruser(txt_email,txt_password);
                }
            }
        });
    }

    private void registeruser(String txt_email,String txt_password){

        auth.createUserWithEmailAndPassword(txt_email,txt_password).addOnCompleteListener(Main2Activity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Main2Activity.this,"Registering worker successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main2Activity.this,"Registering failed!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
