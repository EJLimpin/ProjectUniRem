package com.unirem.unirem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private Button buttonNCI;
    private Button buttonDIT;
    private Button buttonTrinity;
    private Button buttonUCD;
    private Button buttonDCU;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        buttonNCI =(Button) findViewById(R.id.buttonNCI);
        buttonLogout=(Button) findViewById(R.id.buttonLogout);





        //adding listener to button
        buttonNCI.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        if(view == buttonNCI){
            finish();
            //starting login activity
            startActivity(new Intent(this, NCI_eventActivity.class));

        }
        if (view == buttonLogout) {
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
    }


    }
}




