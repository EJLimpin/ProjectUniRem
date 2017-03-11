package com.unirem.unirem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewLogin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        //initialise
        firebaseAuth = firebaseAuth.getInstance();
        //initialise
        progressDialog = new ProgressDialog(this);

        //initialise
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);


        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);



    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty check
            Toast.makeText(this, "Please entre an email", Toast.LENGTH_SHORT).show();
            //return will stop the function from executing further
            return;
        }
        if(TextUtils.isEmpty(password)){
            //if password is empty check
            Toast.makeText(this, "Please entre a Password", Toast.LENGTH_SHORT).show();
            //return will stop the function from executing further
            return;
        }
        //if everything is ok
        //we will show a progress dialog
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        progressDialog.dismiss();


        //then we tell firebase to create users
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //if statement to see if the task was successful
                        if(task.isSuccessful()){
                            //isplay message to show that your are registered
                            Toast.makeText(UserRegisterActivity.this,"Register Successful", Toast.LENGTH_LONG).show();
                            return;

                        }else {
                            Toast.makeText(UserRegisterActivity.this,"coudn't Register, please try again!", Toast.LENGTH_LONG).show();
                            return;

                        }
                    }
                });


    }


    @Override
    public void onClick(View v) {

        if(v == buttonRegister){
            registerUser();

        }
        if(v == textViewLogin){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
