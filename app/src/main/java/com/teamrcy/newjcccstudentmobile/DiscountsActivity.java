package com.teamrcy.newjcccstudentmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;


public class DiscountsActivity extends ActionBarActivity implements SearchView.OnQueryTextListener {

    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Just a sec");
        mDialog.setCancelable(false);

        mDialog.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("white")));
        getSupportActionBar().setIcon(R.mipmap.ic_jccc2);
        mDialog.dismiss();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);// inflates action bar with menu elements from my menu
        MenuItem searchItem = menu.findItem(R.id.searchButton); // finds searchButton and assigns it to searchItem
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(searchItem);//typecasts searchItem to a SearchView
        searchView.setQueryHint("Search JCCC.edu:");//sets the query hint.
        searchView.setOnQueryTextListener(this);//activates the query text listener.
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)//
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.jccc.edu/search.html?q=" + query)));
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) { //watches for changes in the text field, not used but necessary for implementation.
        return false;
    }
}