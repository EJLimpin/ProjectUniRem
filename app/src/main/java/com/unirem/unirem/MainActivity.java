package com.unirem.unirem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private ImageButton buttonNCI;
    private ImageButton buttonDIT;
    private ImageButton buttonTCD;
    private ImageButton buttonUCD;
    private ImageButton buttonDCU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        buttonNCI = (ImageButton) findViewById(R.id.buttonNCI);
        buttonDIT = (ImageButton) findViewById(R.id.buttonDIT);
        buttonDCU = (ImageButton) findViewById(R.id.buttonDCU);

        //adding listener to button
        buttonNCI.setOnClickListener(this);
        buttonDIT.setOnClickListener(this);
        buttonDCU.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menutwo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_logout) {
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        if (view == buttonNCI) {

            //starting login activity
            startActivity(new Intent(this, Nci_events_PageActivity.class));

        }

        if (view == buttonDIT) {

            //starting login activity
            startActivity(new Intent(this, Dit_events_PageActivity.class));

        }

        if (view == buttonDCU) {

            //starting login activity
            startActivity(new Intent(this, Dcu_events_PageActivity.class));

        }


    }
}




