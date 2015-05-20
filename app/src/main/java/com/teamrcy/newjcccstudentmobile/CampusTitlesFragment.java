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

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// Shows the title fragment which is a ListView
// When a ListView item is selected, place the DetailsFragment in the FrameLayout
// if the device is in horizontal mode, otherwise create a DetailsActivity in portrait mode.
public class CampusTitlesFragment extends ListFragment {

    // True or False depending on if the device is in horizontal (dual-pane) mode
    boolean mDualPane;

    // Currently selected item in the ListView
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // An ArrayAdapter connects the array to the ListView
        // getActivity() returns a Context to get the resources needed
        // Pass a default list item text view to put the data into the array.
        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1, CampusInfo.TITLES);

        // Connect the ListView to the data
        setListAdapter(connectArrayToListView);

        // Check if the FrameLayout with the id details exists
        View detailsFrame = getActivity().findViewById(R.id.campus_details);

        // Set mdualPane based on whether the device is in the horizontal layout
        // Check if the detailsFrame exists and if it is visible
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // If the screen is rotated, onSaveInstanceState() below will store the
        // title most recently selected. Get the value attached to curChoice and
        // store it in mCurCheckPosition
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            // CHOICE_MODE_SINGLE allows one item in the ListView to be selected at a time
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

            // Send the item selected to showDetails() so the right details are shown
            showDetails(mCurCheckPosition);
        }
    }

    // Called every time the screen orientation changes or Android kills an Activity to conserve resources
    // Save the last item selected in the list here and attach it to the key "curChoice"
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    // When a list item is clicked, change the details info
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    // Shows the details info
    void showDetails(int index) {

        // The most recently selected title in the ListView is sent
        mCurCheckPosition = index;

        // Check if the device is in horizontal mode. If so, show the ListView and the details
        if (mDualPane) {

            // Make the currently selected item highlighted
            getListView().setItemChecked(index, true);

            // Create an object that represents the current FrameLayout that will show the
            // details data
           CampusDetailsFragment campusDetails = (CampusDetailsFragment)
                    getFragmentManager().findFragmentById(R.id.campus_details);

            // When a DetailsFragment is created by calling newInstance, the index for the data
            // is passed to it. If that index hasn't been assigned, place it in the "if" block
            if (campusDetails == null || campusDetails.getShownIndex() != index) {

                // Make the DetailsFragment and give it the currently selected title index
                campusDetails = CampusDetailsFragment.newInstance(index);

                // Start Fragment transactions
                FragmentTransaction ft = getFragmentManager().beginTransaction()

                        // ADD A SEMI-COLON ABOVE IF YOU DON'T WANT THIS FOR FLIPPING STATIC
                        // TEXT CARDS
                        // Replace the default fragment animations with animator resources representing
                        // rotations when switching to the back of the card, as well as animator
                        // resources representing rotations when flipping back to the front (e.g. when
                        // the system Back button is pressed).
                        .setCustomAnimations(
                                R.animator.card_flip_down_out, R.animator.card_flip_up_in);



                // Replace any other Fragment with our new Details Fragment with the right data
                ft.replace(R.id.campus_details, campusDetails);

                // TRANSIT_FRAGMENT_FADE calls for the Fragment to fade away
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {
            // Launch a new Activity to show our DetailsFragment
            Intent intent = new Intent();


            // Define the class Activity to call
            intent.setClass(getActivity(), CampusDetailsActivity.class);

            // Pass along the currently selected index assigned to the keyword index
            intent.putExtra("index", index);

            // Call for the Activity to open
            startActivity(intent);
        }
    }
}