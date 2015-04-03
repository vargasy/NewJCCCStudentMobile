package com.teamrcy.newjcccstudentmobile;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class DiscountActivity extends ActionBarActivity
        implements DiscountTitlesFragment.OnDiscountTitlesSelectedListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount_info);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.discount_titles_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of DiscountTitlesFragment
            DiscountTitlesFragment title = new DiscountTitlesFragment();

            // If this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            title.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.discount_titles_container,
                    title).commit();
        }
    }


    public void onDetailsSelected(int position) {
        //The user selects a title
        DiscountDetailsFragment details = (DiscountDetailsFragment)
                getSupportFragmentManager().findFragmentById(R.id.discount_detail_fragment);

        if (details != null) {
            // If details is available, go to two-pane layout...

            // Call a method in the WellnessDetailsFragment to update its content
            details.updateDetailsView(position);

        } else {
            // If the 'details' is not available, use the one-pane layout and swap fragments

            // Create fragment and give it an argument for the selected detail
            DiscountDetailsFragment newDetails = new DiscountDetailsFragment();
            Bundle args = new Bundle();
            args.putInt(DiscountDetailsFragment.ARG_POSITION, position);
            newDetails.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.discount_titles_container, newDetails);

            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}