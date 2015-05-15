package com.teamrcy.newjcccstudentmobile;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DiningDetailsFragment extends Fragment {

    // Create a DetailsFragment that contains the titles for the correct index
    public static DiningDetailsFragment newInstance(int index) {
        DiningDetailsFragment f = new DiningDetailsFragment();

        // Bundles are used to pass data using a key "index" and a value
        Bundle args = new Bundle();
        args.putInt("index", index);

        // Assign key value to the fragment
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {

        // Returns the index assigned
        return getArguments().getInt("index", 0);
    }

    // LayoutInflater puts the Fragment on the screen
    // ViewGroup is the view you want to attach the Fragment to
    // Bundle stores key-value pairs so that data can be saved
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create a ScrollView to put your titles in
        ScrollView scroller = new ScrollView(getActivity());

        //  USE THIS SECTION FOR STATIC STRINGS
        // TextView goes in the ScrollView
        /*TextView text = new TextView(getActivity());

        // A TypedValue can hold multiple dimension values which can be assigned dynamically
        // applyDimensions receives the unit type to use which is COMPLEX_UNIT_DIP, which
        // is Device Independent Pixels
        // The padding amount being 4
        // The final part is information on the devices size and density
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());

        // Set the padding to the TextView
        text.setPadding(padding, padding, padding, padding);

       /*  //This section is when you want to use the WebView instead.
        WebView resWebView = new WebView(getActivity());
        WebSettings webSettings = resWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); */

        // Add the TextView to the ScrollView
        String url = DiningInfo.DETAILS[getShownIndex()];

        //This section is when you want to use the WebView instead.
        WebView resWebView = new WebView(getActivity());
        WebSettings webSettings = resWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        resWebView.loadUrl(url);
        scroller.addView(resWebView);

        // Set the currently selected titles to the textView

        //or resWebView.loadUrl(filename.arrayName(getShownIndex()]);
        return scroller;
    }
}
