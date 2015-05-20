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


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;

public class ResourcesDetailsFragment extends Fragment {

    // Create a DetailsFragment that contains the titles for the correct index
    public static ResourcesDetailsFragment newInstance(int index) {
        ResourcesDetailsFragment f = new ResourcesDetailsFragment();

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

        //  USE THIS SECTION FOR STATIC TEXT
        // TextView goes in the ScrollView
       //TextView text = new TextView(getActivity());

        // A TypedValue can hold multiple dimension values which can be assigned dynamically
        // applyDimensions receives the unit type to use which is COMPLEX_UNIT_DIP, which
        // is Device Independent Pixels
        // The padding amount being 4
        // The final part is information on the devices size and density
        //int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                //4, getActivity().getResources().getDisplayMetrics());

        // Set the padding to the TextView
        //text.setPadding(padding, padding, padding, padding);


        String url = ResourcesInfo.DETAILS[getShownIndex()];


        WebView resWebView = new WebView(getActivity());
        WebSettings webSettings = resWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        resWebView.loadUrl(url);
        scroller.addView(resWebView);

        //  USE THIS SECTION FOR STATIC TEXT
        // Add the TextView to the ScrollView
        // Set the currently selected titles to the textView

        return scroller;
    }


}
