package com.teamrcy.newjcccstudentmobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebViewLoader extends ActionBarActivity implements SearchView.OnQueryTextListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view_loader2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("white")));
        getSupportActionBar().setIcon(R.mipmap.ic_jccc2);
        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        setTitle(title);
        String url = intent.getExtras().getString("url");
        loadMyWebView(url);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);// inflates action bar with menu elements from my menu
        MenuItem searchItem = menu.findItem(R.id.searchButton); // finds searchButton and assigns it to searchItem
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(searchItem);//typecasts searchItem to a SearchView
        searchView.setQueryHint("Search JCCC.edu:");//sets the query hint.
        searchView.setOnQueryTextListener(this);//activates the query text listener.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
     public boolean onQueryTextChange(String newText) { //watches for changes in the text field, not used but necessary for implementation.
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query)//
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.jccc.edu/search.html?q=" + query)));
        return true;
    }



    public void loadMyWebView (String url) {
        WebView webview = (WebView) findViewById(R.id.MyWebView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }
    public void facebookNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/14080742201")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.facebook.com/JCCC411")));
        }
    }

    public void MapAct(View v)
    {

        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.google.com/maps/place/Johnson+County+Community+College/@38.923939,-94.730303,17z/data=!4m2!3m1!1s0x0:0x448b22c3a320464f?hl=en-US")));

    }

    public void twitterNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=jccctweet")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://twitter.com/jccctweet")));
        }
    }

    public void linkedinNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/johnson-county-community-college")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.linkedin.com/company/johnson-county-community-college")));
        }

    }

    public void youtubeNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://channel/JCCCvideo")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/user/JCCCvideo")));
        }
    }


    public void callPolice(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9134692500"));
        startActivity(intent);
    }
}
