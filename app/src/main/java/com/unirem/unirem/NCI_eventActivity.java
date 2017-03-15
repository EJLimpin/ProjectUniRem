package com.unirem.unirem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NCI_eventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nci_event);


        btnBack = (Button) findViewById(R.id.btn_back);

        btnBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view == btnBack){
            finish();
            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
