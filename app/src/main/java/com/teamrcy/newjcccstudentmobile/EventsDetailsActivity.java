package com.teamrcy.newjcccstudentmobile;

/*
        Copyright (C) 2015 Yvonne Huff, Ron Morgan, Chris Scherrer
        Derivative Work of the Android Open Source Project.
        Changes made to include progress bars, action bars, styles and use of WebViews.
        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
        -*/

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

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

