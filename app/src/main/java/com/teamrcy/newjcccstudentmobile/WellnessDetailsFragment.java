package com.teamrcy.newjcccstudentmobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WellnessDetailsFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.well_details_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check if there are arguments passed to the fragment.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateDetailsView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateDetailsView(mCurrentPosition);
        }
    }

    public void updateDetailsView(int position) {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(WellnessText.Details[position])));
        mCurrentPosition = position;
    }
 /*
        TextView detail = (TextView) getActivity().findViewById(R.id.detail);
        detail.setText */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
