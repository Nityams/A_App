package com.example.the_java_creed.mbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import com.firebase.client.*;

public class MainActivity_SignUp extends AppCompatActivity {
    private EditText name,email,password;
    private Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__sign_up);
        name = (EditText)findViewById(R.id.editText);
        email = (EditText)findViewById(R.id.editText2);
        password = (EditText)findViewById(R.id.editText3);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://amber-inferno-1833.firebaseio.com");
    }

    public void buttonOnClickCancel(View v)
    {
        Intent intMe = new Intent(this,Login.class);
        startActivity(intMe);
    }

    public void buttonOnClickSubmit(View v) {
        //String name = findViewById(editText).toString();
        Intent intMe = new Intent(this, MainActivity.class);
        startActivity(intMe);
        // check if filled...
        Log.d("Name:",name.getText().toString());
        Log.d("Email:",email.getText().toString());
        Log.d("Password:",password.getText().toString());
        myFirebaseRef.child("users").child("1").setValue(name.getText().toString());
    }

}
