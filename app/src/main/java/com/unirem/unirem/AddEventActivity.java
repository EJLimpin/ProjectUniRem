package com.unirem.unirem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

import static android.R.attr.data;

public class AddEventActivity extends AppCompatActivity {


    private Button btnCreate, btnCancel;
    private EditText etEventTitle, etEventLocation, etEventDetails, etTime, etDate;
    private ImageButton ibEvent;

    private FirebaseAuth firebaseAuth;

    private static final int Gallery_Request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


      firebaseAuth = FirebaseAuth.getInstance();

        ibEvent = (ImageButton) findViewById(R.id.ibEvent);
        etEventTitle=(EditText) findViewById(R.id.etEventTitle);
        etEventDetails=(EditText) findViewById(R.id.etEventDetails);
        etEventLocation=(EditText) findViewById(R.id.etEventLocation);
        etTime=(EditText) findViewById(R.id.etTime);
        etDate=(EditText) findViewById(R.id.etDate);


        btnCreate =(Button) findViewById(R.id.btnCreate);

        btnCancel =(Button) findViewById(R.id.btnCancel);




        ibEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
               startActivityForResult(galleryIntent,Gallery_Request);

            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==Gallery_Request && resultCode==RESULT_OK){

            Uri imageUri = data.getData();

            ibEvent.setImageURI(imageUri);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.action_home){

            startActivity(new Intent(AddEventActivity.this,MainActivity.class));

        }

        if (item.getItemId()==R.id.action_logout){
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
