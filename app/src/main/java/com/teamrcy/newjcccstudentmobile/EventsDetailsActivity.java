package com.teamrcy.newjcccstudentmobile;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.teamrcy.newjcccstudentmobile.R;

public class EventsDetailsActivity extends ActionBarActivity{
    ProgressDialog mDialog;

@Override
protected void onCreate(Bundle savedInstanceState) {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Working on it...");
        mDialog.setCancelable(false);

        mDialog.show();
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("white")));
        getSupportActionBar().setIcon(R.mipmap.ic_jccc2);
        getSupportActionBar().setTitle("Events");

        // Check if the device is in landscape mode
        if (getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_LANDSCAPE) {
        // If the screen is now in landscape mode, we can show the
        // dialog in-line with the list so we don't need this activity.
        finish();
        return;
        }

        // Check if we have any details data saved
        if (savedInstanceState == null) {

        // If not then create the DetailsFragment
        EventsDetailsFragment Events_details = new EventsDetailsFragment();

        // Get the Bundle of key-value pairs and assign them to the DetailsFragment
        Events_details.setArguments(getIntent().getExtras());

        // Add the Details Fragment
        getFragmentManager().beginTransaction().add(android.R.id.content,
                Events_details).commit();
        mDialog.dismiss();
        }
       }
     }

