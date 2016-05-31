package com.example.the_java_creed.mbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signUpButton(View view){
        Intent intent = new Intent(this,MainActivity_SignUp.class );
        startActivity(intent);
    }

    public void loginButton(View view)
    {
        Intent intent = new Intent(this,MainActivity.class );
        startActivity(intent);
    }
}
