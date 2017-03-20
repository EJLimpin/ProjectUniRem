package com.unirem.unirem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;



public class AddEventActivity extends AppCompatActivity {

    private Button btnCreate, btnCancel;
    private EditText etEventTitle, etEventLocation, etEventDetails;
    private ImageButton ibEvent;
    private Uri ibEventUri= null;
    private TextView tvDropdown;

    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;


    private FirebaseAuth firebaseAuth;

    private static final int Gallery_Request = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


      firebaseAuth = FirebaseAuth.getInstance();

        tvDropdown=(TextView) findViewById(R.id.tvDropdown);
        ibEvent = (ImageButton) findViewById(R.id.ibEvent);
        etEventTitle=(EditText) findViewById(R.id.etEventTitle);
        etEventDetails=(EditText) findViewById(R.id.etEventDetails);
        etEventLocation=(EditText) findViewById(R.id.etEventLocation);


        //spinner that will hold the privacy type
        spinner =(Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.Privacy_type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


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

                startPosting();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEventActivity.this,Nci_events_PageActivity.class));
            }
        });

    }

    private void startPosting() {

        String etEventTitle_val = etEventTitle.getText().toString().trim();
        String etEventLocation_val =etEventLocation.getText().toString().trim();
        String etEventDetails_val =etEventDetails.getText().toString().trim();
        //int etTime_val =
        //int etDate_val =
        //String spinner_val = spinner.getT

        if (!TextUtils.isEmpty(etEventTitle_val) && !TextUtils.isEmpty(etEventLocation_val) && !TextUtils.isEmpty(etEventDetails_val)
                && ibEventUri !=null){


        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==Gallery_Request && resultCode==RESULT_OK){

            ibEventUri = data.getData();

            ibEvent.setImageURI(ibEventUri);

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
