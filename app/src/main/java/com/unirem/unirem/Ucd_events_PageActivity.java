package com.unirem.unirem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Ucd_events_PageActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private RecyclerView UCD_event_list;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucd_events__page);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");

        UCD_event_list = (RecyclerView) findViewById(R.id.UCD_event_list);
        UCD_event_list.setHasFixedSize(true);
        UCD_event_list.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add) {

            startActivity(new Intent(Ucd_events_PageActivity.this, AddEventActivity.class));

        }


        if (item.getItemId() == R.id.action_home) {

            startActivity(new Intent(Ucd_events_PageActivity.this, MainActivity.class));

        }

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
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Events, Ucd_events_PageActivity.EventsviewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Events, Ucd_events_PageActivity.EventsviewHolder>(

                Events.class,
                R.layout.event_row,
                Ucd_events_PageActivity.EventsviewHolder.class,
                mDatabase
        ) {

            @Override
            protected void populateViewHolder(Ucd_events_PageActivity.EventsviewHolder viewHolder, Events model, int position) {

                viewHolder.setEvent_Title(model.getEvent_Title());
                viewHolder.setEvent_Details(model.getEvent_Details());
                viewHolder.setEvent_Location(model.getEvent_Location());
                viewHolder.setEvent_Date_and_Time(model.getEvent_Date_and_Time());
                viewHolder.setPrivacytype(model.getPrivacytype());
                viewHolder.setImages(getApplicationContext(), model.getImages());

            }
        };

        UCD_event_list.setAdapter(firebaseRecyclerAdapter);
    }

    private static class EventsviewHolder extends RecyclerView.ViewHolder {

        View mView;

        public EventsviewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        private void setEvent_Title(String Event_Title) {

            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(Event_Title);

        }

        private void setEvent_Details(String Event_Details) {
            TextView post_Details = (TextView) mView.findViewById(R.id.post_Details);
            post_Details.setText(Event_Details);
        }

        private void setEvent_Location(String Event_Location) {
            TextView post_Location = (TextView) mView.findViewById(R.id.post_Locations);
            post_Location.setText(Event_Location);
        }


        private void setEvent_Date_and_Time(String Event_Date_and_Time) {
            TextView post_Date_and_Time = (TextView) mView.findViewById(R.id.post_Date_and_Time);
            post_Date_and_Time.setText(Event_Date_and_Time);
        }

        private void setPrivacytype(String Privacytype) {
            TextView post_privacy = (TextView) mView.findViewById(R.id.post_privacy);
            post_privacy.setText(Privacytype);
        }

        private void setImages(Context ctx, String images) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(images).into(post_image);

        }


    }
}
