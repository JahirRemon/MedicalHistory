package com.example.mdjahirulislam.sharedpreferenceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private UserAuthenticationSharedPreference userAuthenticationSharedPreference;


    private EditText nameET;
    private EditText emaiET;
    private EditText passET;

    private String name;
    private String email;
    private String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        nameET = (EditText) findViewById(R.id.userName);
        emaiET = (EditText) findViewById(R.id.userEmail);
        passET = (EditText) findViewById(R.id.userPass);
        userAuthenticationSharedPreference = new UserAuthenticationSharedPreference(this);

    }

    public void registration(View view) {
        name = nameET.getText().toString().trim();
        email = emaiET.getText().toString().trim();
        pass = passET.getText().toString().trim();

        if(name.isEmpty() && email.isEmpty() && pass.isEmpty()){

            Toast.makeText(this, "All field Required", Toast.LENGTH_SHORT).show();

        }else {

            boolean status = userAuthenticationSharedPreference.saveUser(email,pass);

            if (status){
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "Registration Not Successful", Toast.LENGTH_SHORT).show();

            }
        }

    }
}
