package com.example.the_java_creed.mbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

    }

    public void BtnReturnMainMenu(View w)
    {
        Intent intMe = new Intent(this, MainActivity.class );
        startActivity(intMe);
    }
}
